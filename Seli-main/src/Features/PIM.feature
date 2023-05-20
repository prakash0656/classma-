Feature: PIM Search
  Scenario: Searching for employee info in the PIM table
    Given User launch the chrome browser
    Then User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User enter Username as "Admin" and Password as "admin123"
    And Clicks on login
    Then User should be on URL "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"
    And User should click on PIM
    And User search the employee name "cecil"
    Then employee info is shown

Scenario: Searching for employee info using ID
    Given User launch the chrome browser
    Then User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User enter Username as "Admin" and Password as "admin123"
    And Clicks on login
    Then User should be on URL "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"
    And User should click on PIM
    And User search the employee ID "0204"
    Then employee info is shown for that ID
