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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class NVF_805_Location_Filter {


    VehiclePage vehiclePage = new VehiclePage();
    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();

    Select select;
    String keyword;

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

        vehiclePage.manageFilterDropdownLink.click();
        BrowserUtils.sleep(2);
        vehiclePage.locationOption.click();
    }


    //2-) user should be able to see the filter methods that are located under the methods dropdown
    @Then("user should be able to see Location dropdown")
    public void user_should_be_able_to_see_location_dropdown() {
        Assert.assertTrue( vehiclePage.locationAllDropdown.isDisplayed());

    }

    @When("user clicks location Dropdown and clicks the filter methods toggle under")
    public void userClicksLocationDropdownAndClicksTheFilterMethodsToggleUnder() {
        vehiclePage.locationAllDropdown.click();
        BrowserUtils.sleep(2);
        vehiclePage.dropdownFilterButtonUnderLocation.click();
    }

    @Then("user should be able to see methods")
    public void userShouldBeAbleToSee(List<String>methodNames) {

        for (int i = 0; i < methodNames.size() ; i++) {

            Assert.assertTrue(vehiclePage.filterMethods.get(i).getText().equalsIgnoreCase(methodNames.get(i)));
        }

    }

    //us-3) user should see the specified keyword inn the result when he selects the contains method


    @When("user select Contains method with a {string}")
    public void userSelectContainsMethodWithA(String keyword) {
        this.keyword=keyword;
        vehiclePage.locationAllDropdown.click();
        vehiclePage.filterTextField.sendKeys(keyword);
        vehiclePage.updateButtonToFilter.click();
        BrowserUtils.sleep(2);
    }



    @Then("the results should contain the specified keyword")
    public void theResultsShouldContainTheSpecified() {
        if(vehiclePage.listOfDataUnderTheLocationColumn.size()==0){
            System.out.println("No entities were found to match your search. Try modifying your search criteria...");

        }else{
            for (WebElement eachLocationRelatedCellUnderTheLocationColumn : vehiclePage.listOfDataUnderTheLocationColumn) {
                String eachLocation=eachLocationRelatedCellUnderTheLocationColumn.getAttribute("innerText").toLowerCase();
                System.out.println("eachLocation = " + eachLocation);
                Assert.assertTrue(eachLocation.contains(keyword));
                System.out.println("selam");
            }


        }

    }


    //us-4) user should see the result that does not contain specified keyword

    @When("user selects {string} method with a {string}")
    public void userSelectsMethodWithA(String methodName, String keyword) {

        this.keyword=keyword;
        vehiclePage.locationAllDropdown.click();
        vehiclePage.dropdownFilterButtonUnderLocation.click();
        vehiclePage.getFilterMethod(methodName);//it gets the specific method that we parameterized inside the feature file
        vehiclePage.filterTextField.sendKeys(keyword);
        vehiclePage.updateButtonToFilter.click();
        BrowserUtils.sleep(2);
    }


    @Then("results should not contain the specified keyword")
    public void resultsShouldNotContainTheSpecifiedKeyword() {
        for (WebElement eachLocationRelatedCellUnderTheLocationColumn : vehiclePage.listOfDataUnderTheLocationColumn) {
            String eachLocation=eachLocationRelatedCellUnderTheLocationColumn.getAttribute("innerText").toLowerCase();
            System.out.println("eachLocation = " + eachLocation);
            Assert.assertFalse(eachLocation.contains(keyword));
            System.out.println("selam");
        }



    }
        //us-5) user should see the result that starts with the specified keyword
    @Then("results should start with the specified keyword")
    public void resultsShouldStartWithTheSpecifiedKeyword() {
        if(vehiclePage.listOfDataUnderTheLocationColumn.size()==0){
            System.out.println("No entities were found to match your search. Try modifying your search criteria...");

        }else{
            for (WebElement eachLocationRelatedCellUnderTheLocationColumn : vehiclePage.listOfDataUnderTheLocationColumn) {
                String eachLocation=eachLocationRelatedCellUnderTheLocationColumn.getAttribute("innerText").toLowerCase();
                System.out.println("eachLocation = " + eachLocation);
                Assert.assertTrue(eachLocation.startsWith(keyword));
                System.out.println("selam");
            }


        }

    }

    //user should see the result that ends with the specified keyword

    @Then("results should end with the specified keyword")
    public void resultsShouldEndWithTheSpecifiedKeyword() {
        if(vehiclePage.listOfDataUnderTheLocationColumn.size()==0){
            System.out.println("No entities were found to match your search. Try modifying your search criteria...");

        }else{
            for (WebElement eachLocationRelatedCellUnderTheLocationColumn : vehiclePage.listOfDataUnderTheLocationColumn) {
                String eachLocation=eachLocationRelatedCellUnderTheLocationColumn.getAttribute("outerText").toLowerCase();
                System.out.println("eachLocation = " + eachLocation);
                Assert.assertTrue(eachLocation.endsWith(keyword));
                System.out.println("selam");
            }


        }
    }
}