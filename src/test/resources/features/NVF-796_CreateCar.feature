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


    Scenario Outline: License Plate field should have both letters and digit characters(negative cases)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "Licence Plate must have both digits and letters" error message
        Examples:
            | characterType      | fieldName    |
            | only digits        | LicensePlate |
            | only letters       | LicensePlate |
            | special characters | LicensePlate |

    Scenario Outline: Driver field should have only letter characters(negative cases
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "Driver field only accepts letters" error message
        Examples:
            | characterType      | fieldName |
            | only digits        | Driver    |
            | digits and letters | Driver    |
            | special characters | Driver    |

    Scenario Outline: Chassis Number field should have only digit character(negative cases)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "Chassis Number" field is still empty
        Examples:
            | characterType      | fieldName     |
            | only letters       | ChassisNumber |
            | special characters | ChassisNumber |

    Scenario Outline: Model Year field shoul have only digit character(negative cases)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "Model Year field only accepts digits" error message
        Examples:
            | characterType      | fieldName |
            | only letters       | ModelYear |
            | special characters | ModelYear |

    Scenario Outline: Model Year field must be between years 1900 and 2023
        Given user is on the create Car page
        When user enters "<year>" as Model Year
        And user passes to next field by Tab Key
        Then user see "Please enter a valid Model Year" error message
        Examples:
            | year |
            | 1899 |
            | 2024 |

    Scenario: Transmission field doesn't allow to select multiple Dropdowns
        Given user is on the create Car page
        When  user select Manuel and Automatic options in Transmission dropdown field respectively
        Then user see only the last one (Automatic) is selected

    Scenario: Fuel Type field doesn't allow to select multiple Dropdowns
        Given user is on the create Car page
        When  user select  Diesel and Electric options in Fuel Type dropdown field respectively
        Then user see only the last one (Electric) is selected

    Scenario: User can create a car without OPTIONAL FIELDS
        Given user is on the create Car page
        When user fills all the compulsory fields with proper character format
        And user clicks save button
        Then user see "Entity saved" message


    Scenario: Location field should have both letters and digits character (positive cases)
        Given user is on the create Car page
        When user enters "digits and letters" to "Location" field
        And user passes to next field by Tab Key
        Then user successfully passes to next field without seeing error message


    Scenario Outline: Location field should have both letters and digits character (negative cases)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "Location field must have both digits and letters" error message
        Examples:
            | characterType      | fieldName |
            | only digits        | Location  |
            | only letters       | Location  |
            | special characters | Location  |


    Scenario:  Immatriculation Date should be chosen from calendar pop-up or should be written
    in proper text format("Nov 9, 2022") (positive case,pop-up calendar)
        Given user is on the create Car page
        When user pickes a date from calendar table in "ImmatriculationDate"
        And user passes to next field by Tab Key
        Then user successfully passes to next field without seeing error message


    Scenario:  Immatriculation Date should be chosen from calendar pop-up or should be written
    in proper text format("Nov 9, 2022") (positive case,proper text format)
        Given user is on the create Car page
        When user writes "Nov 9, 2022" date in text format to "ImmatriculationDate" field
        And user passes to next field by Tab Key
        Then user successfully passes to next field without seeing error message


    Scenario Outline:  Immatriculation Date should be chosen from calendar pop-up or should be written
    in proper text format("Nov 9, 2022") (negative cases)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "This value is not a valid date." error message
        Examples:
            | characterType      | fieldName           |
            | only digits        | ImmatriculationDate |
            | only letters       | ImmatriculationDate |
            | digits and letters | ImmatriculationDate |
            | special characters | ImmatriculationDate |

    @wipSerdar
    Scenario:  First Contract Date should be chosen from calendar pop-up or should be written
    in proper text format("Nov 9, 2022") (positive case,pop-up calendar)
        Given user is on the create Car page
        When user pickes a date from calendar table in "FirstContractDate"
        And user passes to next field by Tab Key
        Then user successfully passes to next field without seeing error message


    Scenario:  First Contract Date should be chosen from calendar pop-up or should be written
    in proper text format("Nov 9, 2022") (positive case,proper text format)
        Given user is on the create Car page
        When user writes "Nov 9, 2022" date in text format to "FirstContractDate" field
        And user passes to next field by Tab Key
        Then user successfully passes to next field without seeing error message


    Scenario Outline:  First Contract Date should be chosen from calendar pop-up or should be written
    in proper text format("Nov 9, 2022") (negative cases)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "This value is not a valid date." error message
        Examples:
            | characterType      | fieldName         |
            | only digits        | FirstContractDate |
            | only letters       | FirstContractDate |
            | digits and letters | FirstContractDate |
            | special characters | FirstContractDate |