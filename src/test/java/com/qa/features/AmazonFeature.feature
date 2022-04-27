Feature: Validate amazon web application for its functionalities

  Background: Pre requisite to launch the browser and url
    Given the browser is invoked
    And the url the launched

  Scenario Outline: Validate search an item feature in amazon application
    Given The user is on amazon home page
    When the user selects "<CategoryName>" as category
    And the user types "<ItemName>" as search item
    When the magnifier button is clicked
    Then the title of page should be same as "<ItemName>"
    And the items related to search term should be loaded
    Then close the browser

    Examples: 
      | CategoryName | ItemName      |
      | Books        | Da Vinci Code |
      | Electronics  | Mobile Phones |
      | Furniture    | Wooden Tables |

  Scenario: Validate new user registration
    Given The user is on amazon home page
    When the user does mouse over on accounts and lists element
    Then the start here should be clicked
    Then check if the user is landed on registration page
    Then type the customer name
      | Kim Smith   |
      | Blake Roger |
      | King Blake  |
    Then close the browser
