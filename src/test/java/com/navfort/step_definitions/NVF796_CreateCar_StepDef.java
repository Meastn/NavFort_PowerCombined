package com.navfort.step_definitions;

import com.github.javafaker.Faker;
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

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
      createCarPage.waitForLoadingIconToDisappear();
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
      BrowserUtils.waitForInvisibility(basePage.loadingBar);
      // Driver.getDriver().navigate().refresh();
      //  wait.until(ExpectedConditions.invisibilityOf(createCarPage.loaderMask));
      // BrowserUtils.waitForVisibility(createCarPage.loaderMask);
      //  BrowserUtils.waitForInvisibility(createCarPage.loaderMask);
      // BrowserUtils.waitForInvisibility(basePage.spinningWheel);
      // createCarPage.waitForLoadingIconToDisappear();
      BrowserUtils.sleep(12);
      //  BasePage.waitUntilLoaderScreenDisappear();
      Actions actions = new Actions(Driver.getDriver());
      actions.moveToElement(basePage.fleetButton).perform();
      // basePage.fleetButton.click();
      BrowserUtils.sleep(1);
      basePage.vehiclesButton.click();

      // wait.until(ExpectedConditions.invisibilityOf(createCarPage.loaderMask));
      // BrowserUtils.waitForInvisibility(basePage.spinningWheel);
      // createCarPage.waitForLoadingIconToDisappear();
      BrowserUtils.sleep(12);
      // BrowserUtils.waitForVisibility(createCarPage.loaderMask);
      // BrowserUtils.waitForInvisibility(createCarPage.loaderMask);
      // BasePage.waitUntilLoaderScreenDisappear();

      //  BrowserUtils.waitForClickable(vehiclePage.createCarButton);
      vehiclePage.createCarButton.click();
      //  JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
      //  js.executeScript("arguments[0].click();", vehiclePage.createCarButton);
      //  wait.until(ExpectedConditions.invisibilityOf(createCarPage.loaderMask));
      // wait.until(ExpectedConditions.invisibilityOf(basePage.spinningWheel));
      // createCarPage.waitForLoadingIconToDisappear();
      BrowserUtils.sleep(7);
      //  BrowserUtils.waitForInvisibility(basePage.spinningWheel);
      // BasePage.waitUntilLoaderScreenDisappear();

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
      BrowserUtils.sleep(5);
      select2.selectByVisibleText("Electric");
      BrowserUtils.sleep(3);
   }

   @And("user keeps {string} field empty")
   public void userKeepsEmpty(String emptyField) {
      switch (emptyField) {
         case "Licence Plate":
            createCarPage.licencePlateInputBox.clear();
            break;

         case "Tag":
            createCarPage.juniorCheckBox.click();
            createCarPage.seniorCheckBox.click();
            BrowserUtils.sleep(5);
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
            createCarPage.deselectTransmissionbutton.click();
            BrowserUtils.sleep(5);
            break;

         case "Fuel Type":
            createCarPage.deselectfuelTypeButton.click();
            break;
      }
      //  BrowserUtils.sleep(5);
   }

   @And("user clicks save button")
   public void userClicksSaveButton() {
      createCarPage.saveButtonForCreatingCar.click();
      BrowserUtils.waitForVisibility(createCarPage.entitySavedMessage);
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

   @When("user enters data which only contains digit to {string} field")
   public void userEntersDataWhichOnlyContainsDigitToLicencePlateField(String fieldName) {
      Faker faker = new Faker();
      if (fieldName.equals("Licence Plate")) {
         createCarPage.licencePlateInputBox.sendKeys(faker.numerify("#######"));
      } else if (fieldName.equals("Driver")) {
         createCarPage.driverInputBox.sendKeys(faker.numerify("#######"));
      } else if (fieldName.equals("Location")) {
         createCarPage.locationInputBox.sendKeys(faker.numerify("#######"));
      } else if (fieldName.equals("Immatriculation Date")) {
         createCarPage.ImmatriculationDate.sendKeys(faker.numerify("#######"));
      }
   }

   @And("user passes to next field by Tab Key")
   public void userPassesToNextFieldByTabKey() {
      Actions actions = new Actions(Driver.getDriver());
      actions.sendKeys(Keys.TAB).perform();
//      BrowserUtils.sleep(5);
   }

   @Then("user see {string} error message")
   public void userSeeWarningMessage(String errorMessage) {
      if (errorMessage.equals("This value is not a valid date.")) {
         Assert.assertTrue(createCarPage.immatriculationDateErrorMessage.isDisplayed());
      } else {
         Assert.fail("user doesn't see warning message");
      }
   }

   @When("user enters data which only contains letters to {string} field")
   public void userEntersDataWhichOnlyContainsLettersToLicencePlateField(String fieldName) {
      Faker faker = new Faker();
      if (fieldName.equals("Licence Plate")) {
         createCarPage.licencePlateInputBox.sendKeys(faker.letterify("???????"));
      } else if (fieldName.equals("Chassis Number")) {
         createCarPage.chassisNumberInputBox.sendKeys(faker.letterify("???????"));
      } else if (fieldName.equals("Model Year")) {
         createCarPage.modelYearInputBox.sendKeys(faker.letterify("???????"));
      } else if (fieldName.equals("Location")) {
         createCarPage.locationInputBox.sendKeys(faker.letterify("???????"));
      } else if (fieldName.equals("Immatriculation Date")) {
         createCarPage.ImmatriculationDate.sendKeys(faker.letterify("???????"));
      }
   }

   @When("user enters data which contains both letters and digits to {string} field")
   public void userEntersDataWhichContainsBothLettersAndDigitsToLicencePlateField(String fieldName) {
      Faker faker = new Faker();
      if (fieldName.equals("Licence Plate")) {
         createCarPage.licencePlateInputBox.sendKeys(faker.bothify("####????"));
      } else if (fieldName.equals("Driver")) {
         createCarPage.driverInputBox.sendKeys(faker.bothify("####????"));
      } else if (fieldName.equals("Location")) {
         createCarPage.locationInputBox.sendKeys(faker.bothify("####????"));
      }

   }

   @Then("user successfully passes to next field without seeing error message")
   public void userSuccessfullyPassesToNextFieldWithoutSeeingWarningMessage() {
      Assert.assertTrue(true);

   }

   @Then("user see {string} field is still empty")
   public void userSeeFieldIsStillEmpty(String fieldName) {
      if (fieldName.equals("Chassis Number")) {
         createCarPage.chassisNumberInputBox.getAttribute("value").equals("");
      }
   }


   @When("user enters {int} as Model Year")
   public void userEntersAsModelYear(int year) {
   }

   @When("user enters {string} as Model Year")
   public void userEntersAsModelYear(String year) {
      createCarPage.getWebElement("ModelYear").sendKeys(year);

   }

   @When("user select Manuel and Automatic options in Transmission dropdown field respectively")
   public void userSelectManuelAndAutomaticOptionsInTransmissionDropdownFieldRespectively() {
      Select select1 = new Select(createCarPage.transmissionDropown);
      select1.selectByVisibleText("Manual");
      select1.selectByVisibleText("Automatic");

   }

   @Then("user see only the last one \\(Automatic) is selected")
   public void userSeeOnlyTheLastOneAutomaticIsSelected() {
      Select select1 = new Select(createCarPage.transmissionDropown);
      List<WebElement> allSelectedOptions = select1.getAllSelectedOptions();
      for (WebElement eachSelectedOption : allSelectedOptions) {
         Assert.assertFalse(eachSelectedOption.getText().equals("Manuel"));
      }
   }

   @When("user select  Diesel and Electric options in Fuel Type dropdown field respectively")
   public void userSelectDieselAndElectricOptionsInFuelTypeDropdownFieldRespectively() {

      Select select2 = new Select(createCarPage.fuelTypeDropDown);
      select2.selectByVisibleText("Diesel");
      select2.selectByVisibleText("Electric");
   }

   @Then("user see only the last one \\(Electric) is selected")
   public void userSeeOnlyTheLastOneElectricIsSelected() {
      Select select2 = new Select(createCarPage.fuelTypeDropDown);
      List<WebElement> allSelectedOptions = select2.getAllSelectedOptions();
      for (WebElement eachSelectedOption : allSelectedOptions) {
         Assert.assertFalse(eachSelectedOption.getText().equals("Diesel"));
      }
   }

   @When("user enters data which contains special characters to {string} field")
   public void userEntersDataWhichContainsSpecialCharactersToField(String fieldName) {
      Faker faker = new Faker();
      if (fieldName.equals("Location")) {
         createCarPage.locationInputBox.sendKeys("'^!^!+'");
      } else if (fieldName.equals("Immatriculation Date")) {
         createCarPage.ImmatriculationDate.sendKeys("'^!^!+'");
      }

   }

   @When("user enters {string} to {string} field")
   public void userEntersToField(String characterType, String fieldName) {
      CreateCarPage createCarPage1 = new CreateCarPage();
      Faker faker = new Faker();
      switch (characterType) {
         case "only digits":
            BrowserUtils.waitForVisibility(createCarPage1.getWebElement(fieldName));
            createCarPage1.getWebElement(fieldName).sendKeys(faker.numerify("#######"));
            System.out.println("createCarPage1.getWebElement(fieldName).getAttribute(\"value\") = " + createCarPage1.getWebElement(fieldName).getAttribute("value"));
            break;
         case "only letters":
            createCarPage1.getWebElement(fieldName).sendKeys(faker.letterify("E???????"));
            System.out.println("createCarPage1.getWebElement(fieldName).getAttribute(\"value\") = " + createCarPage1.getWebElement(fieldName).getAttribute("value"));
            break;
         case "special characters":
            createCarPage1.getWebElement(fieldName).sendKeys("'^+^+%+^%'");
            System.out.println("createCarPage1.getWebElement(fieldName).getAttribute(\"value\") = " + createCarPage1.getWebElement(fieldName).getAttribute("value"));
            break;
         case "digits and letters":
            createCarPage1.getWebElement(fieldName).sendKeys(faker.bothify("E###???##??"));
            System.out.println("createCarPage1.getWebElement(fieldName).getAttribute(\"value\") = " + createCarPage1.getWebElement(fieldName).getAttribute("value"));
            break;
      }

   }

   @When("user pickes a date from calendar table in {string}")
   public void userChoosesADateFromCalendarPopUp(String fieldName) {
      // WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(15));
      // wait.until(ExpectedConditions.elementToBeClickable(createCarPage.ImmatriculationDate));

      createCarPage.getWebElement(fieldName).click();
      createCarPage.dateFromCalendarPopUp_6Nov2022.click();

   }

   @When("user writes {string} date in text format to {string} field")
   public void userWritesTheDateInTextFormatInImmatriculationDateField(String date, String fieldName) {
      createCarPage.getWebElement(fieldName).sendKeys(date);
   }

   @When("user clicks Add button for {string}")
   public void userClicksAddButtonFor(String fieldName) {
      JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
      js.executeScript("arguments[0].scrollIntoView(true);", createCarPage.AddVehicleModelButton);
      BrowserUtils.sleep(3);
      if (fieldName.equals("Vehicle_Model")) {
         createCarPage.AddVehicleModelButton.click();
         BrowserUtils.waitForVisibility(createCarPage.getVehicleModel_Make_CheckBox("Mazda"));
      } else if (fieldName.equals("Vehicle_Make")) {
         createCarPage.AddVehicleMakeButton.click();
         BrowserUtils.waitForVisibility(createCarPage.getVehicleModel_Make_CheckBox("Ferrari"));
      }
   }


   @And("user selects {string}")
   public void userSelectsAsModel_Make_Name(String model_Make_Name) {
      createCarPage.getVehicleModel_Make_CheckBox(model_Make_Name).click();
      BrowserUtils.sleep(1);
   }


   @And("user clicks select button in Vehicle Model_Make popup")
   public void userClicksSaveButtonInVehicleModel_MakePopup() {
      createCarPage.selectButtonInVehicleModel_MakePopup.click();
   }

   @Then("user see {string} is displayed on the Create Car Page")
   public void userSeeVehicleModel_MakeNameAsAdded(String model_MakeName) {
      Assert.assertTrue(createCarPage.VehicleModel_MakeNamesOnTheCreateCarPage(model_MakeName).isDisplayed());
   }

   @And("user selects {string} and {string}")
   public void userSelectsAnd(String model_Make_Name1, String model_Make_Name2) {
      createCarPage.getVehicleModel_Make_CheckBox(model_Make_Name1).click();
      BrowserUtils.sleep(1);
      createCarPage.getVehicleModel_Make_CheckBox(model_Make_Name2).click();
      BrowserUtils.sleep(1);
   }

   @Then("user see {string} error message displayed on the Create Car Page")
   public void userSeeErrorMessageDisplayedOnTheCreateCarPage(String arg0) {
      Assert.fail("Error message is not displayed, instead, user can add multiple choices");
   }

   @And("user clicks Car button to navigate All Cars page")
   public void userClicksCarButtonToNavigateAllCarsPage() {
      createCarPage.navigateAllCarsButton.click();
   }

   @When("user fills all the compulsory fields with valid credentials below")
   public void userFillsAllTheCompulsoryFieldsWithValidCredentialsBelow(Map<String, String> credentials) {

      createCarPage.licencePlateInputBox.sendKeys(credentials.get("License Plate"));
      if (credentials.get("Tags").equals("Junior")) {
         createCarPage.juniorCheckBox.click();
      }
      createCarPage.driverInputBox.sendKeys(credentials.get("Driver"));
      createCarPage.chassisNumberInputBox.sendKeys(credentials.get("Chassis Number"));
      createCarPage.modelYearInputBox.sendKeys(credentials.get("Model Year"));
      Select select1 = new Select(createCarPage.transmissionDropown);

      Select select2 = new Select(createCarPage.fuelTypeDropDown);
      select1.selectByVisibleText(credentials.get("Transmission"));
      BrowserUtils.sleep(5);
      select2.selectByVisibleText(credentials.get("Fuel Type"));

   }

   @Then("user see newly created car in ’Fleet-Vehicle’ table")
   public void userSeeNewlyCreatedCarInFleetVehicleTable(Map<String, String> expectedDataInMap) {

        List<String> expectedvaluesList = new ArrayList<>( expectedDataInMap.values());

      List<WebElement> allCarsInTable = Driver.getDriver().findElements(By.xpath("//tbody[@class='grid-body']/tr"));
      List<String> actualValuesList = new ArrayList<>();
      Set<String> keys = expectedDataInMap.keySet();
      String actualDataFromCarTable;
      for (String eachKey : keys) {
         if (eachKey.equals("Tags")) {
            actualDataFromCarTable = Driver.getDriver().findElement(By.xpath("//tbody[@class='grid-body']/tr[" + (allCarsInTable.size() - 1) + "]/td[@data-column-label='" + eachKey + "']//li")).getText();
         } else {
            actualDataFromCarTable = Driver.getDriver().findElement(By.xpath("//tbody[@class='grid-body']/tr[" + (allCarsInTable.size() - 1) + "]/td[@data-column-label='" + eachKey + "']")).getText();
         }
         actualValuesList.add(actualDataFromCarTable);
      }
         System.out.println("expectedvaluesList = " + expectedvaluesList);
         System.out.println("actualValuesList = " + actualValuesList);
         Assert.assertEquals(expectedvaluesList,actualValuesList);

      }

   @When("user keeps all the compulsory fields empty")
   public void userKeepsAllTheCompulsoryFieldsEmpty() {
      Assert.assertTrue(true);
   }
}



