Feature: Admin Search
  Scenario: Searching for admin in the admin table
    Given User launch the chrome browser
    Then User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User enter Username as "Admin" and Password as "admin123"
    And Clicks on login
    Then User should be on URL "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"
    And User should click on Admin
    And User search the username "admin"
    Then Admin info is shown

Scenario: Searching for user in admin page who is not in the system
  Given User launch the chrome browser
  Then User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
  And User enter Username as "Admin" and Password as "admin123"
  And Clicks on login
  Then User should be on URL "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"
  And User should click on Admin
  And User types the username "baddaa"
  Then No Records found message should be shown