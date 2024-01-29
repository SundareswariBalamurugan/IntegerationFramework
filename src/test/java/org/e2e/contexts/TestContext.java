package org.e2e.contexts;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.e2e.domains.DogDetails;


@Data
@NoArgsConstructor
public class TestContext {

     Headers headers;
     Response response;
     String payload;
     String status;
     int statusCode;
     long petId;
     String name;
}
