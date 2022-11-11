package com.navfort.pages;

import com.navfort.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VehiclePage {


    public VehiclePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='loader-mask shown']")
    public WebElement loader_mask;

    @FindBy (css = "i[class='fa-filter hide-text']")
    public WebElement filter_menu;

    @FindBy(xpath = "//a[@class='add-filter-button']")
    public WebElement manage_filter;

    @FindBy(xpath = "//ul[@class='ui-multiselect-checkboxes ui-helper-reset fixed-li']")
    public WebElement manage_filters_checkbox;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement input_manage_filter;

    @FindBy(xpath = "//tbody[@class='grid-body']")
    public WebElement car_table;

    @FindBy(xpath = "//button[@class='btn dropdown-toggle ']")
    public WebElement view_per_page_button;

    @FindBy(xpath = "//a[@data-size='100']")
    public WebElement full_data_size;


    //Muhammet's Locators
    // comment, comment to cement
    @FindBy(xpath = "//label[@class='control-label']")
    public List<WebElement> controlKeyLabels;

    @FindBy(xpath = "//label[@class='control-label']/../div/div")
    public List<WebElement> controlValueLabels;



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


    //Bilal's locators
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

    @FindBy(xpath = "//a[@title='Create Car']")
    public WebElement createCarButton;

    

}
