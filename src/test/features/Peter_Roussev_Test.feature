Feature: Cash box tests

  Background: User logs into the system and clicks Cash box
    Given User is on login page
    When he enters username and password
    And clicks on login button
    Then User is navigated to the homepage
    And clicks on Cash box in the header tab
    Then user clicks on new income button
    And new income submission form opens


  Scenario Outline:

    When user ensures the current date is selected by default
    And Income radio button is selected by default
    Then user types the new amount "<amount>"
    And types the payment reason "<reason>"
    Then clicks on the Submit button
    And Checks the confirmation message is displayed
    Then new amount should be successfully added to the total amount
  Examples:
    |  amount  |  reason  |
    |  12.40   |  плащане |
    |  0.99    |  вноска  |
    |  121     |  договор |

  Scenario:

    When user types the new amount "30.30"
    And clicks on the Submit button
    Then "Въведете заглавие на записа." error message should appear

  Scenario:

    When user types the new amount "123.5"
    And types the payment reason "плащане"
    And types category "Спортни стоки" in the New Category text field
    Then clicks on the Submit button
    And user clicks on new income button
    Then checks if the new category "Спортни стоки" is now an option in category dropdown list


