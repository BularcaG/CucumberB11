@amazon
Feature: testing Amazon SignUp Functionality

  Background: navigate

  Scenario: Amazon SignUp with DataBase
    When the user clicks the signIn and creates the amazon account button
    Then the user validates the header
      | Create account |
    And the user provides the information:
      | ahmet           |
      | ahmet@gmail.com |
      | ahmet123        |
      | ahmet123        |

    And sgfdd "ahmet"
    And sgfdd "dsasd"