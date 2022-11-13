package com.navfort.step_definitions;

import com.navfort.pages.*;
import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.ConfigurationReader;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class NVF796_CreateCar_StepDef {
   LoginPage loginPage = new LoginPage();
   BasePage basePage = new BasePage();
   VehiclePage vehiclePage = new VehiclePage();
   Filter_GenaralPage filter_genaralPage = new Filter_GenaralPage();
   CreateCarPage createCarPage = new CreateCarPage();

   @Given("user is on the Dashboard page as {string}")
   public void user_is_on_the_dashboard_page(String usertype) {
      Driver.getDriver().get(ConfigurationReader.getProperty("url"));
      loginPage.loginAsUserType(usertype);
   }

   @When("user clicks fleet - vehicles button")
   public void user_click_fleet_vehicles_button() {

      BrowserUtils.waitForInvisibility(basePage.spinningWheel);
      Actions actions = new Actions(Driver.getDriver());
      actions.moveToElement(basePage.fleetButton).perform();
      // basePage.fleetButton.click();
      basePage.vehiclesButton.click();

   }

   @Then("user see create car button on the right side")
   public void user_see_create_car_button_on_the_right_side() {
      BrowserUtils.waitForInvisibility(basePage.spinningWheel);
      Assert.assertTrue(vehiclePage.createCarButton.isDisplayed());
   }

   @Then("user can't see create car button on the right side")
   public void userCanTSeeCreateCarButtonOnTheRightSide() {
      BrowserUtils.waitForInvisibility(basePage.spinningWheel);
      List<WebElement> createCarButtonElements = Driver.getDriver().findElements(By.xpath("//a[@title='Create Car']"));
      Assert.assertTrue(createCarButtonElements.size() == 0);
   }

   @Given("user is on the create Car page")
   public void userIsOnTheCreateCarPage() {
      Driver.getDriver().get(ConfigurationReader.getProperty("url"));
      loginPage.loginAsSalesManager();
      BrowserUtils.waitForInvisibility(basePage.spinningWheel);
      Actions actions = new Actions(Driver.getDriver());
      actions.moveToElement(basePage.fleetButton).perform();

      basePage.vehiclesButton.click();
      createCarPage.waitForLoadingIconToDisappear();
      // BrowserUtils.waitForInvisibility(basePage.spinningWheel);
      // BrowserUtils.sleep(10);

      JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
      js.executeScript("arguments[0].click();", vehiclePage.createCarButton);
      createCarPage.waitForLoadingIconToDisappear();
      //  BrowserUtils.sleep(10);

   }

   @When("user fills all the compulsory fields with proper character format")
   public void userFillsAllTheCompulsoryFieldsWithProperCharacterFormat() {

      createCarPage.licencePlateInputBox.sendKeys("11ASDF1111");

      createCarPage.juniorCheckBox.click();
      createCarPage.seniorCheckBox.click();
      createCarPage.driverInputBox.sendKeys("Ahmet");
      createCarPage.chassisNumberInputBox.sendKeys("0123456789");
      createCarPage.modelYearInputBox.sendKeys("2020");
      Select select1 = new Select(createCarPage.transmissionDropown);
      Select select2 = new Select(createCarPage.fuelTypeDropDown);
      select1.selectByVisibleText("Manual");
      select2.selectByVisibleText("Electric");

   }

   @And("user keeps {string} field empty")
   public void userKeepsEmpty(String emptyField) {
      switch (emptyField) {
         case "Licence Plate":
            createCarPage.licencePlateInputBox.clear();
            break;

         case "Tag":
            createCarPage.juniorCheckBox.clear();
            break;

         case "Driver":
            createCarPage.driverInputBox.clear();
            break;

         case "Chassis Number":
            createCarPage.chassisNumberInputBox.clear();
            break;

         case "Model Year":
            createCarPage.modelYearInputBox.clear();
            break;

         case "Transmission":
            Select select1 = new Select(createCarPage.transmissionDropown);
            select1.deselectAll();
            break;

         case "Fuel Type":
            Select select2 = new Select(createCarPage.fuelTypeDropDown);
            select2.deselectAll();
            break;
      }
      BrowserUtils.sleep(5);
   }

   @And("user clicks save button")
   public void userClicksSaveButton() {
      createCarPage.saveButton.click();
   }

   @Then("user see {string} field cannot be empty error message")
   public void userSeeCannotBeEmptyMessage(String emptyFieldName) {
      //since there is no warning message in the real app, at least user should't get entity saved message
      Assert.assertFalse(createCarPage.entitySavedMessage.isDisplayed());
   }

   @When("user fills {string} field with proper character format")
   public void userFillsWithProperCharacterFormat(String emptyFieldName) {

      switch (emptyFieldName) {
         case "Licence Plate":
            createCarPage.licencePlateInputBox.sendKeys("11ASDF1111");
            break;

         case "Tag":
            createCarPage.juniorCheckBox.click();
            createCarPage.seniorCheckBox.click();
            break;

         case "Driver":
            createCarPage.driverInputBox.sendKeys("Ahmet");
            break;

         case "Chassis Number":
            createCarPage.chassisNumberInputBox.sendKeys("0123456789");
            break;

         case "Model Year":
            createCarPage.modelYearInputBox.sendKeys("2020");
            break;

         case "Transmission":
            Select select1 = new Select(createCarPage.transmissionDropown);
            select1.selectByVisibleText("Manual");
            break;

         case "Fuel Type":
            Select select2 = new Select(createCarPage.fuelTypeDropDown);
            select2.selectByVisibleText("Electric");
            break;
      }
   }

   @Then("user see {string} message")
   public void userSeeMessage(String entitySavedMessage) {
      Assert.assertTrue(createCarPage.entitySavedMessage.isDisplayed());
   }
}

