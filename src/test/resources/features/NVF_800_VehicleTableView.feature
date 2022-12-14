@Nav_800
Feature: Seeing general vehicle information under the vehicles
  User Story:
  As a user, I should be able to see all vehicle information in a table, under Fleet-Vehicle page

  Background: User is on the vehicles page
    Given user is login with valid credentials and on the vehicles page placed under the Fleet Dropdown


  Scenario: User can see all vehicle information in a table
    When user click anywhere at the row
    And user see all vehicle information under the General Information header
    And user navigates back to the vehicles page
    Then user should be able to see exact informations on the table
  Scenario:  User can see the total page number and total vehicle recording
    Then user can see total page number and total recording of vehicles

    @WIP
  Scenario: User can go to next page clicking ">" button
    When user enters next page button user can go to the next page

  Scenario: User can go to previous page clicking "<" button
    When user enters previous page button user can go to the previousTablePage



  Scenario: User can download table data in XLS or CSV format from "Export Grid"
    When user click export Grid button
    And user click  csv option
    Then user can see the successfully download message

  Scenario: User can download table data in XLS or CSV format from "Export Grid"
    When user click export Grid button
    And user click  xlsx option
    Then user can see the successfully download message













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