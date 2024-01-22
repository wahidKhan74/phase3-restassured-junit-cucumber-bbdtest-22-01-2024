#Author: wahid
@tag
Feature: Delete user
  I want to delete user details by userId

  @Restfull @delete
  Scenario: Delete user by userId
    Given a user api should exist for delete
    When a user deleted by userid 12
    Then validate delete request outcomes status code is 204
