package com.rest;

import io.restassured.config.LogConfig;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;

public class Logging4 {


    @Test
    public void log_only_if_validation_fails(){
        given().
                baseUri("https://api.postman.com").
                header("X-Api-Key", "PMAK-61c5ae16afa36a0046f74da4-455153c589632da5987d339c6365354011").
                config(config.logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails())).
                //            log().ifValidationFails().
        when().
                get("/workspaces").
        then().
               log().ifValidationFails().
                assertThat().
                statusCode(201);
    }

  
}
