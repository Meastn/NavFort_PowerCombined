package com.navfort.step_definitions;

import com.navfort.pages.BasePage;
import com.navfort.pages.GeneralInformationPage;
import com.navfort.pages.LoginPage;
import com.navfort.pages.VehiclePage;
import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.ConfigurationReader;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
        basePage.vehiclesButton.click();

    }
    @When("user clicks the manage filters and select tags")
    public void user_clicks_the_manage_filters_and_select_tags() {

         vehiclePage.manageFilters.click();
         vehiclePage.tagsBtn.click();


    }
    @Then("user sees Is Any Of and Is Not Any Of options")
    public void user_sees_ıs_any_of_and_ıs_not_any_of_options() {

        vehiclePage.tagsAll.click();
        vehiclePage.isAnyOf.click();
        vehiclePage.selectIsAnyOf.isDisplayed();
        vehiclePage.selectIsNotAnyOf.isDisplayed();


    }

    @When("user selects Is Any Of with Compact option")
    public void user_selects_ıs_any_of_with_compact_option() {


        vehiclePage.selectIsAnyOf.click();
        vehiclePage.inputIsAnyOf.click();
        vehiclePage.compact.click();


    }
    @Then("user sees the list of Compact results")
    public void user_sees_the_list_of_compact_results() {

        // compact list of one location

    }

    @When("user selects Is Not Any Of with Compact option")
    public void user_selects_ıs_not_any_of_with_compact_option() {
        vehiclePage.selectIsNotAnyOf.click();
        vehiclePage.inputIsAnyOf.click();
        vehiclePage.compact.click();

    }
    @Then("user sees the list of results except Compact")
    public void user_sees_the_list_of_results_except_compact() {


    }
      @When("user selects Is Not Any Of with Compact and Sedan option")
    public void user_selects_ıs_not_any_of_with_compact_and_sedan_option() {


          vehiclePage.selectIsNotAnyOf.click();
          vehiclePage.inputIsAnyOf.click();
          vehiclePage.compact.click();
          vehiclePage.sedan.click();

    }
    @Then("user sees the list of results except Compact and Sedan")
    public void user_sees_the_list_of_results_except_compact_and_sedan() {




    }


}
