package com.navfort.step_definitions;

import com.navfort.pages.BasePage;
import com.navfort.pages.Filter_GenaralPage;
import com.navfort.pages.LoginPage;
import com.navfort.pages.VehiclePage;
import com.navfort.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NVF797_FilterGeneral {

    BasePage basePage = new BasePage();
LoginPage loginPage = new LoginPage();
VehiclePage vehiclePage = new VehiclePage();
Filter_GenaralPage filter_genaralPage = new Filter_GenaralPage();




    @Given("user should log in with valid credentials and navigate to the fleet vehicle page")
    public void user_should_log_in_with_valid_credentials_and_navigate_to_the_fleet_vehicle_page() {
      loginPage.loginAsDriver();
      basePage.fleetButton.click();
      basePage.vehiclesButton.click();

        System.out.println(filter_genaralPage.checkBoxes);
    }
    @When("user clicks on filter icon, Manage Filter button should be visible")
    public void user_clicks_on_filter_icon_manage_filter_button_should_be_visible() {
        if (filter_genaralPage.manage_filter.isDisplayed()){
            System.out.println("filter is already clicked");
        }else {
            filter_genaralPage.filter_menu.click();
        }

        Assert.assertTrue(filter_genaralPage.manage_filter.isDisplayed());
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
