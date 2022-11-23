@NVF-793
Feature: As a Store Manager and Sales Manager, I should be able to add an event

  Background: User can login and goes the general information page by clicking any row on the car list


  @NVF-883
  Scenario: User can click can see and access the Add Event Page
    Given user is on the general information page
    When user can click on the Add Event button
    Then user lands on the Add Event pop up page

  @NVF-886
  Scenario: Driver can access the general information page and should
  not see the Add Event Button
    When driver lands on general information page
    Then driver should not see the Add Event Button

  @NVF-887
  Scenario: Store Manager and Sales Manager can click the "Add Event" button and
  land on the "Add Event" page
    Given user is on the general information page
    When user can click the Add Event button
    Then user should land on the Add Event page
