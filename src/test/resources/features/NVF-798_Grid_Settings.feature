Feature:
  User Story :

  As a user, I should be able to arrange vehicle table columns via "grid settings" under Fleet-Vehicles page

  Acceptance Criteria:

  1- "Grid Settings" should be visible when user clicks on the gear icon

  2-Column names in grid settings should be shown as below:

  Id
  License Plate
  Tags
  Driver
  Location
  Chassis Number
  Model Year
  Last Odometer
  Immatriculation Date
  First Contract Date
  Catalog Value (VAT Incl.)
  Seats Number
  Doors Number
  Color
  Transmission
  Fuel Type
  CO2 Emissions
  Horsepower
  Horsepower Taxation
  Power (KW)

  3- User can find any column by typing the column name on "Quick Search" input box

  4- User can select any column by clicking the column name

  5- User can arrange the order of the columns (by dragging and dropping)

  6- User can see all corresponding changes under 'Fleet-Vehicles' pages

  Background: For the scenarios in the feature file, user is expected to be on login page
    Given user logged in and user on the Vehicle page


  Scenario:Grid Settings should be visible when user clicks on the gear icon
    When user clicks on the gear icon
    Then user should see Grid Settings

  Scenario Outline:Column names in grid settings should be shown as below
    When user clicks on the gear icon
    Then "<actualColumnName>" should be shown as "<expectedColumnName>"
    Examples:Column Values for scenario
      | actualColumnName | expectedColumnName        |
      | actualColumnName | Id                        |
      | actualColumnName | License Plate             |
      | actualColumnName | Tags                      |
      | actualColumnName | Driver                    |
      | actualColumnName | Location                  |
      | actualColumnName | Chassis Number            |
      | actualColumnName | Model Year                |
      | actualColumnName | Last Odometer             |
      | actualColumnName | Immatriculation Date      |
      | actualColumnName | First Contract Date       |
      | actualColumnName | Catalog Value (VAT Incl.) |
      | actualColumnName | Seats Number              |
      | actualColumnName | Doors Number              |
      | actualColumnName | Color                     |
      | actualColumnName | Transmission              |
      | actualColumnName | Fuel Type                 |
      | actualColumnName | CO2 Emissions             |
      | actualColumnName | Horsepower                |
      | actualColumnName | Horsepower Taxation       |
      | actualColumnName | Power (KW)                |




