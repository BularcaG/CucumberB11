@regression
Feature: WebOrder Page Food Order

  Background:
    Given the user is on weborder homepage
        When the user selects "Office" options
    And the user is on the groupOrderPage
    And the user sends invite note "Test"
    And the user sends invite list "ahmet@gmail.com" and "eric@gmail.com"

  @smoke @office @special
  Scenario: Validation of FoodOrder for Office
#    Given the user is on weborder homepage
#    When the user selects "Office" options
                    #    And the user is on the groupOrderPag]
                      #    And the user sends invite note "Test"
#    And the user sends invite list "ahmet@gmail.com" and "eric@gmail.com"
    Then the user validates the "2012 EMPIRE BLVD" address
    And the user validates "View Group Order" text
    * the user validates total participants is 1

  @myHouse @regression @smoke
  Scenario: Validation of FoodOrder for My House
#    Given the user is on weborder homepage
#    When the user selects "Office" options
#    And the user is on the groupOrderPage
#    And the user sends invite note "Test"
#    And the user sends invite list "ahmet@gmail.com" and "eric@gmail.com"
    And the user selects "My House" options
    Then the user validates the "2112 EMPIRE BLVD" address
    And the user validates "View Group Order" text
    * the user validates total participants is 1