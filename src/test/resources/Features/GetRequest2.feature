#Author: wahid
@tag
Feature: Get One user
  I want to get user details by userId

  @Restfull @get
  Scenario: Get user by userId
    Given a user should exist with an id of 12
    When a user retrieved by userid 
    Then validate the outcomes status code is 200
    And check outcomes response with following
      | email | first_name | last_name |
      | rachel.howell@reqres.in | Rachel | Howell |
