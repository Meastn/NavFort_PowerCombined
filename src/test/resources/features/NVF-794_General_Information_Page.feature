Feature: General Information

  @wip
  Scenario Outline: : User are on homepage
    Given User is on login page
    When User enters his username "<username>" and password "<password>"
    And User clicks the login button
    Then User lands on homepage "<homepage>"

    Examples: data
    |username|password|homepage|
    | salesmanager101 | UserUser123 | Dashboard |
    | storemanager85  |UserUser123 | Dashboard  |
    | user1           |UserUser123 |Quick Launch Pad|








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