@NVF-796
Feature: As a 'Sales Manager' and 'Store Manager', I should be able to create a new car



  Scenario: Store Manager and Sales Manager can create Car
    Given user is on the Dashboard page as "sales manager"
    When user clicks fleet - vehicles button
    Then user see create car button on the right side
@wip
  Scenario: Driver cannot create Car
    Given user is on the Dashboard page as "driver"
    When user clicks fleet - vehicles button
    Then user can't see create car button on the right side
