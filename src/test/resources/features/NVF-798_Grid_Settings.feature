@NVF-798
Feature:
  User Story :

  As a user, I should be able to arrange vehicle table columns via "grid settings" under Fleet-Vehicles page

  Acceptance Criteria:


  Background: For the scenarios in the feature file user is expected to be on login page
    Given user logged in and pass on the Vehicle page

@NVF-862
  Scenario:Grid Settings should be visible when user clicks on the gear icon
    When user clicks on the gear icon
    Then user should see Grid Settings
@NVF-863
  Scenario:Column names in grid settings should be shown as below
    When user clicks on the gear icon
    Then Column names should be shown as
      | Id                        |
      | License Plate             |
      | Tags                      |
      | Driver                    |
      | Location                  |
      | Chassis Number            |
      | Model Year                |
      | Last Odometer             |
      | Immatriculation Date      |
      | First Contract Date       |
      | Catalog Value (VAT Incl.) |
      | Seats Number              |
      | Doors Number              |
      | Color                     |
      | Transmission              |
      | Fuel Type                 |
      | CO2 Emissions             |
      | Horsepower                |
      | Horsepower Taxation       |
      | Power (KW)                |
@NVF-864
    Scenario: user type to quick box and find column
      Then user type ColumnName to quick search box user can find searched column
        | Id                        |
        | License Plate             |
        | Tags                      |
        | Driver                    |
        | Location                  |
        | Chassis Number            |
        | Model Year                |
        | Last Odometer             |
        | Immatriculation Date      |
        | First Contract Date       |
        | Catalog Value (VAT Incl.) |
        | Seats Number              |
        | Doors Number              |
        | Color                     |
        | Transmission              |
        | Fuel Type                 |
        | CO2 Emissions             |
        | Horsepower                |
        | Horsepower Taxation       |
        | Power (KW)                |



@NVF-865
  Scenario: User can select any column by clicking the column name
    When user clicks on the gear icon
    Then user select any column name
    And visibility checkbox turns unchecked
    Then Unchecked column unvisible on the table
@NVF-866
  Scenario: User can arrange the order of the columns (by dragging and dropping)
    When user moved to column
    Then moved column order changed on the table







