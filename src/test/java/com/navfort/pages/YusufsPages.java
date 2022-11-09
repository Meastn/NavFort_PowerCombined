package com.navfort.pages;

import com.navfort.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class YusufsPages {


    public YusufsPages(){
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


}
