@DeleteUser
Feature: Delete user by username
  Scenario: Admin can delete user by username
    Given I am at the users page
    And I want to delete user with "JohnSmithUser" username
    And this user exists at current table
    And I selected row with this user
    When I click on delete button
    And I confirmed deleting
    Then user successfully removes from table and system