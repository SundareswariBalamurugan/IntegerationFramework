package org.e2e.steps.backEnd;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.e2e.contexts.TestContext;
import org.e2e.dataproviders.CustomObjectMapper;
import org.e2e.domains.CompanyEmployee;
import org.e2e.utils.DataLoadingUtil;
import org.e2e.utils.Restutil;
import org.testng.Assert;


public class CompanyEmployeeDetails {



    TestContext testContext;
    public CompanyEmployeeDetails() {
        this.testContext = new TestContext();
    }

    @Given("User send a GET request to fetch all the employee details")
    public void user_send_a_get_request_to_fetch_all_the_employee_details() throws JsonProcessingException {
        String status ="OK";

        RequestSpecification request = RestAssured.given().baseUri("https://interview-test.sandbox.wegift.io/company");
        Response response = request.when()
                .get().then().assertThat()
                .statusCode(HttpStatus.SC_OK).extract().response();
        System.out.println(" response is" + response.getBody().prettyPrint());

        CompanyEmployee companyEmployee = CustomObjectMapper.getInstance().readValue(response.getBody().asString(), CompanyEmployee.class);
        System.out.println(" response is" + response.getBody().prettyPrint());
        testContext.setStatus(companyEmployee.getStatus());
        System.out.println(" response is" + testContext.getStatus());
        Assert.assertEquals(testContext.getStatus(),status);

    }
}
