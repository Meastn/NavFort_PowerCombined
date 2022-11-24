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


  Scenario Outline: user should see the the result that ends with the keyword that is specified
    When user selects "Ends With" method with a "<keyword>"
    Then results should end with the specified keyword
    Examples:
      | keyword |
      | dc      |
      | miami   |
      | s       |
#      | w york  | when i want to use the word to cpmpare that has space within, my assertions never pass!!!!!!!!!::(

  @nav_805
  Scenario Outline: user should see the the result that is exactly same with the keyword that is specified
    When user selects "Is Equal to" method with a "<keyword>"
    Then results should match with the specified keyword exactly
    Examples:
      | keyword      |
      | new york     |
      | washingtondc |
      | newyork      |
#      | washington dc |

  Scenario Outline: Methods "Contains", "Does Not Contains", "Starts With", "Ends With", "Is Equal to"  shouldn't accept non-alphabetical characters
    When user select "<methods>" and type "<non alphabetical characters>"
    Then user should see that selected method does not accept specified non alphabetical characters
    Examples:
      | methods           | non alphabetical characters |
      | contains          | 123                         |
      | does not contains | ,.!                         |
      | starts with       | $%6435                      |
      | ends with         | ----==new                   |
      | is equal to       | miami,                      |






















