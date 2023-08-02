Feature: Registration funtionality

Scenario: User creates an account only with

When User navigates to Register Account page
When User enters the details into below fields
|firstName  |Arun                      |
|lastName   |Motoori                   |
|email      |amotoori24122022@gmail.com|
|telephone  |1234567890                |
|Password   |12345                     |
And User selects privacy polocy
And User clicks on Continue button
Then User account should get created sucessfully


Scenario: User creates an account only with

When User navigates to Register Account page
When User enters the details into below fields
|firstName  |Arun                      |
|lastName   |Motoori                   |
|email      |ragebhargavsai1999@gmail.com|
|telephone  |1234567890                |
|Password   |12345                     |
And User selects yes for Newsletter
And User selects privacy polocy
And User clicks on Continue button
Then User account should get created sucessfully

Scenario: User creates an duplicate account only with

When User navigates to Register Account page
When User enters the details into below fields
|firstName  |Arun                      |
|lastName   |Motoori                   |
|email      ||
|telephone  |1234567890                |
|Password   |12345                     |
And User selects privacy polocy
And User clicks on Continue button
Then User should get a proper warning about duplicate email

Scenario: User creates an account without filling any details
Given User navigates to Register Account page
When User don't enter any details into fields 
And User clicks on Continue button 
Then User should get proper warning messages for every mandatory field

