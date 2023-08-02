Feature: loginfuntionality check

 Scenario: Login with invalid credentials
    Given user navigates to login  page
    When User enters invalid email  address into email field
    And User enters invalid password  "1234567890" into password field
    And User clicks on Login  button
    Then User should het a proper  warning message about credentials mismatch

    
    
    