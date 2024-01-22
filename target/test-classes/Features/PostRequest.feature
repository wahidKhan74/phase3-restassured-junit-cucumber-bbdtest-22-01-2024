#Author: wahid
@smoketest
Feature: Add users
  I want to test add user functionality

  @Restfull @smoketest @post
  Scenario Outline: Admin should be able to add a new user
    Given a create new user APIs is available
    When I add a new user "<name>" and "<job>" to the system
    Then the user request should return a reponse with a 201 status code
    And the user reponse contains  "<name>" and "<job>" int the response json data

    Examples: 
      | name              | job      |
      | John Snow         | Actors |
      | Emma Stone        | Actors |
      | Jennifer Lawrence | Actors |
      | Will Smith        | Actors |
