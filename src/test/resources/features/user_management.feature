Feature: User Management
  As a system administrator
  I want to manage users
  So that I can maintain user accounts properly

  Scenario: Create a valid user
    Given a new user with id "1", name "John Doe" and email "john@example.com"
    When I try to create the user
    Then the user should be created successfully
    And the user should exist in the system

  Scenario: Create user with invalid email
    Given a new user with id "1", name "John Doe" and email "invalid-email"
    When I try to create the user
    Then the user creation should fail
    And the user should not exist in the system

  Scenario: Create user with invalid name
    Given a new user with id "1", name "" and email "john@example.com"
    When I try to create the user
    Then the user creation should fail
    And the user should not exist in the system

  Scenario: Create duplicate user
    Given a new user with id "1", name "John Doe" and email "john@example.com"
    And the user is already created
    When I try to create another user with the same id
    Then the user creation should fail

  Scenario: Update existing user
    Given a user exists with id "1", name "John Doe" and email "john@example.com"
    When I update the user with name "John Smith" and email "john.smith@example.com"
    Then the update should be successful
    And the user details should be updated

  Scenario: Update non-existent user
    Given no user exists with id "1"
    When I update the user with name "John Smith" and email "john@example.com"
    Then the update should fail 