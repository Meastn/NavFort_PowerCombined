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
import org.openqa.selenium.support.ui.Select;

public class NVF_805_Location_Filter {


    VehiclePage vehiclePage = new VehiclePage();
    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();

    Select select;

    //1- up to the location dropdown
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
        select=new Select(vehiclePage.manageFiltersSelectDropdown);
        select.selectByValue("Location");
        BrowserUtils.sleep(4);
    }


    @Then("user should be able to see Location dropdown")
    public void user_should_be_able_to_see_location_dropdown() {

    }


}
