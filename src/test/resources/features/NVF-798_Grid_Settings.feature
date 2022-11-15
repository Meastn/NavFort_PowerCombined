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
    Given user logged in and pass on the Vehicle page


  Scenario:Grid Settings should be visible when user clicks on the gear icon
    When user clicks on the gear icon
    Then user should see Grid Settings

  Scenario:Column names in grid settings should be shown as below
    When user clicks on the gear icon
    Then "actualColumnName" should be shown as "<expectedColumnName>"

      | expectedColumnName        |
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

  Scenario Outline: User can find any column by typing the column name on "Quick Search" input box
    When user type"<searchedColumnName>" to quick search box
    Then user can find searched column

    Examples: Column Values for Scenario
      | searchedColumnName        |
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

  Scenario: User can select any column by clicking the column name
    When user select any column name
    Then visibility checkbox turns unchecked
    Then Unchecked column unvisible on the table

  Scenario: User can arrange the order of the columns (by dragging and dropping)
    When user moved to column
    Then moved column order changed on the table




