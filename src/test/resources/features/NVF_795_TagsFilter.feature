
Feature: Fleet Management Tag Filter Functionality

  Background: As a user, I should be able to use "Tags" filter under 'Fleet-Vehicles' page
    Given user on the fleet vehicle page


  Scenario: User able to use Tags filter
    When user clicks the manage filters and select tags
    Then user sees is Any Of and is Not Any Of options


  Scenario: User selects Is Any Of with Compact option
    When user clicks the manage filters and select tags
    And user selects is Any Of with Compact option
    Then user sees the list of Compact results

  Scenario: User selects Is Not Any Of with Compact option
    When user clicks the manage filters and select tags
    And user selects is Not Any Of with Compact option
    Then user sees the list of results except Compact



  Scenario: User selects Is Not Any Of method with Compact and Sedan
    When user clicks the manage filters and select tags
    And user selects is Not Any Of with Compact and Sedan option
    Then user sees the list of results except Compact and Sedan