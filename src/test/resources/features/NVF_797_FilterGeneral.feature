@wip
Feature:As a user, I should be able to filter vehicle table, in Fleet-Vehicle page

  Background:User is logged in and navigate to the Fleet/Vehicle menu
    Given user should log in with valid credentials and navigate to the fleet vehicle page


    Scenario Outline:
      When user clicks on filter icon, Manage Filter button should be visible
      And User can apply filters by clicking on <filter_name>
      And User can find filters by typing the <filter_name_type>
      Then User can apply multiple filters at the same time
      Then User can remove all filters by clicking on the reset icon

      Examples:


