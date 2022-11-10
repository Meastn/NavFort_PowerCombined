package com.navfort.pages;

import com.navfort.utilities.ConfigurationReader;
import com.navfort.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NVF_800_Fleet_Vehicle_Page {

    public NVF_800_Fleet_Vehicle_Page() {
        //to connect Driver and the web elements inside the page class
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//label[@class='control-label']")
    public List<WebElement> controlKeyLabels;

    @FindBy(xpath = "//label[@class='control-label']/../div/div")
    public List<WebElement> controlValueLabels;

    @FindBy(xpath = "//a[@class='unclickable'][1]")
    public WebElement FleetLinkDropdown;

    @FindBy(xpath = "//span[.='Vehicles']")
    public WebElement VehiclesOption;

    @FindBy(xpath = "//label[@class='dib'][2]")
    public WebElement totalPgeNumber;

    @FindBy(xpath = "//label[@class='dib'][3]")
    public WebElement totalVehicleRecords;

    @FindBy(xpath = "//i[@class='fa-chevron-right hide-text']/..")
    public WebElement nextButton;

    @FindBy(xpath = "//i[@class='fa-chevron-left hide-text']/..")
    public WebElement previousButton;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement numberBetweenTheNextAndPreviousButton;

    @FindBy(xpath = "//i[@class='fa-upload']/..")
    public WebElement exportGridButton;

    @FindBy(xpath = "//a[@title='CSV']")
    public WebElement csvButton;

    @FindBy(xpath = "//a[@title='XLSX']")
    public WebElement xlsxButton;

    @FindBy(xpath = "//div[@class='message']")
    public WebElement downloadMessage;


    //---locators for login----------------
    @FindBy(id = "prependedInput")
    private WebElement usernameField;

    @FindBy(id = "prependedInput2")
    private WebElement passwordField;

    @FindBy(id = "_submit")
    private WebElement loginBtn;

    //----methodsForLogin
    public void loginAsUser() {
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginBtn.click();
    }






}