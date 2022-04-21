@SmokeLoginOutline
Feature: Login Functionality for WebOrder Page

  Background:
    Given the user navigates to the WebOrder website
  Scenario Outline: Validation of WebOrder Login Negative Scenario 2

    When the user provides wrong "<username>" and wrong "<password>"
    Then the user validates the "Sign in Failed" error message
    Examples:
      | username              | password |
      | guest1@microworks.com | Guest1!  |
      | Damicroworksn         | Marino   |
      |                       |          |
      | guest1@microworks.com |          |
      | guest1@microworks.com | #$%^&    |


  Scenario : Validation of WebOrder Login Positive Scenarios

    When the user provides credentials
    Then the user is on the homepage
#   do not touch positive scenario
#  create as many as negative scenariosmwith scenario outline


