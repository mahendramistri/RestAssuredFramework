package com.rest;


import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class AutomateGet7 {

    @Test
    public void hamcrest_assert_on_extracted_response(){
        String name = given().
                baseUri("https://api.postman.com").
                header("X-Api-Key", "PMAK-61c5ae16afa36a0046f74da4-455153c589632da5987d339c6365354011").
        when().
                get("/workspaces").
        then().log().all().
                assertThat().
                statusCode(200).
                extract().
                response().path("workspaces[0].name");
        System.out.println("workspace name = " + name);

     //   assertThat(name, equalTo("Team Workspace1"));
        Assert.assertEquals(name, "My Workspace");
          //System.out.println("workspace name = " + JsonPath.from(res).getString("workspaces[0].name"));
          //System.out.println("workspace name = " + JsonPath.getString("workspaces[0].name"));
        //    System.out.println("workspace name = " + res.path("workspaces[0].name"));
    }
}
