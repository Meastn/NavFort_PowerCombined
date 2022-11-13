Feature: As a 'Sales Manager' and 'Store Manager', I should be able to create a new car


    Scenario: Store Manager and Sales Manager can create car
        Given user is on the Dashboard page as "sales manager"
        When user clicks fleet - vehicles button
        Then user see create car button on the right side

    Scenario: Driver cannot create Car
        Given user is on the Dashboard page as "driver"
        When user clicks fleet - vehicles button
        Then user can't see create car button on the right side

    @NVF-796
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
