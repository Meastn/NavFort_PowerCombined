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

    @FindBy(xpath = "//table[@class='grid table-hover table table-bordered table-condensed']/tbody//tr[1]//td[20]")
    public WebElement threeDots;

//div[@class='dropdown-menu__placeholder']

 @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu__action-cell launchers-dropdown-menu detach dropdown-menu__floating']")
 public WebElement deleteBar;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu__action-cell launchers-dropdown-menu detach dropdown-menu__floating']//ul//li[3]")
    public WebElement deleteSign;


    @FindBy(xpath = "//div[@class='modal oro-modal-danger in']")
    public WebElement deleteConfirm;


    @FindBy(className= "modal-body")
    public WebElement deleteMessage;


    @FindBy(xpath = "//a[.='Yes, Delete']")
    public WebElement deleteYes;

    @FindBy(className ="message")
    public WebElement messageWarning;


    @FindBy(xpath = "//div[@class='dropdown btn-group']")
    public WebElement deleteBtn;


}
