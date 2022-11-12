Feature: Fleet Management Delete Car Functionality

  Background: The driver, sales manager and store manager use the
  fleet management home page.

  @wip
  Scenario:Login as a driver
    Given user on the fleet home page as a driver
    When user enters the fleet vehicle page
    And user hover over three dots
    Then user sees the delete button


  Scenario:Login as sales manager
    Given user on the fleet home page as a sales manager
    When user enters the fleet vehicle page
    And user hover over three dots
    Then user sees the delete button


  Scenario:Login as store manager
    Given user on the fleet home page as a store manager
    When user enters the fleet vehicle page
    And user hover over three dots
    Then user sees the delete button

@wip
  Scenario:Login as a driver
    Given user on the fleet home page as a driver
    When user enters the fleet vehicle page
    And user hover over three dots
    And user try to delete the row
   Then User see warning message

  Scenario:Login as sales manager
    Given user on the fleet home page as a sales manager
    When user enters the fleet vehicle page
    And user hover over three dots
    And user can delete the line
    And User see confirmation message
    Then Deleted item message is seen

  Scenario: Login as store manager
    Given user on the fleet home page as a store manager
    When user enters the fleet vehicle page
    And user hover over three dots
    And user can delete the line
    And User see confirmation message
    Then Deleted item message is seen