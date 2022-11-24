Feature: Location Filter

  As a user, I should be able to use Location filter under Fleet-Vehicle page


  Background: User is on the fleet-vehicle page and can be on the filter methods under the location filter
    Given user is login with valid credentials and on the vehicle page
    When user clicks the filter icon
    And user clicks the manage filters dropdown and select the location option
    Then user should be able to see Location dropdown


  Scenario: User can see the filter methods under the location filter
    When user clicks location Dropdown and clicks the filter methods toggle under
    Then user should be able to see methods
      | Contains         |
      | Does Not Contain |
      | Is Equal To      |
      | Starts With      |
      | Ends With        |
      | Is Any Of        |
      | Is Not Any Of    |
      | Is Empty         |
      | Is Not Empty     |


  Scenario Outline: User should see the specified keyword in the result when he select contains Method with a keyword
    When user select Contains method with a "<keyword>"
    Then the results should contain the specified keyword
    Examples:
      | keyword |
      | a       |
      | york    |
#      | n d     |
      | d n     |
      | ab,!    |


  Scenario Outline: User should see the result that does not contain specified keyword
    When user selects "Does Not Contain" method with a "<keyword>"
    Then  results should not contain the specified keyword
    Examples:
      | keyword |
      | a       |
      | york    |
      | d n     |
      | ab,!    |


  Scenario Outline: user should see the the result that starts with the keyword that is specified
    When user selects "Starts with" method with a "<keyword>"
    Then results should start with the specified keyword
    Examples:
      | keyword |
      | new     |
      | ew      |
      | mia     |
      | ia      |

  @nav_805
  Scenario Outline:
    When user selects "Ends With" method with a "<keyword>"
    Then results should end with the specified keyword
    Examples:
      | keyword |
      | dc      |
      | miami   |
      | s       |
#      | w york  | when i want to use the word to cpmpare that has space within my assertions never pass!!!!!!!!!::(
























#
#5- When user selects "Ends With" method with a keyword, the results should end with the specified keyword
#
#6- When user selects "Is Equal to" method with a keyword, the results should match the specified keyword exactly
#
#7- Methods  ("Contains", "Does Not Contains", "Starts With", "Ends With", "Is Equal to") shouldn't accept non-alphabetical characters
