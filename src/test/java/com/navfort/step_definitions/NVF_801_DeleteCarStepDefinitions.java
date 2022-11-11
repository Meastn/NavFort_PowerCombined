package com.navfort.step_definitions;

import com.navfort.pages.BasePage;
import com.navfort.pages.LoginPage;
import com.navfort.pages.VehiclePage;
import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;

public class NVF_801_DeleteCarStepDefinitions {

    LoginPage loginPage = new LoginPage();
    VehiclePage vehiclePage = new VehiclePage();
    BasePage basePage = new BasePage();
    Actions actions=new Actions(Driver.getDriver());

    @Given("user on the fleet home page as a driver")
    public void user_on_the_fleet_home_page_as_a_driver() {
      Driver.getDriver().get("https://qa.navfort.com/");
      // loginPage.loginAsUserType("driver");
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
        BrowserUtils.sleep(2);
       vehiclePage.deleteBar.isDisplayed();

    }
    @And ( "user try to delete the row" )
    public void userTryToDeleteTheRow() {

    vehiclePage.deleteSign.click();

    vehiclePage.deleteYes.click();

    }

    @Then ( "User see warning message" )
    public void userSeeWarningMessage() {

       vehiclePage.messageWarning.isDisplayed();
    }


    @When("user can delete the line")
    public void user_can_delete_the_line() {

    }
    @When("User see confirmation message")
    public void user_see_confirmation_message() {

    }
    @Then("Deleted item message is seen")
    public void deleted_item_message_is_seen() {


    }



}



