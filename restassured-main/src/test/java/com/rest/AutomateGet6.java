package com.rest;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AutomateGet6 {

  
   
    @Test
    public void extract_single_value_from_response(){
        String name = given().
                baseUri("https://api.postman.com").
                header("X-Api-Key", "PMAK-61c5ae16afa36a0046f74da4-455153c589632da5987d339c6365354011").
        when().
                get("/workspaces").
        then().
                assertThat().
                statusCode(200).
                extract().
                response().path("workspaces[0].name");
        System.out.println("workspace name = " + name);
     //   System.out.println("workspace name = " + JsonPath.from(res).getString("workspaces[0].name"));
    //    System.out.println("workspace name = " + jsonPath.getString("workspaces[0].name"));
    //    System.out.println("workspace name = " + res.path("workspaces[0].name"));
    }
}
