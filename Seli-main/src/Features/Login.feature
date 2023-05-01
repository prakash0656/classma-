Feature: Login

  Scenario: Successful Login with valid credentials
    Given User launch the chrome browser
    When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User enter Username as "Admin" and Password as "admin123"
    And Clicks on login
    Then User should be on URL "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"
    When User click on logout link
    Then User should be on URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And close browser