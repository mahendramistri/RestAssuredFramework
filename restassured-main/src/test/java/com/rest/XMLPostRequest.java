package com.rest;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class XMLPostRequest {

	@Test
	void validateXMLResponse() {

		RestAssured.baseURI = "https://run.mocky.io/v3";
		given().accept(ContentType.XML)
				.then().log().all()
				.body("courses.subject.name", Matchers.hasItems("Rest Assured", "Postman")).and()
				.body("courses.subject.price", Matchers.hasItems("10", "6"));
	}

	@Test
	public void xmlPostRequest_Test() {
		RestAssured.baseURI = "http://localhost:8006";
		String requestBody = "<client>\r\n" + " <clientNo>100</clientNo>\r\n" + " <name>Tom Cruise</name>\r\n"
				+ " <ssn>124-542-5555</ssn>\r\n" + "</client>";
		Response response = null;
		response = given().contentType(ContentType.XML).accept(ContentType.XML).body(requestBody).when()
				.post("/addClient");

		System.out.println("Post Response :" + response.asString());
		System.out.println("Status Code :" + response.getStatusCode());
		System.out.println("Does Reponse contains '100 Tom Cruise 124-542-5555'? :"
				+ response.asString().contains("100 Tom Cruise 124-542-5555"));
	}
}