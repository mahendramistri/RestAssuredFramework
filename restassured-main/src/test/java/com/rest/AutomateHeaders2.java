package com.rest;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class AutomateHeaders2 {

    @Test
    public void multiple_headers(){
        //Header header = new Header("header", "value1");
        Header header = new Header("name","value");
        Header matchHeader = new Header("x-mock-match-request-headers", "header");
        given().
                baseUri("https://8f6d7436-aba9-4c1f-bc81-fdc881a11fb1.mock.pstmn.io").
                header(header).
                header(matchHeader).
        when().
                get("/get").
        then().
                log().all().
                assertThat().
                statusCode(200);
    }
}
