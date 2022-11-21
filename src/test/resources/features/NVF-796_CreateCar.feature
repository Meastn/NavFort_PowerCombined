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

    Scenario Outline: Optional Fields (Location-CatalogValue-SeatsNumber-DoorsNumber-Color-CO2Emissions-Horsepower-HorsepowerTaxation-Power)
    character acceptance verification (positive scenarios)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user successfully passes to next field without seeing error message
        Examples:
            | characterType      | fieldName          |
            | digits and letters | Location           |
            | only digits        | CatalogValue       |
            | only digits        | SeatsNumber        |
            | only digits        | DoorsNumber        |
            | only letters       | Color              |
            | only digits        | CO2Emissions       |
            | only digits        | Horsepower         |
            | only digits        | HorsepowerTaxation |
            | only digits        | Power              |


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


    Scenario Outline:  Immatriculation Date and First Contract Date fields should be chosen from calendar pop-up or should be written
    in proper text format("Nov 9, 2022") (positive case,pop-up calendar)
        Given user is on the create Car page
        When user pickes a date from calendar table in "<fieldName>"
        And user passes to next field by Tab Key
        Then user successfully passes to next field without seeing error message
        Examples:
            | fieldName           |
            | ImmatriculationDate |
            | FirstContractDate   |

    Scenario Outline:  Immatriculation Date and First Contract Date fields should be chosen from calendar pop-up or should be written
    in proper text format("Nov 9, 2022") (positive case,proper text format)
        Given user is on the create Car page
        When user writes "<dateInTextFormat>" date in text format to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user successfully passes to next field without seeing error message
        Examples:
            | dateInTextFormat | fieldName           |
            | Nov 9, 2022      | ImmatriculationDate |
            | Nov 9, 2022      | FirstContractDate   |

    Scenario Outline:  Immatriculation Date and First Contract Date fields should be chosen from calendar pop-up or should be written
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
            | only digits        | FirstContractDate   |
            | only letters       | FirstContractDate   |
            | digits and letters | FirstContractDate   |
            | special characters | FirstContractDate   |


    Scenario Outline: Catalog Value field should have only digit character(negative cases)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "Catalog Value field accepts only digits" error message
        Examples:
            | characterType      | fieldName    |
            | only letters       | CatalogValue |
            | special characters | CatalogValue |
            | digits and letters | CatalogValue |


    Scenario Outline: Seats Number field should have only digit character(negative cases)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "Seats Number field accepts only digits" error message
        Examples:
            | characterType      | fieldName   |
            | only letters       | SeatsNumber |
            | special characters | SeatsNumber |
            | digits and letters | SeatsNumber |


    Scenario Outline: Doors Number field should have only digit character(negative cases)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "Doors Number field accepts only digits" error message
        Examples:
            | characterType      | fieldName   |
            | only letters       | DoorsNumber |
            | special characters | DoorsNumber |
            | digits and letters | DoorsNumber |


    Scenario Outline: Color field should have only letter character(negative cases)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "Color field accepts only letter" error message
        Examples:
            | characterType      | fieldName |
            | only digits        | Color     |
            | special characters | Color     |
            | digits and letters | Color     |


    Scenario Outline: CO2 Emissions field should have only digit character(negative cases)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "CO2 Emissions field accepts only digits" error message
        Examples:
            | characterType      | fieldName    |
            | only letters       | CO2Emissions |
            | special characters | CO2Emissions |
            | digits and letters | CO2Emissions |


    Scenario Outline: Horsepower field should have only digit character(negative cases)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "Horsepower field accepts only digits" error message
        Examples:
            | characterType      | fieldName  |
            | only letters       | Horsepower |
            | special characters | Horsepower |
            | digits and letters | Horsepower |


    Scenario Outline: Horsepower Taxation field should have only digit character(negative cases)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "Horsepower Taxation field accepts only digits" error message
        Examples:
            | characterType      | fieldName          |
            | only letters       | HorsepowerTaxation |
            | special characters | HorsepowerTaxation |
            | digits and letters | HorsepowerTaxation |


    Scenario Outline: Power field should have only digit character(negative cases)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "Power field accepts only digits" error message
        Examples:
            | characterType      | fieldName |
            | only letters       | Power     |
            | special characters | Power     |
            | digits and letters | Power     |

    @wipSerdar
    Scenario Outline: user can only select one option from Vehicle Model and Vehicle Make (positive scenario)
        Given user is on the create Car page
        When user clicks Add button for "<fieldName>"
        And user selects "<option>"
        And user clicks select button in Vehicle Model_Make popup
        Then user see "<option>" is displayed on the Create Car Page
        Examples:
            | fieldName     | option  |
            | Vehicle_Model | Mazda   |
            | Vehicle_Make  | Ferrari |

