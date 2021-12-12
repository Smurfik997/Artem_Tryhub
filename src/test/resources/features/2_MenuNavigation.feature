@MenuNavigation
Feature: Menu navigation
  Scenario: User should have ability to navigate by using first menu level
    Given I am at the "Authenticated user" page
    When I click on the "Admin" button at the first menu level
    Then I will be redirected to "Admin" page

  @AtAdminPage
  Scenario: User can navigate to page by using third menu level
    Given I am at the "Admin" page
    And I hover mouse over "User Management" menu button
    When I click on the "Users" button at the third menu level
    Then I will be redirected to "Users" page