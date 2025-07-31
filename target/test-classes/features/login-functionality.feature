Feature: Login Functionality
  Scenario: Login with valid credentials
    Given User navigated to the login page
    When User enters valid email address "automationuser@gmail.com" into email field
    And User enters valid password "12345" into password field
    And User clicks on login button
    Then User should get successfully logged in

