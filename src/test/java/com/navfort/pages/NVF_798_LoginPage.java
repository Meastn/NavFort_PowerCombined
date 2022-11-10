package com.navfort.pages;

import com.navfort.utilities.ConfigurationReader;
import com.navfort.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NVF_798_LoginPage {


    @FindBy(xpath = "//h3[.='Loading...']")
    public WebElement loading;
    @FindBy(xpath = "//div[@class='loader-mask']")
    public WebElement loadermask;

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement dashboard;
    @FindBy(xpath = "//h2[.='Login']")
    public WebElement loginText;
    @FindBy(xpath = "//label[.='Username']")
    public WebElement usernameText;
    @FindBy(xpath = "//label[.='Password']")
    public WebElement passwordText;
    @FindBy(xpath = "//input[@id='prependedInput']")
    public WebElement usernameInputField;
    @FindBy(xpath = "//input[@id='prependedInput2']")
    public WebElement passwordInputField;



    @FindBy(xpath = "//span[@class='custom-checkbox__icon']")
    public WebElement rememberMeCheckBox;

    @FindBy(xpath = "//span[.='Remember me on this computer']")
    public WebElement rememberMeText;

    @FindBy(xpath = "//a[.='Forgot your password?']")
    public WebElement forgotYourPassword;
    @FindBy(xpath = "//button[@id='_submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//*[.='© 2018 Oro, Inc. All Rights Reserved']")
    public WebElement copyRightAfterText;

    @FindBy(xpath = "//*[@id='bitnami-close-banner-button']")
    public WebElement bitnamiCloseButton;

    @FindBy(xpath = "//img[@class='bitnami-corner-image']")
    public WebElement bitnamiCornerImage;

    @FindBy(xpath = "//*[.='Invalid user name or password.']")
    public WebElement invalidUsernameAndPasswordMessage;

    public NVF_798_LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void loginWithCredentials(String username, String password) {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        usernameInputField.sendKeys(username);
        passwordInputField.sendKeys(password);
        loginButton.click();
        if (username.equals("user1")) {
            new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15) ).until(ExpectedConditions.invisibilityOf(loading));
        } else {
            new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15)).until(ExpectedConditions.invisibilityOf(loading));
            new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15)).until(ExpectedConditions.invisibilityOf(loadermask));

        }


    }
}
