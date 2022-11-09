package com.navfort.step_definitions;

import com.navfort.pages.LoginPage;
import com.navfort.pages.YusufsPages;
import com.navfort.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class YusufsStepDefs {

LoginPage loginPage = new LoginPage();
YusufsPages yusufsPages = new YusufsPages();




    @Given("user should log in with valid credentials and navigate to the fleet vehicle page")
    public void user_should_log_in_with_valid_credentials_and_navigate_to_the_fleet_vehicle_page() {
    String driver_username = ConfigurationReader.getProperty("driver_username");
    String driver_password = ConfigurationReader.getProperty("driver_password");

    String sales_manager_username = ConfigurationReader.getProperty("sales_manager_username");
    String sales_manager_password = ConfigurationReader.getProperty("sales_manager_password");

        loginPage.loginToHomepage(driver_username,driver_password);
    }
    @When("user clicks on filter icon, Manage Filter button should be visible")
    public void user_clicks_on_filter_icon_manage_filter_button_should_be_visible() {
        if (yusufsPages.manage_filter.isDisplayed()){
            System.out.println("filter is already clicked");
        }else {
            yusufsPages.filter_menu.click();
        }

        Assert.assertTrue(yusufsPages.manage_filter.isDisplayed());
    }
    @When("User can apply filters by clicking on <filter_name>")
    public void user_can_apply_filters_by_clicking_on_filter_name() {

    }
    @When("User can find filters by typing the <filter_name_type>")
    public void user_can_find_filters_by_typing_the_filter_name_type() {

    }
    @Then("User can apply multiple filters at the same time")
    public void user_can_apply_multiple_filters_at_the_same_time() {

    }
    @Then("User can remove all filters by clicking on the reset icon")
    public void user_can_remove_all_filters_by_clicking_on_the_reset_icon() {

    }

}
