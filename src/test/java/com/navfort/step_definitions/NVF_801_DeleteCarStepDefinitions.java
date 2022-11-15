package com.navfort.step_definitions;

import com.navfort.pages.BasePage;
import com.navfort.pages.GeneralInformationPage;
import com.navfort.pages.LoginPage;
import com.navfort.pages.VehiclePage;
import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.ConfigurationReader;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class NVF_801_DeleteCarStepDefinitions {

    LoginPage loginPage = new LoginPage();
    VehiclePage vehiclePage = new VehiclePage();
    BasePage basePage = new BasePage();
    GeneralInformationPage generalInformationPage= new GeneralInformationPage();
    Actions actions=new Actions(Driver.getDriver());

    String deletedCarLicensePlate;

    @Given("user on the fleet home page as a driver")
    public void user_on_the_fleet_home_page_as_a_driver() {
        Driver.getDriver().get("https://qa.navfort.com/");
       loginPage.loginAsDriver();
    }

    @Given("user on the fleet home page as a sales manager")
    public void user_on_the_fleet_home_page_as_a_sales_manager() {
        Driver.getDriver().get("https://qa.navfort.com/");
        loginPage.loginAsSalesManager();
    }
    @Given("user on the fleet home page as a store manager")
    public void user_on_the_fleet_home_page_as_a_store_manager() {
        Driver.getDriver().get("https://qa.navfort.com/");
        loginPage.loginAsStoreManager();
    }
    @When("user enters the fleet vehicle page")
    public void user_enters_the_fleet_vehicle_page() {
        BrowserUtils.sleep(2);
       basePage.fleetButton.click();
       BrowserUtils.sleep(2);
      basePage.vehiclesButton.click();

    }
    @And ( "user hover over three dots" )
    public void userHoverOverThreeDots() {

        BrowserUtils.sleep(2);
        actions.moveToElement(vehiclePage.threeDots).perform();
    }

    @Then ( "user sees the delete button" )
    public void userSeesTheDeleteButton() {

        actions.scrollToElement(vehiclePage.deleteBar).clickAndHold();
        BrowserUtils.sleep(5);
       vehiclePage.deleteBar.isDisplayed();
    }
    @When("user can delete the line")
    public void user_can_delete_the_line() {

        vehiclePage.deleteSign.click();
        BrowserUtils.sleep(5);
        vehiclePage.deleteYes.click();
    }
    @Then ( "User see warning message" )
    public void userSeeWarningMessage() {

        BrowserUtils.sleep(3);
       vehiclePage.messageWarning.isDisplayed();
    }
    @When("User see confirmation message")
    public void user_see_confirmation_message() {
        vehiclePage.deleteSign.click();
        BrowserUtils.sleep(5);
        vehiclePage.deleteYes.click();
    }
    @Then("Deleted item message is seen")
    public void deleted_item_message_is_seen() {
        BrowserUtils.sleep(5);
        vehiclePage.itemDeletedMessage.isDisplayed();
    }
    @Given ( "user on the fleet home page as managers" )
    public void userOnTheFleetHomePageAsManagers() {
        Driver.getDriver().get("https://qa.navfort.com/");
        loginPage.loginAsSalesManager();

        basePage.fleetButton.click();
        basePage.vehiclesButton.click();
    }
    @When ( "User clicks any row of car list" )
    public void userClicksAnyRowOfCarList() {
        BrowserUtils.sleep(5);
        vehiclePage.carsTableFirstRow.click();
    }
    @And ( "User can see the delete button and delete the car row" )
    public void userCanSeeTheDeleteButtonAndDeleteTheCarRow() {

        BrowserUtils.sleep(3);
        String deletedCarPlateText = vehiclePage.deletedCarPlate.getText();
        generalInformationPage.deleteButton.click();
        Assert.assertTrue(generalInformationPage.deleteButton.isDisplayed());
    }

    @Then ( "User can see the car deleted message" )
    public void userCanSeeTheCarDeletedMessage() {

        BrowserUtils.sleep(2);
        vehiclePage.deleteYes.click();

        Assert.assertTrue(vehiclePage.itemDeletedMessage.isDisplayed());

    }
    @Then ( "Navigate back to vehicle page" )
    public void navigateBackToVehiclePage() {

       Driver.getDriver().navigate().back();

    }
    @Then ( "user check the deleted row is removed from Fleet-Vehicle page" )
    public void userCheckTheDeletedRowIsRemovedFromFleetVehiclePage() {

        String notExpectedLicensePlate = deletedCarLicensePlate;
        String actualTextCar = vehiclePage.licencePlateCell.getText();

        Assert.assertNotEquals(notExpectedLicensePlate, actualTextCar);

    }
   
}


