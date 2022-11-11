
Feature: General Information
  Back

  Background: User lands on homepage
    When User is on login page


  Scenario: User sees General Information page by clicking on any vehicle (row)
    Given User clicks fleet and vehicles menu items
    When User clicks any row
    Then User can see the general information page

  @melih
  Scenario: User sees General Information page by clicking the eye icon on each row
    Given User clicks fleet and vehicles menu items
    When User clicks on eye icon
    Then User can see the general information page










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