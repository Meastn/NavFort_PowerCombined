@nav_805
Feature: Location Filter

As a user, I should be able to use Location filter under Fleet-Vehicle page



Background: User is on the fleet-vehicle page
  Given user is login with valid credentials and on the vehicle page


  Scenario: User can see the manage filters dropdown and location option under when he clicks the filter icon
  When user clicks the filter icon
  And user clicks the manage filters dropdown and select the location option
  Then user should be able to see Location dropdown















#
#1- "Location" filter has the methods below:
#
#Contains
#Does Not Contain
#Is Equal To
#Starts With
#Ends With
#Is Any Of
#Is Not Any Of
#Is Empty
#Is Not Empty
#2- When user selects "Contains" method with a keyword, the results should contain the specified keyword
#
#3- When user selects "Does Not Contain" method with a keyword, the results should not contain the specified keyword
#
#4- When user selects "Starts-with" method with a keyword, the results should start with the specified keyword
#
#5- When user selects "Ends With" method with a keyword, the results should end with the specified keyword
#
#6- When user selects "Is Equal to" method with a keyword, the results should match the specified keyword exactly
#
#7- Methods  ("Contains", "Does Not Contains", "Starts With", "Ends With", "Is Equal to") shouldn't accept non-alphabetical characters
