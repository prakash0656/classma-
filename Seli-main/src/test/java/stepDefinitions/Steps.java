package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.AdminPage;
import pageObject.LoginPage;
import pageObject.PimPage;

import java.time.Duration;

public class Steps {

    public WebDriver driver;
    public LoginPage lp;

    public AdminPage ap;

    public PimPage PIMpage;


    @Given("User launch the chrome browser")
    public void user_launch_the_chrome_browser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("−−incognito");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        lp = new LoginPage(driver);
        ap = new AdminPage(driver);
        PIMpage = new PimPage(driver);
    }

    @Then("User opens URL {string}")
    public void user_opens_url(String string) {
        driver.get(string);
        driver.manage().window().maximize();
    }

    @Then("Clicks on login Button")
    public void clicks_on_login_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name=\"username\"]")));
        lp.ClickLogin();
    }

    @Then("Username and Password required message is shown")
    public void username_and_password_required_message_is_shown() {
        if (driver.getPageSource().contains("Required")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Then("Browser is closed")
    public void browser_is_closed() {
        driver.quit();
    }


    @Then("User provide invalid username as {string} and password {string}")
    public void user_provide_invalid_username_as_and_password(String string, String string2) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name=\"username\"]")));
        lp.setUsername(string);
        lp.setPassword(string2);
    }

    @Then("Invalid credentails message should be shown")
    public void invalid_credentails_message_should_be_shown() {
        if (driver.getPageSource().contains("Invalid credentials")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }


    @Then("User enter Username as {string} and Password as {string}")
    public void user_enter_username_as_and_password_as(String string, String string2) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name=\"username\"]")));
        lp.setUsername(string);
        lp.setPassword(string2);
    }

    @Then("Clicks on login")
    public void clicks_on_login() {
        lp.ClickLogin();
    }

    @Then("User should be on URL {string}")
    public void user_should_be_on_url(String string) {
        if (driver.getPageSource().contains("Invalid Credentials")) {
            driver.close();
            Assert.assertTrue(false);
        } else {
            Assert.assertEquals(string, driver.getCurrentUrl());
        }
    }

    //Admin starts
    @Then("User should click on Admin")
    public void user_should_click_on_admin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]/span[1]")));
        ap.ClickAdmin();
    }

    @Then("User search the username {string}")
    public void user_search_the_username(String string) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")));
        ap.enterUsername(string);
        ap.ClickSearch();
    }

    @Then("Admin info is shown")
    public void admin_info_is_shown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]")));

        if (result.getText().equals("Admin")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    @Then("User types the username {string}")
    public void user_types_the_username(String string) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]")));
        ap.enterUsername(string);
        ap.ClickSearch();
    }

    @Then("No Records found message should be shown")
    public void no_records_found_message_should_be_shown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/span[1]")));

        if (result.getText().equals("No Records Found")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }
//PIM page

    @Then("User should click on PIM")
    public void user_should_click_on_pim() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]/span[1]")));
        PIMpage.ClickPIM();
    }

    @Then("User search the employee name {string}")
    public void user_search_the_employee_name(String string) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")));
        PIMpage.enterEmployeeName(string);
        PIMpage.ClickSearch();
    }

    @Then("employee info is shown")
    public void employee_info_is_shown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Cecil')]")));

        if (result.getText().equals("Cecil")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }


    @Then("User search the employee ID {string}")
    public void user_search_the_employee_ID(String string2) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]")));
        PIMpage.enterEmployeeID(string2);
        PIMpage.ClickSearch();
    }

    @Then("employee info is shown for that ID")
    public void employee_info_is_shown_for_that_id() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'0204')]")));

        if (result.getText().equals("0204")) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }
}

