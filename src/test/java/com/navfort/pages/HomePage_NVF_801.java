package com.navfort.pages;

import com.navfort.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage_NVF_801 {

    public HomePage_NVF_801(){

        PageFactory.initElements(Driver.getDriver(), this);

}

    @FindBy(xpath = "//li[@class='dropdown dropdown-level-1'][1]")
    public WebElement fleet;

    @FindBy(xpath = "//span[.='Vehicles']")
    public WebElement vehicles;




//    @FindBy(xpath = "//h1[@class='oro-subtitle']")
//    public WebElement pageNameDashboard;
//
//    @FindBy(xpath = "//li[@id='user-menu']")
//    public WebElement dropdownLogout;
//
//    @FindBy(xpath = "//a[.='Logout']")
//    public WebElement logoutBtn;
//


    @FindBy(xpath = "//div[@class='dropdown btn-group']")
    public WebElement deleteBtn;


}
