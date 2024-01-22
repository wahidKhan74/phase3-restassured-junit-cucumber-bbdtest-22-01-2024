#Author: wahid@.com
@smoketest
Feature: Verify GET Operation by BDD with Rest Assured using Cucumber
  I want to test a Rest endpoint with BBD approach by rest assured and cucumber

  @Restfull @smoketest @get
  Scenario: Get all users list page 1
    Given I want to get a list of all users
    And add paginated request "1"
    When I got the  list of users for page 1
    Then the request response has a 200 response code

  @Restfull @smoketest @get
  Scenario: Get all users list page 2
    Given I want to get a list of all users
    And add paginated request "2"
    When I got the  list of users for page 2
    Then the request response has a 200 response code
