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


    @Given("user on the fleet home page")
    public void user_on_the_fleet_home_page() {
        Driver.getDriver().get("https://qa.navfort.com/");
        loginPage.loginAsSalesManager();
        BrowserUtils.sleep(5);
        basePage.fleetButton.click();
        BrowserUtils.sleep(2);
        basePage.vehiclesButton.click();

    }
    @When("user clicks the manage filters and select tags")
    public void user_clicks_the_manage_filters_and_select_tags() {
        vehiclePage.filtersBtn.click();
        BrowserUtils.sleep(2);
      //  filter_genaralPage.manage_filter.click();
        BrowserUtils.sleep(2);
        vehiclePage.manageFilters.click();
        BrowserUtils.sleep(2);
         vehiclePage.tagsBtn.click();


    }
    @Then("user sees Is Any Of and Is Not Any Of options")
    public void user_sees_ıs_any_of_and_ıs_not_any_of_options() {

        vehiclePage.tagsAll.click();
        BrowserUtils.sleep(2);
        vehiclePage.isAnyOf.click();

        vehiclePage.selectIsAnyOf.isDisplayed();
        BrowserUtils.sleep(2);
        vehiclePage.selectIsNotAnyOf.isDisplayed();


    }

    @When("user selects Is Any Of with Compact option")
    public void user_selects_ıs_any_of_with_compact_option() {

        vehiclePage.selectIsAnyOf.click();
        vehiclePage.inputIsAnyOf.click();
        BrowserUtils.sleep(2);
        vehiclePage.compact.click();
        BrowserUtils.sleep(2);
        vehiclePage.update.click();


    }
    @Then("user sees the list of Compact results")
    public void user_sees_the_list_of_compact_results() {

        String expectedText = "Compact";
        String actualText = vehiclePage.compactCell.getText();
        Assert.assertEquals(expectedText, actualText);

    }

    @When("user selects Is Not Any Of with Compact option")
    public void user_selects_ıs_not_any_of_with_compact_option() {

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

        String notExpectedText = "Compact";
        String actualText = vehiclePage.compactCell.getText();
        Assert.assertNotEquals(notExpectedText, actualText);



    }
      @When("user selects Is Not Any Of with Compact and Sedan option")
    public void user_selects_ıs_not_any_of_with_compact_and_sedan_option() {


          vehiclePage.selectIsNotAnyOf.click();
          BrowserUtils.sleep(2);
          vehiclePage.inputIsAnyOf.click();
          BrowserUtils.sleep(2);
          vehiclePage.compact.click();
          vehiclePage.sedan.click();
          BrowserUtils.sleep(2);
          vehiclePage.update.click();


      }
    @Then("user sees the list of results except Compact and Sedan")
    public void user_sees_the_list_of_results_except_compact_and_sedan() {

        String notExpectedText1 = "Compact";
        String actualText1 = vehiclePage.compactCell.getText();
        Assert.assertNotEquals(notExpectedText1, actualText1);

        BrowserUtils.sleep(5);

        String notExpectedText2 = "Sedan";
        String actualText2 = vehiclePage.compactCell.getText();
        Assert.assertNotEquals(notExpectedText2, actualText2);


    }


}
