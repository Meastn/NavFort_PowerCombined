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
        And user keeps "<Empty field>" empty

        Examples:
          | Empty field    |
          | Licence Plate  |
