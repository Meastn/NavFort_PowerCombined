package com.navfort.pages;

import com.navfort.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement homePageTitle;

    @FindBy(xpath = "(//li[@class='dropdown dropdown-level-1'])[1]")
    public WebElement fleetButton;

    @FindBy(xpath = "//a[@href='entity/Extend_Entity_Carreservation']")
    public WebElement vehiclesButton;


// Melih's locators ...

    @FindBy(xpath = "//*[@id='user-menu']/a/i")
    public WebElement userMenu;


    @FindBy(xpath = "//i[@class='fa-caret-down']")
    public WebElement userMenuDropDown;


    @FindBy(xpath = "//a[@href='/user/logout']")
    public WebElement logoutButton;

    // Melih's locators--


    @FindBy(xpath = "//div[@class='bar']") // added by Serdar in order to use in BrowserUtils.invisibilityOf
    public WebElement loadingBar;

    @FindBy(xpath = "(//div[@class='loader-mask shown']/div)[2]")
    //added by Serdar in order to use in BrowserUtils.invisibilityOf
    public WebElement spinningWheel;



}
