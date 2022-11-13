package com.navfort.pages;

import com.navfort.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneralInformationPage {
    public GeneralInformationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
// some
    @FindBy(xpath = "/html/body/div[2]/div[2]/header/div[2]/ul/li[2]/a/span")
    public WebElement fleetTitleLevel;

    @FindBy(xpath = "/html/body/div[2]/div[2]/header/div[2]/ul/li[2]/div/div/ul/li[1]/span")
    public WebElement fleet;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/h5/span")
    public WebElement generalInformationPageTitle;


    @FindBy(xpath = "//a[@title='Edit Car']")
    public WebElement editButton;

    @FindBy(xpath = "//a[@title='Delete Car']")
    public WebElement deleteButton;

    @FindBy(xpath = "//a[contains(@title, 'to')]")
    public WebElement addEventButton;
    
    
    //----
    







}
