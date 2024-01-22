package com.simplilearn.restbddtest.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DeleteRequestSteps {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String BASE_URL = "https://reqres.in/api";
	
	@Given("a user api should exist for delete")
	public void a_user_api_should_exist_for_delete() {
		request = RestAssured.given().baseUri(BASE_URL);
	}

	@When("a user deleted by userid {int}")
	public void a_user_deleted_by_userid(Integer userId) {
		response = request.pathParam("userId", userId).when().delete("/users/{userId}");

	}

	@Then("validate delete request outcomes status code is {int}")
	public void validate_delete_request_outcomes_status_code_is(Integer statusCode) {
		response.then().statusCode(statusCode);
	}
}
