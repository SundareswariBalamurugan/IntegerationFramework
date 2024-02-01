package org.e2e.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import com.google.common.net.HttpHeaders;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.e2e.contexts.TestContext;
import org.e2e.dataproviders.CustomObjectMapper;
import org.e2e.domains.DogDetails;
import org.e2e.utils.RestHelperUtil;
import org.e2e.utils.Restutil;
import org.junit.jupiter.api.Assertions;
import org.e2e.constant.HeadersSetup;


import java.util.List;

import static com.google.common.net.HttpHeaders.*;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpHeaders.CONTENT_TYPE;


@Slf4j
public class PetShopSteps {

    private final Restutil restutil;
    private final TestContext testContext;

     private static final Headers headers = new Headers(new Header(CONTENT_TYPE,JSON.toString()));

     private static final String BASEURIPATH = "employee_dummy_base_url";




    public PetShopSteps() {
        this.restutil = new Restutil();
        this.testContext = new TestContext();
    }

    @Given("Added a new pet to the store")
    public void added_a_new_pet_to_the_store() throws JsonProcessingException {

        String payload = CustomObjectMapper.getInstance().writeValueAsString(DogDetails.generate());
        testContext.setPayload(payload);
        testContext.setHeaders(Headers.headers(new Header(CONTENT_TYPE, JSON.toString()), new Header(HeadersSetup.API_KEY, "")));
        Response response = restutil.post(testContext);
        testContext.setResponse(response);
    }


    @Given("new POST response should be validated against the input")
    public void new_post_response_should_be_validated_against_the_input() throws JsonProcessingException {
        log.info(" context is" + testContext.getResponse().getBody().prettyPrint());
        DogDetails dogDetailsRequest = CustomObjectMapper.getInstance().readValue(testContext.getPayload(), DogDetails.class);
        DogDetails dogDetailsResponse = CustomObjectMapper.getInstance().readValue(testContext.getResponse().getBody().asString(), DogDetails.class);
        log.info("values to be compared is " + dogDetailsRequest.getId() + "-->" + dogDetailsResponse.getId());
        Assertions.assertTrue(dogDetailsRequest.getId() == dogDetailsResponse.getId());
        testContext.setPetId(dogDetailsResponse.getId());
        testContext.setName(dogDetailsResponse.getName());
        testContext.setStatus(dogDetailsResponse.getStatus());

    }


    @When("a GET request is sent to find the {string} pets")
    public void a_get_request_is_sent_to_find_the_pets(String status) {
        String param = ("/pet/findByStatus?status=" + status);


        try {
            Response response = restutil.get(BASEURIPATH,param, headers);
            List<DogDetails> dogDetailsAvailable;
            dogDetailsAvailable = CustomObjectMapper.getInstance().readValue(response.getBody().asString(), new TypeReference<List<DogDetails>>() {
            });
            RestHelperUtil.validateValueinList(dogDetailsAvailable,  testContext.getPetId());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @When("a GET request is sent to fetch a particular pet id")
    public void a_get_request_is_sent_to() {
        String param = ("/pet/" + testContext.getPetId());
        try {
            Response response = restutil.get(BASEURIPATH,param,headers);
            DogDetails dogDetailsGetResponse = CustomObjectMapper.getInstance().readValue(response.getBody().asString(), DogDetails.class);
            RestHelperUtil.validateValueinResponse(dogDetailsGetResponse, testContext.getName());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    @Then("a PUT request to update my pet details {string} and {string}")
    public void a_put_request_to_update_my_pet_details_and(String name, String status) throws JsonProcessingException {
        String param = ("/pet/");
        DogDetails dogDetails = CustomObjectMapper.getInstance().readValue(testContext.getPayload(), DogDetails.class);
        dogDetails.setStatus(status);
        dogDetails.setName(name);

        testContext.setPayload(CustomObjectMapper.getInstance().writeValueAsString(dogDetails));
        Response response = restutil.put(testContext, param);
        DogDetails dogDetailsPutResponse = CustomObjectMapper.getInstance().readValue((response.body().asString()),DogDetails.class);
        RestHelperUtil.validateValueinResponse(dogDetailsPutResponse,name);
    }

    @Then("A Delete request to delete my pet details")
    public void a_delete_request_to_delete_my_pet_details() {
        String param = ("/pet/" + testContext.getPetId());
       restutil.delete(testContext,param);


    }


}