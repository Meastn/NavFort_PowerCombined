@okan
Feature: Arranging vehicle table data under Fleet-Vehicle page

  Background: user is on the vehicles page
    Given user login with valid credentials and on the vehicles page placed under the Fleet Dropdown

  Scenario: User can arrange rows/vehicle numbers to be displayed by clicking on 'View Per Page' button
    Then User sees default value is twentyfive
    Then User can select each of the options
    Then User can arrange rows and vehicle numbers to be displayed

 
  Scenario:   User can sort a column in ascending or descending order by clicking the column name
     Then User sort a column in ascending or descending order by clicking the column name
 



  Scenario:   User can remove all sortings and filterings on the page by using the reset button
    And User sorts and filters by clicking columns and filters
    Then User remove all sortings and filterings on the page by using the reset button
  


