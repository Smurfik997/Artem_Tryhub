@AddUser
Feature: Add User
  Scenario: Admins can create new user with ESS role
    Given I am filling user data at the "Create user" page
    And I filled all fields
      | User Role | Employee Name | Username      | Status  | Password     | Confirm Password |
      | ESS       | John Smith    | JohnSmithUser | Enabled | password123  | password123      |
    And field data is valid
    When I click on "Save" button
    Then user successfully creates

  Scenario: New user cannot be created with invalid data
    Given I am filling user data at the "Create user" page
    And I filled all fields
      | User Role | Employee Name | Username      | Status  | Password     | Confirm Password |
      | ESS       | Abram Lincoln | JohnSmithUser | Enabled | password123  | password123      |
    And field data is invalid
    When I click on "Save" button
    Then I will see error message