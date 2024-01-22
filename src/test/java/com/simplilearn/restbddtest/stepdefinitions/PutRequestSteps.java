package com.simplilearn.restbddtest.stepdefinitions;

import static org.hamcrest.CoreMatchers.equalTo;

import com.simplilearn.restbddtest.data.model.User;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PutRequestSteps {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String BASE_URL = "https://reqres.in/api";
	
	@Given("a user update APIs is available")
	public void a_user_update_ap_is_is_available() {
		request = RestAssured.given().baseUri(BASE_URL);
	}

	@When("a user should exist with userId {string} name {string} and job {string} in the system")
	public void a_user_should_exist_with_user_id_name_and_job_in_the_system(String userId , String name, String job) {
		User user = new User(name, job);
		response =  request.pathParam("userId", userId).contentType(ContentType.JSON).body(user)
					.when().put("/users/{userId}");
	}


	@Then("update user request should return a reponse with a {int} status code")
	public void update_user_request_should_return_a_reponse_with_a_status_code(Integer statusCode) {
		json = response.then().statusCode(statusCode);
	}

	@Then("updated user reponse should contains  name {string} and job {string} values")
	public void update_user_reponse_contains_and_value(String name, String job) {
		 json.assertThat()
		    .body("name", equalTo(name)).and()
		    .body("job", equalTo(job));
	}

}
