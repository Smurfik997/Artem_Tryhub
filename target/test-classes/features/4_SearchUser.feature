@SearchByUsername
Feature: Search user by username
  Scenario: Admin can find user by existing username
    Given I am at the users page
    And I entered "JohnSmithUser" in the username search field
    When I click "Search" button
    Then I will see one result with specified username

  Scenario: Admin cannot find not existing user
    Given I am at the users page
    And I entered "Abrakadabra" in the username search field
    When I click "Search" button
    Then I will see no results

  Scenario: Admin can select user by username from table
    Given I am at the users page
    And I want to select user row with "JohnSmithUser" username
    And this user exists in table
    When I click on the checkbox
    Then row with this user will be selected