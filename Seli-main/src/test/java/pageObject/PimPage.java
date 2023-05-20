package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PimPage {
    public WebDriver ldriver;

    public PimPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
    }
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]/span[1]")
    WebElement btnPIM;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
    WebElement employeeName;
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/input[1]")
    WebElement employeeID;
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[2]/button[2]")
    WebElement btnSearch;

    public void ClickPIM() {btnPIM.click();}
    public void ClickSearch() {btnSearch.click();}

    public void enterEmployeeName(String employeeName) {
        this.employeeName.clear();
        this.employeeName.sendKeys(employeeName);
    }

    public void enterEmployeeID(String employeeID) {
        this.employeeID.clear();
        this.employeeID.sendKeys(employeeID);
    }
}
