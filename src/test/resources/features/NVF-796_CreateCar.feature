@NVF-796
Feature: As a 'Sales Manager' and 'Store Manager', I should be able to create a new car



  Scenario: Store Manager can create Car
    Given user is on the Dashboard page as "store manager"
    When user clicks fleet - vehicles button
    Then user see create car button on the right side
