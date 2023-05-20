Feature: Login

  Scenario: Checking the validation of login
    Given User launch the chrome browser
    Then User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And Clicks on login Button
    Then Username and Password required message is shown
    And Browser is closed

  Scenario: Logging with invalid credentials
    Given User launch the chrome browser
    Then User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User provide invalid username as "wrong" and password "wrong"
    And Clicks on login Button
    Then Invalid credentails message should be shown
    And Browser is closed

  Scenario: Successful Login with valid credentials
    Given User launch the chrome browser
    Then User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User enter Username as "Admin" and Password as "admin123"
    And Clicks on login
    Then User should be on URL "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"
    And Browser is closed