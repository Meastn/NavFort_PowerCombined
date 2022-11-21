package com.navfort.pages;

import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.Driver;
import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreateCarPage extends BasePage {
   public CreateCarPage() {
      PageFactory.initElements(Driver.getDriver(), this);
   }


   @FindBy(xpath = "//input[@name='custom_entity_type[LicensePlate]']")
   public WebElement licencePlateInputBox;

   @FindBy(xpath = "(//input[@name='custom_entity_type[Tags][]'])[1]")
   public WebElement juniorCheckBox;

   @FindBy(xpath = "(//input[@name='custom_entity_type[Tags][]'])[2]")
   public WebElement seniorCheckBox;

   @FindBy(xpath = "//input[@name='custom_entity_type[Driver]']")
   public WebElement driverInputBox;

   @FindBy(xpath = "//input[@name='custom_entity_type[ChassisNumber]']")
   public WebElement chassisNumberInputBox;

   @FindBy(xpath = "//input[@name='custom_entity_type[ModelYear]']")
   public WebElement modelYearInputBox;

   @FindBy(xpath = "//select[@name='custom_entity_type[Transmission]']")
   public WebElement transmissionDropown;

   @FindBy(xpath = "(//abbr)[1]")
   public WebElement deselectTransmissionbutton;

   @FindBy(xpath = "//select[@name='custom_entity_type[FuelType]']")
   public WebElement fuelTypeDropDown;

   @FindBy(xpath = "(//abbr)[2]")
   public WebElement deselectfuelTypeButton;

   @FindBy(xpath = "//input[@name='custom_entity_type[Location]']")
   public WebElement locationInputBox;

   @FindBy(xpath = "//input[@name='custom_entity_type[LastOdometer]']")
   public WebElement lastOdometerInputBox;

   @FindBy(xpath = "//input[contains(@id,'date_selector_custom_entity_type_ImmatriculationDate')]")
   public WebElement ImmatriculationDate;

   @FindBy(xpath = "(//span[text()='This value is not a valid date.'])[1]")
   public WebElement immatriculationDateErrorMessage;

   @FindBy(xpath = "//table//a[text()='12']")
   public WebElement dateFromCalendarPopUp_6Nov2022;

   @FindBy(xpath = "(//div[@class='loader-mask shown'])[2]")
   //added from Yakup's approach  in order to use in BrowserUtils.invisibilityOf
   public WebElement loaderMask;

   @FindBy(xpath = "//div[@class='loader-mask shown']")
   //added from Yakup's approach  in order to use in BrowserUtils.invisibilityOf
   public List<WebElement> loaderMaskList;

   @FindBy(xpath = "(//span[text()='This value is not a valid date.'])[2]")
   public WebElement firstContanctDateErrorMessage;


   @FindBy(xpath = "//input[contains(@id,'date_selector_custom_entity_type_FirstContractDate')]")
   public WebElement firstContactDate;

   @FindBy(xpath = "//input[contains(@id,'custom_entity_type_CatalogValue')]")
   public WebElement CatalogValue;

   @FindBy(xpath = "//input[contains(@id,'custom_entity_type_SeatsNumber')]")
   public WebElement SeatsNumber;

   @FindBy(xpath = "//input[contains(@id,'custom_entity_type_DoorsNumber')]")
   public WebElement DoorsNumber;

   @FindBy(xpath = "//input[contains(@id,'custom_entity_type_Color')]")
   public WebElement Color;

   @FindBy(xpath = "//input[contains(@id,'custom_entity_type_CO2Emissions')]")
   public WebElement CO2Emissions;

   @FindBy(xpath = "//input[contains(@id,'custom_entity_type_Horsepower')]")
   public WebElement Horsepower;

   @FindBy(xpath = "//input[contains(@id,'custom_entity_type_HorsepowerTaxation')]")
   public WebElement HorsepowerTaxation;

   @FindBy(xpath = "//input[contains(@id,'custom_entity_type_Power')]")
   public WebElement Power;


   @FindBy(xpath = "//button[@class='btn btn-success action-button']")
   public WebElement saveButton;

   @FindBy(xpath = "//div[text()='Entity saved']")
   public WebElement entitySavedMessage;




   @FindBy(xpath = "(//div[@class='loader-mask shown']/div)[2]")
   //added by Serdar in order to use in BrowserUtils.invisibilityOf
   public List<WebElement> spinningWheel;

   @FindBy(xpath = "(//button[@class='btn btn-medium add-btn'])[1]")
   public WebElement AddVehicleModelButton;

   @FindBy(xpath = "(//button[@class='btn btn-medium add-btn'])[2]")
   public WebElement AddVehicleMakeButton;

   @FindBy(xpath = "//button[.='Select']")
   public WebElement selectButtonInVehicleModel_MakePopup;

   public WebElement getWebElement(String idStartsWith) {
      WebElement element;
      if (idStartsWith.equals("ImmatriculationDate")) {
         element = Driver.getDriver().findElement(By.xpath("//input[starts-with(@id,'date_selector_custom_entity_type_ImmatriculationDate')]"));
      } else if (idStartsWith.equals("FirstContractDate")) {
         element = Driver.getDriver().findElement(By.xpath("//input[starts-with(@id,'date_selector_custom_entity_type_FirstContractDate')]"));
      } else { //else part dynamically gets the inputbox elements
         element = Driver.getDriver().findElement(By.xpath("//input[starts-with(@id,'custom_entity_type_" + idStartsWith + "')]"));
      }
      return element;
   }

   public WebElement getVehicleModel_Make_CheckBox(String model_Make_Name) {
      return Driver.getDriver().findElement(By.xpath("//td[text()='" + model_Make_Name + "\']/preceding-sibling::td/input"));
   }

   public WebElement VehicleModel_MakeNamesOnTheCreateCarPage(String modelMakeName) {
      return Driver.getDriver().findElement(By.xpath("//a[.='" + modelMakeName + " ']"));
   }


   public void waitForLoadingIconToDisappear() {
      int count = 0;
      while (spinningWheel.size() != 0 && count < 10) {
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         count++;
      }
   }

}

