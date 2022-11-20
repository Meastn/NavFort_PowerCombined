package com.navfort.pages;

import com.navfort.utilities.Driver;
import org.checkerframework.checker.formatter.qual.Format;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class VehiclePage {


    public VehiclePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    //Muhammet's Locators
    // comment, comment to cement
    @FindBy(xpath = "//label[@class='control-label']")
    public  List<WebElement> controlKeyLabels;

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

    @FindBy(xpath = "//i[@class='fa-eye hide-text']/..")
    public WebElement viewIcon;

    @FindBy(xpath = "//span[@class='grid-header-cell__label']")
    public List<WebElement>TableEachColumnName;
    
    //Bilal's locators
    @FindBy(xpath = "//table[@class='grid table-hover table table-bordered table-condensed']/tbody//tr[1]//td[20]")
    public WebElement threeDots;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu__action-cell launchers-dropdown-menu detach dropdown-menu__floating']")
    public WebElement deleteBar;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu__action-cell launchers-dropdown-menu detach dropdown-menu__floating']//li//li[3]")
    public WebElement deleteSign;

    @FindBy(xpath = "//div[@class='modal oro-modal-danger in']")
    public WebElement deleteConfirm;

    @FindBy(className= "modal-body")
    public WebElement deleteMessage;

    @FindBy(xpath = "//a[.='Yes, Delete']")
    public WebElement deleteYes;

    @FindBy(className ="message")
    public WebElement messageWarning;

    @FindBy(xpath = "//div[@class='flash-messages-holder']//div//div")
    public WebElement itemDeletedMessage;

    @FindBy(id = "prependedInput")
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginBtn;

    //Tags Filter user story

    @FindBy(xpath = " //a[@title='Filters']")
    public WebElement filtersBtn;
  @FindBy(xpath = "//a[@class='add-filter-button']")
    public WebElement manageFilters;

     @FindBy(xpath = "//label[@title='Tags']")
    public WebElement tagsBtn;

    @FindBy(xpath = "//span[@class='filter-items']/div[2]/div[1]")
    public WebElement tagsAll;

    @FindBy(xpath = "//button[@class='btn dropdown-toggle']")
    public WebElement isAnyOf;

    @FindBy(xpath = "//a[.='is not any of']")
     public WebElement selectIsAnyOf;

     @FindBy(xpath = "//a[.='is any of']")
     public WebElement selectIsNotAnyOf;

     @FindBy(xpath = "//a[.='is any of']")
     public WebElement inputIsAnyOf;

     @FindBy(xpath = "//div[.='Compact']")
     public WebElement compact;

     @FindBy(xpath = "//div[.='Sedan']")
     public WebElement sedan;

     @FindBy(xpath = "//button[@class='btn btn-primary filter-update']")
     public WebElement update;

    @FindBy(xpath = "//table/tbody//tr//td[3]")
    public WebElement compactCell;
    @FindBy(xpath = "//h5[@class='user-fieldset']/following-sibling::div/div/div[1]")
    public WebElement deletedCarPlate;

    @FindBy(xpath = "//table/tbody//tr//td[2]")
    public WebElement licensePlateCell;


    //Melih's locators --->>>>>
    @FindBy(xpath = "//tbody[@class='grid-body']/tr[*]")
    public WebElement carsTableFirstRow;

//Serdar's locators
    @FindBy(xpath = "//a[@title='Create Car']")
    public WebElement createCarButton;

    @FindBy(xpath = "//ul[contains(@data-options, 'true,')]")
    public WebElement threeDotBar;

    @FindBy(xpath = "//table")
    public WebElement carsTable;

    @FindBy(css = "a.action\n.no-hash\n.\n.mode-icon-only\n.\n")
    public WebElement viewSign2;

    @FindBy(xpath = "//table/tr[1]")
    public List<WebElement> gridRowClickAction;

    @FindBy (xpath = "//table[@class='grid table-hover table table-bordered table-condensed']/tbody")
    public WebElement tableBody;

    public void iterateTableRows (){
        List <WebElement> rows= Driver.getDriver().findElements(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr"));
        List <String> rowData = new ArrayList<>();

        for(int i=0; i<rows.size(); i++) {
            WebElement tableRowPath = Driver.getDriver().findElement(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr"));
            rowData.add(tableRowPath.getText());
        }

    }
    
//  Melih's locators <<<<---------


    //Okan's locators

    @FindBy(xpath = "//button[@class='btn dropdown-toggle ']")
    public WebElement dropdownViewPerPage;

    @FindBy(xpath = "//a[@data-size='10']")
    public WebElement dropdown10;

    @FindBy(xpath = "//a[@data-size='25']")
    public WebElement dropdown25;

    @FindBy(xpath = "//a[@data-size='50']")
    public WebElement dropdown50;

    @FindBy(xpath = "//a[@data-size='100']")
    public WebElement dropdown100;

    @FindBy(xpath = "//tr[10]")
    public WebElement tenthRow;

    @FindBy(xpath = "//tr[25]")
    public WebElement twentyfifthRow;

    @FindBy(xpath = "//tr[50]")
    public WebElement fiftiethRow;

    @FindBy(xpath = "//tr[58]")
    public WebElement lastRow;

    @FindBy(xpath = "//th[@class='grid-cell grid-header-cell grid-header-cell-LicensePlate sortable renderable shortenable-label string-cell']")
    public WebElement licencePlateColumnTag;

    @FindBy(xpath = "//th[@class='grid-cell grid-header-cell grid-header-cell-Driver sortable renderable shortenable-label string-cell']")
    public WebElement driverColumnTag;

    @FindBy(xpath = "//th[@class='grid-cell grid-header-cell grid-header-cell-Location sortable renderable shortenable-label string-cell']")
    public WebElement locationColumnTag;

    @FindBy(xpath = "//th[@class='grid-cell grid-header-cell grid-header-cell-ChassisNumber sortable renderable shortenable-label number-cell']")
    public WebElement chasisNumberColumnTag;

    @FindBy(xpath = "//th[@class='grid-cell grid-header-cell grid-header-cell-ModelYear sortable renderable shortenable-label string-cell']")
    public WebElement modelYearColumnTag;

    @FindBy(xpath = "//th[@class='grid-cell grid-header-cell grid-header-cell-LastOdometer sortable renderable shortenable-label number-cell']")
    public WebElement lastOdometerColumnTag;

    @FindBy(xpath = "//th[@class='grid-cell grid-header-cell grid-header-cell-ImmatriculationDate sortable renderable shortenable-label date-cell']")
    public WebElement immatriculationDateColumnTag;

    @FindBy(xpath = "//th[@class='grid-cell grid-header-cell grid-header-cell-FirstContractDate sortable renderable shortenable-label date-cell']")
    public WebElement firstContractDateColumnTag;

    @FindBy(xpath = "//th[@class='grid-cell grid-header-cell grid-header-cell-CatalogValue sortable renderable number-cell']")
    public WebElement cvviColumnTag;

    @FindBy(xpath = "//th[@class='grid-cell grid-header-cell grid-header-cell-SeatsNumber sortable renderable shortenable-label number-cell']")
    public WebElement seatsNumberColumnTag;

    @FindBy(xpath = "//th[@class='grid-cell grid-header-cell grid-header-cell-DoorsNumber sortable renderable shortenable-label number-cell']")
    public WebElement doorNumberColumnTag;

    @FindBy(xpath = "//th[@class='grid-cell grid-header-cell grid-header-cell-Color sortable renderable shortenable-label string-cell']")
    public WebElement colorColumnTag;

    @FindBy(xpath = "//th[@class='grid-cell grid-header-cell grid-header-cell-Transmission sortable renderable shortenable-label string-cell']")
    public WebElement transmissionNumberColumnTag;

    @FindBy(xpath = "//th[@class='grid-cell grid-header-cell grid-header-cell-FuelType sortable renderable shortenable-label string-cell']")
    public WebElement fuelTypeNumberColumnTag;

    @FindBy(xpath = "//th[@class='grid-cell grid-header-cell grid-header-cell-CO2Emissions sortable renderable shortenable-label number-cell']")
    public WebElement co2EmissionsNumberColumnTag;

    @FindBy(xpath = "//th[@class='grid-cell grid-header-cell grid-header-cell-Horsepower sortable renderable shortenable-label number-cell']")
    public WebElement horsepowerColumnTag;

    @FindBy(xpath = "//th[@class='grid-cell grid-header-cell grid-header-cell-HorsepowerTaxation sortable renderable shortenable-label number-cell']")
    public WebElement horsepowerTaxColumnTag;

    @FindBy(xpath = "//th[@class='grid-cell grid-header-cell grid-header-cell-Power sortable renderable shortenable-label number-cell']")
    public WebElement powerColumnTag;

    @FindBy(xpath = "//a[@title='Reset']")
    public WebElement resetBtn;

    @FindBy(xpath = "//i[@class='fa-filter hide-text']")
    public WebElement filterBtn;

    @FindBy(xpath = "//a[.='Manage filters']")
    public WebElement manageFilterBtn;

    @FindBy(xpath = "//input[@title='Location']")
    public WebElement locationFilterCheckBox;

    //NVF-798 Grid Settings Kenan Locators  And Methods Begin
    @FindBy(xpath = "//a[@title='Grid Settings']")
    public WebElement gearIcon;

    @FindBy(xpath = "//div[.='Grid Settings']")
    public WebElement gridSettingsText;

    @FindBy(xpath ="//input[@placeholder='Quick Search']")
    public WebElement inputQuickSeach;

    @FindBy ( xpath="//span[.='No columns found']")
    public WebElement noColumnsFoundText;

    @FindBy(xpath = "//td[@class='title-cell']")
    public List<WebElement> columnNames;

    @FindBy(xpath = "//span[@class='grid-header-cell__label']")
    public List<WebElement> headerCells;

    @FindBy(xpath = "//span[@title='Move column']")
    public List<WebElement> moveColumns;

    @FindBy (xpath = "//td[@class='visibility-cell']")
    public List<WebElement>  visibilityCells;

    //NVF-798 Grid Settings Kenan Locators And Methods Ends

    //Huseyin's locator

    @FindBy (xpath = "//tbody[@class='grid-body']/tr[2]")
    public WebElement secondRowOfCarList;

    @FindBy (xpath = "//a[text()='Add Event']")
    public WebElement addEventButton;




}
