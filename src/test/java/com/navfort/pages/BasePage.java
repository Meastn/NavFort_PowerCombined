package com.navfort.pages;

import com.navfort.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

   public BasePage (){

       PageFactory.initElements(Driver.getDriver(),this);
   }



    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement homePageTitle;

//    @FindBy(xpath = "(//li[@class='dropdown dropdown-level-1'])[1]")
//    public WebElement fleetButton;

    @FindBy(xpath = "//a[@class='unclickable']")
    public WebElement fleetButton;

    @FindBy(xpath = "//a[@href='entity/Extend_Entity_Carreservation']")
    public WebElement vehiclesButton;

// Melih's locators
    
    @FindBy(xpath = "/html/body/div[2]/div[2]/header/div[2]/ul/li[2]/a/span")
    public WebElement fleetButtonAlt;

    @FindBy(xpath = "/html/body/div[2]/div[2]/header/div[2]/ul/li[2]/div/div/ul/li[3]/a/span")
    public WebElement vehiclesButtonAlt;


    @FindBy (xpath = "/html/body/div[4]/div")
    public WebElement spinner;

    @FindBy(xpath = "//*[@id='user-menu']/a/i")
    public WebElement userMenu;


    @FindBy(xpath = "//a[@class='no-hash']")
    public WebElement logoutMenuButton;

 @FindBy(xpath = "/html/body/div[2]/div[2]/header/div[2]/ul/li[1]/a/span")
 public WebElement fleetButtonDriver;

 @FindBy(xpath = "/html/body/div[2]/div[2]/header/div[2]/ul/li[1]/div/div/ul/li[3]/a/span")
 public WebElement vehicleButtonDriver;
 
 
    
    
    // Melih's locators


}
