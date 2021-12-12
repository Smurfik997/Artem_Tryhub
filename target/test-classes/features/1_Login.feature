@Login
Feature: Login
  Background:
    Given I am filling credentials at the login page

  Scenario: Successfully authorize with valid username and password
    Given I entered "Admin" in the username field
    And I entered "admin123" in the password field
    When I click on the "Login" button
    And my credentials is valid
    Then I will be successfully authenticated

  Scenario: User will see error message if credentials is invalid
    Given I entered "Abrakadabra" in the username field
    And I entered "admin123" in the password field
    When I click on the "Login" button
    And my username or password is invalid
    Then I will be see error message "Invalid credentials"

  Scenario: Username field must be filled
    Given I left username field empty
    When I click on the "Login" button
    Then I will be see error message "Username cannot be empty"

  Scenario: Password field must be filled
    Given I left password field empty
    And username field is not empty
    When I click on the "Login" button
    Then I will be see error message "Password cannot be empty"