Feature: Validate amazon web application for its functonality

  Background: Pre requisite to launch the browser and url
    Given the browser is invoked
    And the url the launched

  Scenario Outline: Validate search an item in google application
    Given The user is on google home page
    When The user types "<SearchTxtField>" search item
    And The items related to search term is shown
    Then search the automation testing keyword
    When The title of page should be same as "<SearchTxtField>"
    Then close the browser
    
    Examples: 
      | SearchTxtField     |
      | Automation Testing |
      | Manual Testing     |
      
      
      