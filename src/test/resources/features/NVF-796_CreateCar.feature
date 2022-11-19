@NVF-796
Feature: As a 'Sales Manager' and 'Store Manager', I should be able to create a new car


    Scenario: Store Manager and Sales Manager can create car
        Given user is on the Dashboard page as "sales manager"
        When user clicks fleet - vehicles button
        Then user see create car button on the right side

    Scenario: Driver cannot create Car
        Given user is on the Dashboard page as "driver"
        When user clicks fleet - vehicles button
        Then user can't see create car button on the right side


    Scenario Outline: user cannot create car without filling compulsory fields
        Given user is on the create Car page
        When user fills all the compulsory fields with proper character format
        And user keeps "<emptyFieldName>" field empty
        And user clicks save button
        Then user see "<emptyFieldName>" field cannot be empty error message
        When user fills "<emptyFieldName>" field with proper character format
        And user clicks save button
        Then user see "Entity saved" message
        Examples:
            | emptyFieldName |
            | Licence Plate  |
            | Tag            |
            | Driver         |
            | Chassis Number |
            | Model Year     |
            | Transmission   |
            | Fuel Type      |


    Scenario: License Plate field should have both digits and letters
        Given user is on the create Car page
        When user enters data which only contains digit to "Licence Plate" field
        And user passes to next field by Tab Key
        Then user see "Licence Plate must have both digits and letters" warning message
        When user enters data which only contains letters to "Licence Plate" field
        And user passes to next field by Tab Key
        Then user see "Licence Plate field must have both digits and letters" warning message


    Scenario: Driver field should only accept letters
        Given user is on the create Car page
        When user enters data which only contains digit to "Driver" field
        And user passes to next field by Tab Key
        Then user see "Driver field only accepts letters" warning message
        When user enters data which contains both letters and digits to "Driver" field
        And user passes to next field by Tab Key
        Then user see "Driver field only accepts letters" warning message


    Scenario: Chassis Number field should only accept digits
        Given user is on the create Car page
        When user enters data which only contains letters to "Chassis Number" field
        And user passes to next field by Tab Key
        Then user see "Chassis Number" field is still empty

    Scenario: Model Year field should only accept digits
        Given user is on the create Car page
        When user enters data which only contains letters to "Model Year" field
        And user passes to next field by Tab Key
        Then user see "Model Year field only accepts digits" warning message

    Scenario Outline: Model Year field must be between 1900 and 2023
        Given user is on the create Car page
        When user enters "<year>" as Model Year
        And user passes to next field by Tab Key
        Then user see "Please enter a valid Model Year" warning message
        Examples:
            | year |
            | 1899 |
            | 2024 |

    Scenario: Transmission field doesn't allow to select multiple Dropdowns
        Given user is on the create Car page
        When  user select Manuel and Automatic options in Transmission dropdown field respectively
        Then user see only the last one (Automatic) is selected

    @wip
    Scenario: Fuel Type field doesn't allow to select multiple Dropdowns
        Given user is on the create Car page
        When  user select  Diesel and Electric options in Fuel Type dropdown field respectively
        Then user see only the last one (Electric) is selected