@LoginToPurchase
Feature: Login
  As a user i want to login to saucedemo

  Scenario: Login with valid credential
    Given User open the saucedemo website
    When User input "standard_user" as a userName "secret_sauce" as a password
    Then User redirected to inventory page
    And User sort product by "Price (low to high)"
    And User add to cart button for "Sauce Labs Onesie"
    And User add to cart button for "Sauce Labs Bike Light"
    Then User click shopping cart badge
    And User remove "Sauce Labs Bike Light" from shopping cart
    And User click Checkout button
    Then User redirected to Checkout Step One page
    And User input "Franklin" as FirstName "Richards" as LastName "123456" as ZipCode
    And User click Continue button
    Then User redirected to Checkout Step Two page
    And User click Finish button
    Then User redirected to Checkout Complete page

#  @TC2
#  Scenario Outline: Login with invalid credential
#    Given User open the saucedemo website
#    When User input "<userName>" as a userName "<password>" as a password
#    Then User see error "<errorMessage>" on login page
#
#
#    Examples:
#      | userName      | password | errorMessage                                                              |
#      | secret_sauce  |          | Epic sadface: Username is required                                        |
#      | standard_user |          | Epic sadface: Password is required                                        |
#      |               |          | Epic sadface: Username is required                                        |
#      | toko          | 123      | Epic sadface: Username and password do not match any user in this service |

