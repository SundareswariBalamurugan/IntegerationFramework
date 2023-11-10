package org.e2e.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.common.net.HttpHeaders;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.e2e.contexts.TestContext;
import org.testng.Assert;


import static io.restassured.http.ContentType.JSON;

public class Restutil {

    static final DataLoadingUtil dataLoadUtil = new DataLoadingUtil();

    public Response post(TestContext testContext) {
        RequestSpecification request = RestAssured.given().baseUri(dataLoadUtil.fetchConfigValue("employee_dummy_base_url"));
        request.headers(testContext.getHeaders()).body(testContext.getPayload());
        // request.headers(HttpHeaders.CONTENT_TYPE, JSON,HttpHeaders.CONTENT_TYPE, JSON,HttpHeaders.CONTENT_TYPE, JSON)
        Response response = request.post("/pet");
        Assert.assertEquals(HttpStatus.SC_OK, response.statusCode());
        return response;

    }

    public Response get() {
        RequestSpecification request = RestAssured.given().baseUri(dataLoadUtil.fetchConfigValue("customer_base_url"));
        Response response = request.when()
                .get().then().assertThat()
                .statusCode(HttpStatus.SC_OK).extract().response();
        return response;
    }

    public Response put(TestContext testContext, String param) {
        Response response = RestAssured.given().baseUri(dataLoadUtil.fetchConfigValue("employee_dummy_base_url")).
                header(HttpHeaders.CONTENT_TYPE, JSON).
                body(testContext.getPayload()).put(param);
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
        return response;
    }

    public void delete(TestContext testContext, String param) {
        RequestSpecification request = RestAssured.given().baseUri(dataLoadUtil.fetchConfigValue("employee_dummy_base_url"));
        Response response = request.header(HttpHeaders.CONTENT_TYPE, JSON).when()
                .delete(param).then().assertThat()
                .statusCode(HttpStatus.SC_OK).extract().response();

    }
}
