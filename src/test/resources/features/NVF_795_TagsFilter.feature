Feature: Fleet Management Tag Filter Functionality

  Background: As a user, I should be able to use "Tags" filter under 'Fleet-Vehicles' page



  Scenario: User able to use "Tags" filter
    Given user on the fleet home page
    When user enters the fleet vehicle page
    And user clicks the manage filters and select tags
    Then user sees Is Any Of and Is Not Any Of options



  Scenario: User selects 'Is Any Of' with 'Compact' option, the table should include corresponding value
    Given user on the fleet home page
    When user enters the fleet vehicle page
    And user clicks the manage filters and select tags
    And user selects Is Any Of with Compact option
    Then user sees the list of Compact results


  Scenario: User selects 'Is Not Any Of' with 'Compact' option,  the table shouldn't include corresponding value
    Given user on the fleet home page
    When user enters the fleet vehicle page
    And user clicks the manage filters and select tags
    And user selects Is Not Any Of with Compact option
    Then user sees the list of results except Compact


  Scenario: User selects "Is Not Any Of" method with 'Compact' and 'Sedan', the table shouldn't include corresponding values
    Given user on the fleet home page
    When user enters the fleet vehicle page
    And user clicks the manage filters and select tags
    And user selects Is Not Any Of with Compact and Sedan option
    Then user sees the list of results except Compact and Sedan