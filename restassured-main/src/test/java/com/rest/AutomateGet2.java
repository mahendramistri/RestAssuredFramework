package com.rest;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AutomateGet2 {

    @Test
    public void validate_status_code(){
        given().
                baseUri("https://api.postman.com").
                header("X-Api-Key", "PMAK-61c5ae16afa36a0046f74da4-455153c589632da5987d339c6365354011").
        when().
                get("/workspaces").
        then().
                log().all().
                assertThat().
                statusCode(200);
    }

  
}
