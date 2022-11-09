package com.navfort.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage_Okan {

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement homePageTitle;

    @FindBy(xpath = "(//li[@class='dropdown dropdown-level-1'])[1]")
    public WebElement fleetButton;

    @FindBy(xpath = "//a[@href='entity/Extend_Entity_Carreservation']")
    public WebElement vehiclesButton;



}
