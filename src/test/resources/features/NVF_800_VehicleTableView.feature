Feature: Seeing general vehicle information under the vehicles
  User Story:
  As a user, I should be able to see all vehicle information in a table, under Fleet-Vehicle page

Background: User is on the vehicles page
  Given user is on the vehicles page placed under the Fleet Dropdown

Scenario: User can see all vehicle information in a table
  When user click any row at anywhere on the row
  And user see all vehicle "information" under the General Information header
    | License Plate             | 35XBEH        |
    | Tags                      | Sedan         |
    | Driver                    | Henry Ruecker |
    | Location                  | HOWECHESTER   |
    | Chassis Number            | 964294        |
    | Model Year                | 1983          |
    | Last Odometer             | 44000         |
    | Immatriculation Date      | Sep 4, 1997   |
    | First Contract Date       | May 7, 2014   |
    | Catalog Value (VAT Incl.) | $5,000.00     |
    | Seats Number              | 6             |
    | Doors Number              | 3             |
    | Color                     | Olive         |
    | Transmission              | Automatic     |
    | Fuel Type                 | Gasoline      |
    | CO2 Emissions             | 0.1           |
    | Horsepower                | 289           |
    | Horsepower Taxation       | 0.1           |
    | Power (KW)                | 91            |
    | Logo                      |               |
    | Vehicle Model             | N/A           |
    | Vehicle Make              | N/A           |
  And user navigates back to the vehicles page
  Then user should be able to see exact informations on the table

  Scenario:  User can see the total page number and total vehicle recording
  Then user can see total page number and total recording of vehicles

  Scenario: User can go to next page clicking ">" button and can go to previous page clicking "<" button
  When user enters next page button
  Then user can go to the nextTablePage

  Scenario: User can go to next page clicking ">" button and can go to previous page clicking "<" button
    When user enters previous page button
    Then user can go to the previousTablePage















#
#
#
#  2- User can see the total page number
#
#  3- User can see total recordings of vehicles
#
#  4- User can go to next page clicking ">" button and can go to previous page clicking "<" button
#
#  5- User can download table data in XLS or CSV format from "Export Grid"
#
#  (a confirmation message is enough to validate)