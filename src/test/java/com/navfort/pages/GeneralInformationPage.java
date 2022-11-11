package com.navfort.pages;

import com.navfort.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GeneralInformationPage {
    @FindBy(xpath = "/html/body/div[2]/div[2]/header/div[2]/ul/li[2]/a/span")
    public WebElement fleetTitleLevel;

    @FindBy(xpath = "/html/body/div[2]/div[2]/header/div[2]/ul/li[2]/div/div/ul/li[1]/span")
    public WebElement fleet;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/h5/span")
    public WebElement generalInformationPageTitle;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[1]/label")
    public WebElement licensePlateHeader;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[1]/div/div")
    public WebElement licensePlateData;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[2]/label")
    public WebElement tagsHeader;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[2]/div/div")
    public WebElement tagsData;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[3]/label")
    public WebElement driverHeader;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[3]/div/div")
    public WebElement driverName;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[4]/label")
    public WebElement locationCHeader;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[4]/div/div")
    public WebElement locationData;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[5]/label")
    public WebElement chassisNumberHeader;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[5]/div/div")
    public WebElement chassisNumberData;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[6]/label")
    public WebElement modelYearHeader;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[6]/div/div")
    public WebElement modelYearData;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[7]/label")
    public WebElement lastOdometerHeader;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[7]/div/div")
    public WebElement lastOdometerData;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[8]/label")
    public WebElement ImmatriculationDateHeader;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[8]/div/div")
    public WebElement ImmatriculationDateData;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[9]/label")
    public WebElement firstContractDateHeader;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[9]/div/div")
    public WebElement firstContractDateData;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[10]/label")
    public WebElement catalogValueVatHeader;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[10]/div/div")
    public WebElement catalogValueVatData;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[11]/label")
    public WebElement seatsNumberHeader;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[11]/div/div")
    public WebElement seatsNumberData;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[12]/label")
    public WebElement doorsNumberHeader;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[12]/div/div")
    public WebElement doorsNumberData;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[13]/label")
    public WebElement colorHeader;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[13]/div/div")
    public WebElement colorData;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[14]/label")
    public WebElement transmissionHeader;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[14]/div/div")
    public WebElement transmissionData;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[15]/label")
    public WebElement fuelTypeHeader;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[15]/div/div")
    public WebElement fuelTypeData;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[16]/label")
    public WebElement emissionsHeader;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[16]/div/div")
    public WebElement emissionsData;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[17]/label")
    public WebElement horsepowerHeader;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[17]/div/div")
    public WebElement horsepowerData;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[18]/label")
    public WebElement horsepowerTaxationHeader;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[18]/div/div")
    public WebElement horsepowerTaxationData;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[19]/label")
    public WebElement powerHeader;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[19]/div/div")
    public WebElement powerData;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[20]/label")
    public WebElement logoHeader;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[20]/div/div")
    public WebElement logoData;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[21]/label")
    public WebElement vehicleModelHeader;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[21]/div/div")
    public WebElement vehicleModelData;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[22]/label")
    public WebElement vehicleMakeHeader;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[22]/div/div")
    public WebElement vehicleMakeData;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[2]/h4")
    public WebElement activityScrollspyTitle;



    public GeneralInformationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    
    
    
    
}
