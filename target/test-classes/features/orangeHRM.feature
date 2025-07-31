Feature: Testing orangeHRM login functionality

  Background:
    Given User is on the loginPage
    When user enters valid credentials user name as "Admin" and password as "admin123"
    And clicks on login
    Then user should be on the homepage and verify the homepage

  Scenario: orangeHRM test

    When user clicks on "PIM" employee information should be displayed

  Scenario:

    When User clicks on "Admin" module then admin page should be displayed

