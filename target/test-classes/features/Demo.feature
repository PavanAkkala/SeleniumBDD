Feature: Demo Testing

  @smoke
  Scenario: Testing the demo feature

    Given User is on home page and user enters names "Don" into field
    When Get the text from gender and compare "Gender:"
    And Verify the gui box is visible or not
    Then Click on the radio button
    When Clicks on popup button new tab will apper
    Then get the text from element
    And Back to Main wondow and click on checkbox
