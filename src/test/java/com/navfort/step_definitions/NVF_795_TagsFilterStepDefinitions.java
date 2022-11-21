package com.navfort.step_definitions;

import com.navfort.pages.*;
import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.ConfigurationReader;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class NVF_795_TagsFilterStepDefinitions {

    LoginPage loginPage = new LoginPage();
    VehiclePage vehiclePage = new VehiclePage();
    BasePage basePage = new BasePage();
    GeneralInformationPage generalInformationPage= new GeneralInformationPage();
    Actions actions=new Actions(Driver.getDriver());

    @Given("user on the fleet vehicle page")
    public void user_on_the_fleet_vehicle_page() {

        BrowserUtils.sleep(10);
        Driver.getDriver().get("https://qa.navfort.com/");
        vehiclePage.usernameInput.sendKeys("salesmanager101");
        vehiclePage.passwordInput.sendKeys("UserUser123");
        vehiclePage.loginBtn.click();
        BrowserUtils.sleep(5);
        actions.moveToElement(vehiclePage.fleetBtn).perform();
        vehiclePage.vehiclesBtn.click();

    }
    @When("user clicks the manage filters and select tags")
    public void user_clicks_the_manage_filters_and_select_tags() {

        BrowserUtils.sleep(20);
        vehiclePage.filtersBtn.click();
        BrowserUtils.sleep(5);
        vehiclePage.manageFilters.click();
        BrowserUtils.sleep(5);
        vehiclePage.tagsBtn.click();

    }
    @Then("user sees is Any Of and is Not Any Of options")
    public void user_sees_is_any_of_and_is_not_any_of_options() {

        BrowserUtils.sleep(10);
        vehiclePage.tagsAll.click();
        BrowserUtils.sleep(1);
        vehiclePage.isAnyOf.click();
        vehiclePage.selectIsAnyOf.isDisplayed();

    }

    @When("user selects is Any Of with Compact option")
    public void user_selects_is_any_of_with_compact_option() {

        BrowserUtils.sleep(10);
        vehiclePage.tagsAll.click();
        BrowserUtils.sleep(5);
        vehiclePage.isAnyOf.click();
        BrowserUtils.sleep(3);
        vehiclePage.selectIsAnyOf.click();
        BrowserUtils.sleep(2);
        vehiclePage.inputIsAnyOf.click();
        BrowserUtils.sleep(2);
        vehiclePage.compact.click();
        BrowserUtils.sleep(2);
        vehiclePage.update.click();

    }
    @Then("user sees the list of Compact results")
    public void user_sees_the_list_of_compact_results() {
        BrowserUtils.sleep(5);
        String expectedText = "Compact";
        String actualText = vehiclePage.compactCell.getText();
        BrowserUtils.sleep(5);
        Assert.assertEquals(expectedText, actualText);

    }

    @When("user selects is Not Any Of with Compact option")
    public void user_selects_is_not_any_of_with_compact_option() {
        BrowserUtils.sleep(10);
        vehiclePage.tagsAll.click();
        BrowserUtils.sleep(1);
        vehiclePage.isAnyOf.click();
        BrowserUtils.sleep(2);
        vehiclePage.selectIsNotAnyOf.click();
        BrowserUtils.sleep(2);
        vehiclePage.inputIsAnyOf.click();
        BrowserUtils.sleep(2);
        vehiclePage.compact.click();
        BrowserUtils.sleep(2);
        vehiclePage.update.click();


    }
    @Then("user sees the list of results except Compact")
    public void user_sees_the_list_of_results_except_compact() {

        BrowserUtils.sleep(5);
        String notExpectedText = "Compact";
        String actualText = vehiclePage.compactCell.getText();
        BrowserUtils.sleep(5);
        Assert.assertNotEquals(notExpectedText, actualText);

    }

    @When("user selects is Not Any Of with Compact and Sedan option")
    public void user_selects_is_not_any_of_with_compact_and_sedan_option() {
        BrowserUtils.sleep(10);
        vehiclePage.tagsAll.click();
        BrowserUtils.sleep(2);
        vehiclePage.isAnyOf.click();
        BrowserUtils.sleep(2);
        vehiclePage.selectIsNotAnyOf.click();
        BrowserUtils.sleep(5);
        vehiclePage.inputIsAnyOf.click();
        BrowserUtils.sleep(3);
        vehiclePage.compact.click();
        BrowserUtils.sleep(2);
        vehiclePage.sedan.click();
        BrowserUtils.sleep(2);
        vehiclePage.update.click();


    }
    @Then("user sees the list of results except Compact and Sedan")
    public void user_sees_the_list_of_results_except_compact_and_sedan() {
        BrowserUtils.sleep(5);
        String notExpectedText1 = "Compact";
        String actualText1 = vehiclePage.compactCell.getText();
        BrowserUtils.sleep(5);
        Assert.assertNotEquals(notExpectedText1, actualText1);

        BrowserUtils.sleep(5);

        String notExpectedText2 = "Sedan";
        String actualText2 = vehiclePage.compactCell.getText();
        BrowserUtils.sleep(5);
         Assert.assertNotEquals(notExpectedText2, actualText2);


    }
}