  #As a user, I should be able to see detailed information
    # of a specific vehicle, under Fleet Vehicle module
  @NVF-852
  Feature: General Information Page Tests
    Background:
      Given User logs in to the application

#1- User can see the "General Information" page by clicking
# on any vehicle (row)
    @NVF-847
    Scenario: User can see the car general information by clicking a table row
      Given User clicks fleet and vehicles menu items
      When User clicks any row
      Then User can see the general information page

#2- User can see the "General Information" page by clicking
# on the "Eye (View)" icon at the end of each row
    @NVF-848
    Scenario: User can see the car general information by clicking the view option
      Given User clicks fleet and vehicles menu items
      When User clicks on eye icon
      Then User can see the general information page

#3- Sales Manager and Store Manager should see "Edit",
# "Delete" and "Add Event" buttons on the "General Information" page
    @NVF-849
    Scenario: Managers should see options on general information page
      Given User clicks fleet and vehicles menu items
      When User clicks any row
      Then User can see the edit button
      And User can see the delete button
      And User can see the add event button

   #4- Driver shouldn't see "Add Event", "Edit" and "Delete" buttons
    @NVF-850
    Scenario: Driver shall not see options on general information page
      Given User logs out
      When User logs in as a Driver
      And Driver clicks fleet and vehicles menu items
      And User clicks any row
      Then User can not see the edit button
      And User can not see the delete button
      And User can not see the add event button

#5- Vehicle information displayed on the "General Information" page
# and "Fleet-Vehicle" page should be the same
    @NVF-851
    Scenario: Vehicle information on general information and vehicle table should be the same
      Given User clicks fleet and vehicles menu items
      Then Data from the table and car page matches correctly







