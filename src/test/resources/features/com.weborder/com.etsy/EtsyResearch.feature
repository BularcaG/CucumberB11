
Feature: Etsy Search Functionality
Background:
  Given the user navigates to "https://www.etsy.com/"
  @Hat @tc1 @smoke @regression
  Scenario: Validation of etsy search Hat

    When the user searches with "Hat"
    Then the user validates the title "Hats | Etsy"

  @Key @tc2 @smoke @regression
  Scenario: Validation of etsy search Key

    When the user searches with "Key"
    Then the user validates the title "Key | Etsy"

  @Pin @tc3 @smoke
  Scenario: Validation of etsy search Pin

    When the user searches with "Pin"
    Then the user validates the title "Pin | Etsy"

