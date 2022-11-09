package com.navfort.step_definitions;

import com.navfort.pages.NVF_800_Fleet_Vehicle_Page;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class NVF_800_VehicleTableViewStepDefinitions {

        NVF_800_Fleet_Vehicle_Page fleet_vehicle_page=new NVF_800_Fleet_Vehicle_Page();
        Actions actions;



        //User can see all vehicle information in a table
    @Given("user is on the vehicles page placed under the Fleet Dropdown")
    public void user_is_on_the_vehicles_page_placed_under_the_fleet_dropdown() {
        actions=new Actions(Driver.getDriver());
            actions.moveToElement(fleet_vehicle_page.FleetLinkDropdown).perform();
            fleet_vehicle_page.VehiclesOption.click();

    }
    @When("user click any row at anywhere on the row")
    public void user_click_any_row_at_anywhere_on_the_row() {


    }
    @When("user see all vehicle {string} under the General Information header")
    public void user_see_all_vehicle_under_the_general_information_header(List<Map<String,Object>>expectedlistOfKeyAndValueOfVehicleInfo) {

        List<Map<String,Object>>vehiclesInfoKeyValueList=new ArrayList<>();
        Map<String,Object>vehiclesInfoForKeyAndValue=new LinkedHashMap<>();

        for (int i = 0; i <expectedlistOfKeyAndValueOfVehicleInfo.size() ; i++) {
            vehiclesInfoForKeyAndValue.put(fleet_vehicle_page.controlKeyLabels.get(i).getText(),
            fleet_vehicle_page.controlKeyLabels.get(i).getText());

            vehiclesInfoKeyValueList.add(vehiclesInfoForKeyAndValue);
        }



    }
    @When("user navigates back to the vehicles page")
    public void user_navigates_back_to_the_vehicles_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user should be able to see exact informations on the table")
    public void user_should_be_able_to_see_exact_informations_on_the_table() {

    }


    //  AC :2 ---->User can see the total page number


    @Then("user can see total page number and total recording of vehicles")
    public void userCanSeeTotalPageNumberAndTotalRecordingOfVehicles() {

       Assert.assertTrue(fleet_vehicle_page.totalPgeNumber.isDisplayed());
       Assert.assertTrue(fleet_vehicle_page.totalVehicleRecords.isDisplayed());

    }


    //AC 3----->User can go to next page clicking ">" button

    @When("user enters next page button")
    public void userEntersNextPageButton() {
        fleet_vehicle_page.nextButton.click();
    }


    @Then("user can go to the nextTablePage")
    public void userCanGoToTheNextTablePage() {
        
    }


    //AC3_2 ---> user can go to previous page clicking "<" button

    @When("user enters previous page button")
    public void userEntersPreviousPageButton() {
    }

    @Then("user can go to the previousTablePage")
    public void userCanGoToThePreviousTablePage() {
    }



}
