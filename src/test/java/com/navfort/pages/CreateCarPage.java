package com.navfort.pages;

import com.navfort.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCarPage extends BasePage{
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

   @FindBy(xpath = "//select[@name='custom_entity_type[FuelType]']")
   public WebElement fuelTypeDropDown;





}
