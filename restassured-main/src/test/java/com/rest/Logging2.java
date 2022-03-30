package com.rest;

import io.restassured.config.LogConfig;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

public class Logging2 {

    @Test
    public void request_response_logging(){
        given().
                baseUri("https://api.postman.com").
                header("X-Api-Key", "PMAK-61c5ae16afa36a0046f74da4-455153c589632da5987d339c6365354011").
                log().all().
        when().
                get("/workspaces").
        then().
                log().all().
                assertThat().
                statusCode(200);
    }

  }
