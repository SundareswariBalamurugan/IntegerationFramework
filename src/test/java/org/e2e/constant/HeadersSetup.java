package org.e2e.constant;

import com.google.common.net.HttpHeaders;
import io.restassured.http.ContentType;
import io.restassured.http.Header;

public class HeadersSetup {

    public static final String API_KEY = "X-Api-Key";
    public static final String AUTHORIZATION = "Authorization";

    public static final Header CONTENT_TYPE = new Header(HttpHeaders.CONTENT_TYPE,"application/json");


}
