package com.navfort.step_definitions;

import com.navfort.pages.BasePage;
import com.navfort.pages.Filter_GenaralPage;
import com.navfort.pages.LoginPage;
import com.navfort.pages.VehiclePage;
import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.ConfigurationReader;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.NoSuchElementException;

public class NVF796_CreateCar_StepDef {
   LoginPage loginPage = new LoginPage();
   BasePage basePage = new BasePage();
   VehiclePage vehiclePage = new VehiclePage();
   Filter_GenaralPage filter_genaralPage = new Filter_GenaralPage();

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
}

