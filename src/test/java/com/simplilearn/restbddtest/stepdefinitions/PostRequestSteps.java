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

public class PostRequestSteps {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String BASE_URL = "https://reqres.in/api";
	
	@Given("a create new user APIs is available")
	public void a_create_new_user_ap_is_is_available() {
		request = RestAssured.given().baseUri(BASE_URL);
	}

	@When("I add a new user {string} and {string} to the system")
	public void i_add_a_new_user_and_to_the_system(String name, String job) {
		User user = new User(name, job);
		response =  request.contentType(ContentType.JSON).body(user)
					.when().post("/users");
	}
	
	@Then("the user request should return a reponse with a {int} status code")
	public void the_user_request_should_return_a_reponse_with_a_status_code(Integer statusCode) {
		json = response.then().statusCode(statusCode);
	}

	@Then("the user reponse contains  {string} and {string} int the response json data")
	public void the_user_reponse_contains_and_int_the_response_json_data(String name, String job) {
	    json.assertThat()
	    .body("name", equalTo(name)).and()
	    .body("job", equalTo(job));
	}
}
