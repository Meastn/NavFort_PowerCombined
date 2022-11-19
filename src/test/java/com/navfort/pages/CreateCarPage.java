package com.navfort.pages;

import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.Driver;
import io.cucumber.java.zh_cn.假如;
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

   @FindBy(xpath = "//button[@class='btn btn-success action-button']")
   public WebElement saveButton;

   @FindBy(xpath = "//div[text()='Entity saved']")
   public WebElement entitySavedMessage;


   @FindBy(xpath = "(//div[@class='loader-mask shown']/div)[2]")
   //added by Serdar in order to use in BrowserUtils.invisibilityOf
   public List<WebElement> spinningWheel;

   public void waitForLoadingIconToDisappear() {
      int count = 0;
      while (spinningWheel.size() != 0 && count < 7) {
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
         count++;
      }
   }

}
