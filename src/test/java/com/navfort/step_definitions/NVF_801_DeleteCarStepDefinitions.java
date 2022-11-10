package com.navfort.step_definitions;

import com.navfort.pages.LoginPage;
import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;

public class NVF_801_DeleteCarStepDefinitions {

    LoginPage loginPage=new LoginPage();
    HomePage_NVF_801 homePage_nvf_801 = new HomePage_NVF_801();
    Actions actions=new Actions(Driver.getDriver());

    @Given("user on the fleet home page as a driver")
    public void user_on_the_fleet_home_page_as_a_driver() {
      Driver.getDriver().get("https://qa.navfort.com/");
        loginPage.usernameInputbox.sendKeys("user1");
         loginPage.passwordInputBox.sendKeys("UserUser123");
        loginPage.loginButton.click();
    }

    @Given("user on the fleet home page as a sales manager")
    public void user_on_the_fleet_home_page_as_a_sales_manager() {
        Driver.getDriver().get("https://qa.navfort.com/");
        loginPage.usernameInputbox.sendKeys("salesmanager101");
        loginPage.passwordInputBox.sendKeys("UserUser123");
        loginPage.loginButton.click();

    }
    @Given("user on the fleet home page as a store manager")
    public void user_on_the_fleet_home_page_as_a_store_manager() {
        Driver.getDriver().get("https://qa.navfort.com/");
        loginPage.usernameInputbox.sendKeys("storemanager85");
        loginPage.passwordInputBox.sendKeys("UserUser123");
        loginPage.loginButton.click();

    }
    @When("user enters the fleet vehicle page")
    public void user_enters_the_fleet_vehicle_page() {

       homePage_nvf_801.fleet.click();
       BrowserUtils.sleep(2);
       homePage_nvf_801.vehicles.click();


    }
    @And ( "user hover over three dots" )
    public void userHoverOverThreeDots() {


        BrowserUtils.sleep(2);
        actions.moveToElement(homePage_nvf_801.threeDots).perform();
    }


    @Then ( "user sees the delete button" )
    public void userSeesTheDeleteButton() {


        actions.scrollToElement(homePage_nvf_801.deleteBar).clickAndHold();
        BrowserUtils.sleep(2);
        homePage_nvf_801.deleteBar.isDisplayed();

    }
    @And ( "user try to delete the row" )
    public void userTryToDeleteTheRow() {

    homePage_nvf_801.deleteSign.click();

    homePage_nvf_801.deleteYes.click();

    }

    @Then ( "User see warning message" )
    public void userSeeWarningMessage() {

       homePage_nvf_801.messageWarning.isDisplayed();
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



