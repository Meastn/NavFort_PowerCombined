package com.navfort.step_definitions;

import com.navfort.pages.BasePage;
import com.navfort.pages.LoginPage;
import com.navfort.pages.VehiclePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NVF796_CreateCar_StepDef {
        LoginPage loginPage = new LoginPage();
        BasePage basePage = new BasePage();
        VehiclePage vehiclePage = new VehiclePage();

    @Given("user is on the Dashboard page as {string}")
    public void user_is_on_the_dashboard_page(String usertype) {
        loginPage.loginAsUserType(usertype);
    }
    @When("user clicks fleet - vehicles button")
    public void user_click_fleet_vehicles_button() {
       basePage.fleetButton.click();
       basePage.vehiclesButton.click();
    }
    @Then("user see create car button on the right side")
    public void user_see_create_car_button_on_the_right_side() {
        Assert.assertTrue(vehiclePage.createCarButton.isDisplayed());
    }
}
