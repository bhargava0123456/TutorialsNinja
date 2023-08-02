Feature: Login funtionality
 
  Scenario Outline: Login with login credentials
    Given user navigates to login page
    When user has entered valid email address <username> into email field
    And User has entered valid password <password> into password field
    And User clicks on Login button
    Then User should get successfully logged in
 
  Examples: 
  |username                |password|
  |amotooricap1@gmail.com  |12345   |
  |amotooricap2@gmail.com  |12345   |
  |amotooricap3@gmail.com  |12345   |

  Scenario: Login with invalid credentials
    Given user navigates to login page
    When User enters invalid email address into email field
    And User enters invalid password "1234567890" into password field
    And User clicks on Login button
    Then User should het a proper warning message about credentials mismatch

  Scenario: Login with valid email and invalid password
    Given user navigates to login page
    When user enters valid email address "ragebhargavsai1999@gmail.com" into email field
    And User enters invalid password "1234567890" into password field
    And User clicks on Login button
    Then User should het a proper warning message about credentials mismatch
 
 
  Scenario: Login with invalid email and valid password
    Given user navigates to login page
    When User enters invalid email address into email field
    And User has entered valid password "12345" into password field
    And User clicks on Login button
    Then User should het a proper warning message about credentials mismatch

  Scenario: Login without providing any credentials
    Given user navigates to login page
    When User don't enter email address into email field
    And User don't enter password into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch
