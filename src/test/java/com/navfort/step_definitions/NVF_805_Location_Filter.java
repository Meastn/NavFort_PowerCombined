package com.navfort.step_definitions;

import com.navfort.pages.BasePage;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NVF_805_Location_Filter {


    VehiclePage vehiclePage = new VehiclePage();
    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();

    Select select;
    WebDriverWait wait;

    //US-1---> up to the location dropdown
    @Given("user is login with valid credentials and on the vehicle page")
    public void user_is_login_with_valid_credentials_and_on_the_vehicle_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginAsUserType("driver");
        BrowserUtils.waitForInvisibility(basePage.spinningWheel);
        //go to the fleet vehicle page
        basePage.fleetButton.click();
        basePage.vehiclesButton.click();
        BrowserUtils.sleep(3);

    }

    @When("user clicks the filter icon")
    public void user_clicks_the_filter_icon() {
            vehiclePage.filterBtn.click();
            BrowserUtils.sleep(4);
    }


    @And("user clicks the manage filters dropdown and select the location option")
    public void userClicksTheManageFiltersDropdownAndSelectTheLocationOption() {
//        select=new Select(vehiclePage.manageFiltersSelectDropdown);
//        select.selectByValue("Location");
        vehiclePage.manageFiltersLink.click();
//        BrowserUtils.sleep(4);
        vehiclePage.locationOption.click();
        wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(vehiclePage.locationFilterDropdown));

    }


    @Then("user should be able to see Location filter dropdown")
    public void user_should_be_able_to_see_location_dropdown() {

        Assert.assertTrue( vehiclePage.locationFilterDropdown.isDisplayed());
        vehiclePage.locationFilterDropdown.click();

        BrowserUtils.sleep(4);


    }
//US-2-----> "Location" filter has the methods below:
//
//Contains
//Does Not Contain
//Is Equal To
//Starts With
//Ends With
//Is Any Of
//Is Not Any Of
//Is Empty
//Is Not Empty

    @When("user clicks the location filter dropdown")
    public void user_clicks_the_location_filter_dropdown() {



    }
    @When("user clicks the method-filter dropdown")
    public void user_clicks_the_method_filter_dropdown() {

    }
    @Then("user should be able to see following {string}")
    public void user_should_be_able_to_see_following() {


    }



}
