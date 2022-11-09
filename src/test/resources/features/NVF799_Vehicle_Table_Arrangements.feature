Feature: Arranging vehicle table data under Fleet-Vehicle page

  Scenario: User can arrange rows/vehicle numbers to be displayed by clicking on 'View Per Page' button
    Given Driver is on the login page
    When Driver enters valid credentials
    Then Driver sees Xfleet Homepage
    And User clicks Flight-Vehicle module
    Then User sees default value is twentyfive
    Then User can select each of the options
    Then User can arrange rows and vehicle numbers to be displayed

  Scenario: User can arrange rows/vehicle numbers to be displayed by clicking on 'View Per Page' button
    Given Sales Manager is on the login page
    When Sales Manager enters valid credentials
    Then Sales Manager sees Xfleet Homepage
    And User clicks Flight-Vehicle module
    Then User sees default value is twentyfive
    Then User can select each of the options
    Then User can arrange rows and vehicle numbers to be displayed

  Scenario: User can arrange rows/vehicle numbers to be displayed by clicking on 'View Per Page' button
    Given Store Manager is on the login page
    When Store Manager enters valid credentials
    Then Store Manager sees Xfleet Homepage
    And User clicks Flight-Vehicle module
    Then User sees default value is twentyfive
    Then User can select each of the options
    Then User can arrange rows and vehicle numbers to be displayed

