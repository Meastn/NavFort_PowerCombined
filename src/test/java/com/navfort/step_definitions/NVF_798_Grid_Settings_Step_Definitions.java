package com.navfort.step_definitions;

import com.navfort.pages.BasePage;
import com.navfort.pages.LoginPage;
import com.navfort.pages.VehiclePage;
import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.ConfigurationReader;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class NVF_798_Grid_Settings_Step_Definitions {

    LoginPage loginPage=new LoginPage();
    BasePage basePage=new BasePage();
    VehiclePage vehiclePage=new VehiclePage();


    @Given("user logged in and pass on the Vehicle page")
    public void userLoggedInAndPassOnTheVehiclePage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginAsSalesManager();

        BrowserUtils.sleep(20);
        basePage.fleetButton.click();
        basePage.vehiclesButton.click();

    }

    @When("user clicks on the gear icon")
    public void userClicksOnTheGearIcon() {
        vehiclePage.gearIcon.click();
    }

    @Then("user should see Grid Settings")
    public void userShouldSeeGridSettings() {
        Assert.assertEquals(vehiclePage.gridSettingsText.getText(),"Grid Settings");
    }

    @Then("Column names should be shown as")
    public void columnNamesShouldBeShownAs(List<String> expectedColumnNames) {

        List<String> actualColumnNames = new ArrayList<>();
        for (WebElement columnName : vehiclePage.columnNames) {
            actualColumnNames.add(columnName.getText());

        }
        for (int i = 0; i <= actualColumnNames.size() ; i++) {
            Assert.assertEquals(expectedColumnNames.get(i), actualColumnNames.get(i));

        }

    }




    @Then("user type ColumnName to quick search box user can find searched column")
    public void userTypeColumnNameToQuickSearchBoxUserCanFindSearchedColumn(List<String> typedColumnNames) {
        for (int i = 0; i <= typedColumnNames.size() ; i++) {
            vehiclePage.inputQuickSeach.sendKeys(typedColumnNames.get(i));
            Assert.assertTrue((!vehiclePage.noColumnsFoundText.isDisplayed()));

        }


    }
}
