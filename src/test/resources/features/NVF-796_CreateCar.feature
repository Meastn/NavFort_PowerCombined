@NVF-921
Feature: As a 'Sales Manager' and 'Store Manager', I should be able to create a new car

    @NVF-894
    Scenario: Store Manager and Sales Manager can create car
        Given user is on the Dashboard page as "sales manager"
        When user clicks fleet - vehicles button
        Then user see create car button on the right side

    @NVF-895
    Scenario: Driver cannot create Car
        Given user is on the Dashboard page as "driver"
        When user clicks fleet - vehicles button
        Then user can't see create car button on the right side

    @NVF-896
    Scenario: user cannot create car without filling compulsory fields (positive scenario)
        Given user is on the create Car page
        When user fills all the compulsory fields with proper character format
        And user clicks save button
        Then user see "Entity saved" message


    @NVF-922
    Scenario: user cannot create car without filling compulsory fields (negative scenario)
        Given user is on the create Car page
        When user keeps all the compulsory fields empty
        And user clicks save button
        Then user see "compulsory fields must be filled" error message


    @NVF-897
    Scenario Outline: License Plate field should have both letters and digit characters(negative scenarios)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "Licence Plate must have both digits and letters" error message
        Examples:
            | characterType      | fieldName    |
            | only digits        | LicensePlate |
            | only letters       | LicensePlate |
            | special characters | LicensePlate |

    @NVF-898
    Scenario Outline: Driver field should have only letter characters(negative scenarios)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "Driver field only accepts letters" error message
        Examples:
            | characterType      | fieldName |
            | only digits        | Driver    |
            | digits and letters | Driver    |
            | special characters | Driver    |

    @NVF-899
    Scenario Outline: Chassis Number field should have only digit character(negative scenarios)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "<fieldName>" field is still empty
        Examples:
            | characterType      | fieldName     |
            | only letters       | ChassisNumber |
            | special characters | ChassisNumber |
            | digits and letters | ChassisNumber |

    @NVF-900
    Scenario Outline: Model Year field should have only digit character(negative scenarios)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "<fieldName>" field is still empty
        Examples:
            | characterType      | fieldName |
            | only letters       | ModelYear |
            | special characters | ModelYear |
            | digits and letters | ModelYear |

    @NVF-901
    Scenario Outline: Model Year field must be between years 1900 and 2023
        Given user is on the create Car page
        When user enters "<year>" as Model Year
        And user passes to next field by Tab Key
        Then user see "Please enter a valid Model Year" error message
        Examples:
            | year |
            | 1899 |
            | 2024 |

    @NVF-902
    Scenario: Transmission field doesn't allow to select multiple Dropdowns
        Given user is on the create Car page
        When  user select Manuel and Automatic options in Transmission dropdown field respectively
        Then user see only the last one (Automatic) is selected

    @NVF-903
    Scenario: Fuel Type field doesn't allow to select multiple Dropdowns
        Given user is on the create Car page
        When  user select  Diesel and Electric options in Fuel Type dropdown field respectively
        Then user see only the last one (Electric) is selected

    @NVF-904
    Scenario: User can create a car without OPTIONAL FIELDS
        Given user is on the create Car page
        When user fills all the compulsory fields with proper character format
        And user clicks save button
        Then user see "Entity saved" message

    @NVF-905
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


    @NVF-906
    Scenario Outline: Location field should have both letters and digits character (negative scenarios)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "Location field must have both digits and letters" error message
        Examples:
            | characterType      | fieldName |
            | only digits        | Location  |
            | only letters       | Location  |
            | special characters | Location  |

    @NVF-907
    Scenario Outline:  Immatriculation Date and First Contract Date fields should be chosen from calendar pop-up or should be written
    in proper text format("Nov 9, 2022") (positive scenario,pop-up calendar)
        Given user is on the create Car page
        When user pickes a date from calendar table in "<fieldName>"
        And user passes to next field by Tab Key
        Then user successfully passes to next field without seeing error message
        Examples:
            | fieldName           |
            | ImmatriculationDate |
            | FirstContractDate   |

    @NVF-908
    Scenario Outline:  Immatriculation Date and First Contract Date fields should be chosen from calendar pop-up or should be written
    in proper text format("Nov 9, 2022") (positive scenario,proper text format)
        Given user is on the create Car page
        When user writes "<dateInTextFormat>" date in text format to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user successfully passes to next field without seeing error message
        Examples:
            | dateInTextFormat | fieldName           |
            | Nov 9, 2022      | ImmatriculationDate |
            | Nov 9, 2022      | FirstContractDate   |

    @NVF-909
    Scenario Outline:  Immatriculation Date and First Contract Date fields should be chosen from calendar pop-up or should be written
    in proper text format("Nov 9, 2022") (negative scenarios)
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

    @NVF-910
    Scenario Outline: Catalog Value field should have only digit character(negative scenarios)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "<fieldName>" field is still empty
        Examples:
            | characterType      | fieldName    |
            | only letters       | CatalogValue |
            | special characters | CatalogValue |
            | digits and letters | CatalogValue |

    @NVF-911
    Scenario Outline: Seats Number field should have only digit character(negative scenarios)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "<fieldName>" field is still empty
        Examples:
            | characterType      | fieldName   |
            | only letters       | SeatsNumber |
            | special characters | SeatsNumber |
            | digits and letters | SeatsNumber |

    @NVF-912
    Scenario Outline: Doors Number field should have only digit character(negative scenarios)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "<fieldName>" field is still empty
        Examples:
            | characterType      | fieldName   |
            | only letters       | DoorsNumber |
            | special characters | DoorsNumber |
            | digits and letters | DoorsNumber |

    @NVF-913
    Scenario Outline: Color field should have only letter character(negative scenarios)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "Color field accepts only letter" error message
        Examples:
            | characterType      | fieldName |
            | only digits        | Color     |
            | special characters | Color     |
            | digits and letters | Color     |

    @NVF-914
    Scenario Outline: CO2 Emissions field should have only digit character(negative scenarios)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "<fieldName>" field is still empty
        Examples:
            | characterType      | fieldName    |
            | only letters       | CO2Emissions |
            | special characters | CO2Emissions |
            | digits and letters | CO2Emissions |

    @NVF-915
    Scenario Outline: Horsepower field should have only digit character(negative scenarios)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "<fieldName>" field is still empty
        Examples:
            | characterType      | fieldName  |
            | only letters       | Horsepower |
            | special characters | Horsepower |
            | digits and letters | Horsepower |

    @NVF-916
    Scenario Outline: Horsepower Taxation field should have only digit character(negative scenarios)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "<fieldName>" field is still empty
        Examples:
            | characterType      | fieldName          |
            | only letters       | HorsepowerTaxation |
            | special characters | HorsepowerTaxation |
            | digits and letters | HorsepowerTaxation |

    @NVF-917
    Scenario Outline: Power field should have only digit character(negative scenarios)
        Given user is on the create Car page
        When user enters "<characterType>" to "<fieldName>" field
        And user passes to next field by Tab Key
        Then user see "<fieldName>" field is still empty
        Examples:
            | characterType      | fieldName |
            | only letters       | Power     |
            | special characters | Power     |
            | digits and letters | Power     |

    @NVF-918
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

    @NVF-919
    Scenario Outline: user can only select one option from Vehicle Model and Vehicle Make (negative scenario)
        Given user is on the create Car page
        When user clicks Add button for "<fieldName>"
        And user selects "<option1>" and "<option2>"
        And user clicks select button in Vehicle Model_Make popup
        Then user see "Multiple choices are not allowed" error message displayed on the Create Car Page
        Examples:
            | fieldName     | option1 | option2 |
            | Vehicle_Model | Mazda   | Enzo    |
            | Vehicle_Make  | Ferrari | Tesla   |

    @NVF-920
    Scenario: User can see newly created car in ’Fleet-Vehicle’ table
        Given user is on the create Car page
        When user fills all the compulsory fields with valid credentials below
            | License Plate  | 11ASDF1111  |
            | Tags           | Junior      |
            | Driver         | John Doe    |
            | Chassis Number | 111,222,333 |
            | Model Year     | 2022        |
            | Transmission   | Manual      |
            | Fuel Type      | Electric    |

        And user clicks save button
        And user clicks Car button to navigate All Cars page
        Then user see newly created car in ’Fleet-Vehicle’ table
            | License Plate  | 11ASDF1111  |
            | Tags           | Junior      |
            | Driver         | John Doe    |
            | Chassis Number | 111,222,333 |
            | Model Year     | 2022        |
            | Transmission   | Manual      |
            | Fuel Type      | Electric    |

