package org.e2e.steps.backEnd;


import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.e2e.constant.HeadersSetup;
import org.e2e.constant.QueryParamSetup;
import org.e2e.contexts.TestContext;
import org.e2e.dataproviders.CustomObjectMapper;
import org.e2e.modal.Minutely;
import org.e2e.modal.Root;
import org.e2e.modal.Weather;
import org.e2e.utils.DataLoadingUtil;
import org.e2e.utils.RestHelperUtil;
import org.e2e.utils.Restutil;

import java.time.LocalDate;
import java.util.TimeZone;

import static org.e2e.utils.RestHelperUtil.*;

public class WeatherForecastSteps {

    final QueryParamSetup queryParamSetup;
    final DataLoadingUtil dataLoadingUtil;


    final TestContext testContext;
    final HeadersSetup headersSetup;
    final Restutil restUtil;
    final RestHelperUtil restHelperUtil;

    public WeatherForecastSteps() {
        this.testContext = new TestContext();
        this.restHelperUtil = new RestHelperUtil();
        this.dataLoadingUtil = new DataLoadingUtil();
        this.queryParamSetup = new QueryParamSetup();
        this.headersSetup = new HeadersSetup();
        this.restUtil = new Restutil();


    }

    public static final String API_KEY = "f31ef9d21664c519ac434bbf3a57b979";

    @Given("Get London forecast details from open API weather")
    public void get_london_forecast_details_from_open_api_weather() {
        String baseUrl = dataLoadingUtil.fetchConfigValue("weather_base_url");
        queryParamSetup.setLatVal(Float.parseFloat(dataLoadingUtil.fetchConfigValue("lon_lat")));
        queryParamSetup.setLongVal(Float.parseFloat(dataLoadingUtil.fetchConfigValue("lon_long")));
        try {
            Response response = restUtil.get(Request(baseUrl, headersSetup.CONTENT_TYPE, getQueryparams()));
            testContext.setResponse(response);
            testContext.setStatusCode(response.getStatusCode());
            testContext.setStatus(response.getStatusLine());
        }catch (Exception e){
             throw e;
        }

    }

    @When("the response code is {int}")
    public void the_response_code_is(Integer statusCode) {
        restHelperUtil.validateValueinResponse(statusCode,testContext.getStatusCode());
    }

    @Then("I can validate whether the response contains London weather")
    public void i_can_validate_whether_the_response_contains_london_weather() throws JsonProcessingException {
        Root root = CustomObjectMapper.getInstance().readValue(testContext.getResponse().asString(), Root.class);

        String actValue= String.valueOf(queryParamSetup.getLatVal());
        String expValue = String.valueOf(root.getLat());
        restHelperUtil.validateValueinResponse(actValue,expValue);
        restHelperUtil.validateValueinResponse(root.getTimezone(), String.valueOf(TimeZone.getDefault().toZoneId()));

        //VALIDATIONS THAT CAN BE DONE
        restHelperUtil.getSizeOfJsonArray(root,"Weather");
        restHelperUtil.getSizeOfJsonArray(root,"Minutely");
        restHelperUtil.getSpecificRecordOfJsonArray(root,2,"Minutely");
        restHelperUtil.getAllRecordsOfJsonArray(root,"Weather");

    }
}
