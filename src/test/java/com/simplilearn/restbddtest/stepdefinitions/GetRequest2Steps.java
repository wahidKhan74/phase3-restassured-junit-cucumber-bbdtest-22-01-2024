package com.simplilearn.restbddtest.stepdefinitions;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class GetRequest2Steps {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String BASE_URL = "https://reqres.in/api";

	@Given("a user should exist with an id of {int}")
	public void a_user_should_exist_with_an_id_of(Integer userId) {
		request = RestAssured.given().baseUri(BASE_URL).pathParam("userId", userId);

	}

	@When("a user retrieved by userid")
	public void a_user_retrieved_by_userid() {
		response = request.when().get("/users/{userId}");
	}

	@Then("validate the outcomes status code is {int}")
	public void validate_the_outcomes_status_code_is(Integer statusCode) {
		json = response.then().statusCode(statusCode);
	}

	@Then("check outcomes response with following")
	public void check_outcomes_response_with_following(DataTable dataTable) {
		// json.log().all();
		List<Map<String, String>> responsFields = dataTable.asMaps();
		// iterate over list (list of map)
		for (Map<String, String> res : responsFields) {
			// iterate over the map
			for (Map.Entry<String, String> entry : res.entrySet()) {
				String key = entry.getKey();
				String val = entry.getValue();
				System.out.println(key + "   ,  "+val);
				json.body("data."+key, equalTo(val));
			}
		}
	}
}
