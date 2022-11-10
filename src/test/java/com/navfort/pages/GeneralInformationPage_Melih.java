package com.navfort.pages;

import com.navfort.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GeneralInformationPage_Melih {
    @FindBy(xpath = "/html/body/div[2]/div[2]/header/div[2]/ul/li[2]/a/span")
    public WebElement fleetTitleLevel;

    @FindBy(xpath = "/html/body/div[2]/div[2]/header/div[2]/ul/li[2]/div/div/ul/li[1]/span")
    public WebElement fleet;


    public GeneralInformationPage_Melih (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    
    
    
    
}
