package com.simplilearn.restbddtest.stepdefinitions;

import static org.hamcrest.CoreMatchers.equalTo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetRequestSteps {

	private Response reponse;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String BASE_URL = "https://reqres.in/api";

	@Given("^I want to get a list of all users$")
	public void i_want_to_get_a_list_of_all_users() {
		request = RestAssured.given().baseUri(BASE_URL);
	}

	@Given("^add paginated request \"([^\"]*)\"$")
	public void add_paginated_request_page(String page) {

		reponse = request.when().get("/users?page=" + page);

	}

	@When("I got the  list of users for page {int}")
	public void i_want_to_get_a_list_of_all_users_for_page(Integer page) {
		// paginated response params
		int total_pages = 2, per_page = 6, total = 12;
		
		reponse.then()
		.and().assertThat()
		.body("page", equalTo(page)).and()
		.body("total", equalTo(total)).and()
		.body("per_page", equalTo(per_page)).and()
		.body("total_pages", equalTo(total_pages));
	}
	

	@Then("the request response has a {int} response code")
	public void the_request_response_has_a_response_code(Integer statusCode) {
		reponse.then().statusCode(statusCode);
	}
}
