package com.rest;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class AutomateHeaders3 {


    @Test
    public void extract_multivalue_response_header(){
        HashMap<String, String> headers = new HashMap<String, String>();
       // headers.put("header", "value1");
      //  headers.put("x-mock-match-request-headers", "header");

        Headers extractedHeaders = given().
                baseUri("https://8f6d7436-aba9-4c1f-bc81-fdc881a11fb1.mock.pstmn.io").
                headers(headers).
        when().
                get("/get").
        then().
                assertThat().
                statusCode(200).
                extract().
                headers();

        List<String> values = extractedHeaders.getValues("multiValueHeader");
        for(String value:values){
            System.out.println(value);
        }
    }
}
