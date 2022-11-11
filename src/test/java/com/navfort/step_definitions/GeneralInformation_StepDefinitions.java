package com.navfort.step_definitions;

import com.navfort.pages.BasePage;
import com.navfort.pages.GeneralInformationPage;
import com.navfort.pages.LoginPage;
import com.navfort.pages.VehiclePage;
import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.ConfigurationReader;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GeneralInformation_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    VehiclePage vehiclePage = new VehiclePage();
    BasePage basePage = new BasePage();
    GeneralInformationPage generalInformationPage = new GeneralInformationPage();

    @When("User is on login page")
    public void user_is_on_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginAsSalesManager();
    }

    @Given("User clicks fleet and vehicles menu items")
    public void userClicksFleetAndVehiclesMenuItems() {
        BrowserUtils.sleep(10);
        basePage.fleetButton.click();
        basePage.vehiclesButton.click();
    }

    @Given("User clicks any row")
    public void userClicksAnyRow() {
        BrowserUtils.sleep(10);
        vehiclePage.gridRowClickAction.click();
    }

    @Then("User can see the general information page")
    public void userCanSeeTheGeneralInformationPage() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(vehiclePage.car_table));
        String actualPageTitle = generalInformationPage.generalInformationPageTitle.getText();
        String expectedPageTitle = "General Information";
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
    }

    @Given("User clicks on eye icon")
    public void userClicksOnEyeIcon() {
        BrowserUtils.sleep(10);
        Actions action = new Actions(Driver.getDriver());

        Point point = vehiclePage.threeDots.getLocation();

        action.moveToElement(vehiclePage.threeDots).perform();
        action.scrollToElement(vehiclePage.threeDotBar).perform();
        Point point2 = vehiclePage.threeDotBar.getLocation();
        int xcord2 = point2.getX();
        int ycord2 = point2.getY();
        System.out.println("x2= "+ xcord2 + ", y2= " + ycord2);



    }

}
