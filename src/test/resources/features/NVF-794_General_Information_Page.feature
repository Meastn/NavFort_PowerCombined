Feature: General Information


  Background: User has logged in
    Given User logs in to the application

  @melih
  Scenario: User can see the car general information by clicking a table row
    Given User clicks fleet and vehicles menu items
    When User clicks any row
    Then User can see the general information page

  Scenario: User can see the car general information by clicking the view option
    Given User clicks fleet and vehicles menu items
    When User clicks on eye icon
    Then User can see the general information page

@melih
  Scenario: Managers should see options on general information page
    Given User clicks fleet and vehicles menu items
    When User clicks any row
    Then User can see the edit button
    And User can see the delete button
    And User can see the add event button

    Scenario: Driver shall not see options on general information page
    Given User logs out
    When User logs in as a Driver
    And Driver clicks fleet and vehicles menu items
    And User clicks any row
    Then User can not see the edit button
    And User can not see the delete button
    And User can not see the add event button


Scenario: Vehicle information on general information and vehicle table should be the same
  Given User clicks fleet and vehicles menu items
  When Data extracted from the first raw of the table
  And User clicks first row
  And Data extracted from the general information page
  Then Vehicle data from both sources should match correctly



  #User Story :
  #As a user, I should be able to see detailed information
    # of a specific vehicle, under Fleet Vehicle module
  #
  #Acceptance Criteria:
  #1- User can see the "General Information" page by clicking
    # on any vehicle (row)
  #2- User can see the "General Information" page by clicking
    # on the "Eye (View)" icon at the end of each row
  #3- Sales Manager and Store Manager should see "Edit",
    # "Delete" and "Add Event" buttons on the "General Information" page
  #4- Driver shouldn't see "Add Event", "Edit" and "Delete" buttons
  #5- Vehicle information displayed on the "General Information" page a
    # nd "Fleet-Vehicle" page should be the same