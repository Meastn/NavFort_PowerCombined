package com.navfort.pages;

import com.navfort.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h2[@class='title']")
    public WebElement loginPageTitle;

    @FindBy(xpath = "//*[@id='prependedInput']")
    public WebElement usernameInputbox;

    @FindBy (name = "_password")
    public WebElement passwordInputBox;

    @FindBy (id="remember_me")
    public  WebElement rememberMeCheckBox;

    @FindBy (xpath = "//a[@href='/user/reset-request']")
    public WebElement forgotPasswordLink;

    @FindBy (id="_submit")
    public WebElement loginButton;

//    @FindBy(name = "_password")
//    public WebElement passwordSpan;

    public void loginToHomepage (String username, String password) {
        usernameInputbox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        loginButton.click();
    }
}
