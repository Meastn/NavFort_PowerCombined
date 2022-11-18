@NVF-873
Feature: Fleet Management Delete Car Functionality

  Background: The driver, sales manager and store manager use the
  fleet management home page.

@NVF-874
  Scenario:Login as a driver
    Given user on the fleet home page as a driver
    When user enters the fleet vehicle page
    And user hover over three dots
    Then user sees the delete button


  @NVF-875
  Scenario:Login as sales manager
    Given user on the fleet home page as a sales manager
    When user enters the fleet vehicle page
    And user hover over three dots
    Then user sees the delete button

  @NVF-876
  Scenario:Login as store manager
    Given user on the fleet home page as a store manager
    When user enters the fleet vehicle page
    And user hover over three dots
    Then user sees the delete button

  @NVF-869
  Scenario:Login as a driver
    Given user on the fleet home page as a driver
    When user enters the fleet vehicle page
    And user hover over three dots
    And user can delete the line
    And User see confirmation message
   Then User see warning message


  @NVF-870
  Scenario:Login as sales manager
    Given user on the fleet home page as a sales manager
    When user enters the fleet vehicle page
    And user hover over three dots
    And user can delete the line
    And User see confirmation message
    Then Deleted item message is seen
  @NVF-871
  Scenario:Login as store manager
    Given user on the fleet home page as a store manager
    When user enters the fleet vehicle page
    And user hover over three dots
    And user can delete the line
    And User see confirmation message
    Then Deleted item message is seen

  # Go to General Information page
  @NVF-872
  Scenario:Authorized user can see and use delete button in 'General Information' page
    Given user on the fleet home page as managers
    When User clicks any row of car list
    And User can see the delete button and delete the car row
    Then User can see the car deleted message
    Then Navigate back to vehicle page
    Then user check the deleted row is removed from Fleet-Vehicle page