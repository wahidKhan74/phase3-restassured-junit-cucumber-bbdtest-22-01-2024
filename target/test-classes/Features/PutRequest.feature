#Author: wahid
@smoketest
Feature: Update users
  I want to test udate user functionality

  @Restfull @smoketest @post
  Scenario Outline: Admin should be able to update a existing user
    Given a user update APIs is available
    When a user should exist with userId "<userid>" name "<name>" and job "<job>" in the system
    Then update user request should return a reponse with a 200 status code
    And updated user reponse should contains  name "<name>" and job "<job>" values

    Examples: 
      | userid | name              | job    |
      |      1 | John Snow         | Actors |
      |      2 | Emma Stone        | Actors |
      |      3 | Jennifer Lawrence | Actors |
      |      4 | Will Smith        | Actors |
