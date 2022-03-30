package com.rest;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class MatcherTest {

   @Test
    public void validate_response_body_matcher(){
        given().
                baseUri("https://api.postman.com").
                header("X-Api-Key", "PMAK-61c5ae16afa36a0046f74da4-455153c589632da5987d339c6365354011").
        when().
                get("/workspaces").
        then().
                log().all().
                assertThat().
                statusCode(200).
                body("workspaces.name", hasItems("My Workspace", "Day1"),
                        "workspaces.type", hasItems("personal", "team"),
                        "workspaces[0].name", equalTo("My Workspace"),
                        "workspaces[0].name", is(equalTo("My Workspace")),
                        "workspaces.size()", equalTo(2),
                        "workspaces.name", hasItem("My Workspace")
                );
    }

    @Test
    public void validate_response_body_hamcrest_learnings_matcher(){
        given().
                baseUri("https://api.postman.com").
                header("X-Api-Key", "PMAK-61c5ae16afa36a0046f74da4-455153c589632da5987d339c6365354011").
        when().
                get("/workspaces").
        then().
 //               log().all().
                assertThat().
                statusCode(200).
                body("workspaces.name", containsInAnyOrder("My Workspace", "Day1"),
                        "workspaces.name", is(not(emptyArray())),
                        "workspaces.name", hasSize(2),
 //                       "workspaces.name", everyItem(startsWith("My"))
                        "workspaces[0]", hasKey("id"),
                        "workspaces[0]", hasValue("My Workspace"),
                        "workspaces[0]", hasEntry("id", "54ace314-ae05-4099-8e22-a4e582728562"),
                        "workspaces[0]", not(equalTo(Collections.EMPTY_MAP)),
                        "workspaces[0].name", allOf(startsWith("My"), containsString("Workspace"))
                );
    }
   
}
