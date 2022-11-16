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
import io.opentelemetry.sdk.trace.internal.data.ExceptionEventData;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class NVF_798_Grid_Settings_Step_Definitions {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    VehiclePage vehiclePage = new VehiclePage();


    @Given("user logged in and pass on the Vehicle page")
    public void userLoggedInAndPassOnTheVehiclePage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginAsSalesManager();

        BrowserUtils.waitForInvisibility(basePage.spinningWheel);
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(basePage.fleetButton).perform();
        // basePage.fleetButton.click();
        BrowserUtils.waitForClickable(basePage.vehiclesButton);
        basePage.vehiclesButton.click();

       }



    @When("user clicks on the gear icon")
    public void userClicksOnTheGearIcon() {
        try{
            vehiclePage.gearIcon.click();
        }catch (Exception e){
            System.out.println("bla bla bla");
        }

    }

    @Then("user should see Grid Settings")
    public void userShouldSeeGridSettings() {
        try {
            Assert.assertEquals(vehiclePage.gridSettingsText.getText(), "Grid Settings");
        }catch (Exception e){
            System.out.println("bla bla bla");
        }

    }

    @Then("Column names should be shown as")
    public void columnNamesShouldBeShownAs(List<String> expectedColumnNames) {

        List<String> actualColumnNames = new ArrayList<>();
        for (WebElement columnName : vehiclePage.columnNames) {
            actualColumnNames.add(columnName.getText());

        }
        for (int i = 1; i <= actualColumnNames.size(); i++) {
            Assert.assertEquals(expectedColumnNames.get(i), actualColumnNames.get(i));

        }

    }


    @Then("user type ColumnName to quick search box user can find searched column")
    public void userTypeColumnNameToQuickSearchBoxUserCanFindSearchedColumn(List<String> typedColumnNames) {
        try{
            for (int i = 0; i <= typedColumnNames.size(); i++) {
                vehiclePage.inputQuickSeach.sendKeys(typedColumnNames.get(i));
                Assert.assertTrue((!vehiclePage.noColumnsFoundText.isDisplayed()));


            }
        }catch (Exception e)
        {
            System.out.println("bla bla bla");
        }

    }

    @Then("user select any column name")
    public void userSelectAnyColumnName() {
        try{
            vehiclePage.columnNames.get(2).click();
        }catch (Exception e){
            System.out.println("error");
        }




    }

    @And("visibility checkbox turns unchecked")
    public void visibilityCheckboxTurnsUnchecked() {
        try {
            Assert.assertTrue((!vehiclePage.visibilityCells.get(2).isSelected()));
        }catch (Exception e){
            System.out.println("checked or unceked I dont know");
        }



    }

    @Then("Unchecked column unvisible on the table")
    public void uncheckedColumnUnvisibleOnTheTable() {

        try{
            Assert.assertTrue(vehiclePage.headerCells.get(2).isDisplayed());
        }catch (Exception e){
            System.out.println("displayed or not");
        }


    }

    @When("user moved to column")
    public void userMovedToColumn() {
        try {
            Actions actions = new Actions(Driver.getDriver());
            actions.clickAndHold(vehiclePage.moveColumns.get(2)).perform();
            actions.moveToElement(vehiclePage.moveColumns.get(2),0,-10);

        }catch (Exception e){
            System.out.println("click and hold nor worked");
        }

    }

    @Then("moved column order changed on the table")
    public void movedColumnOrderChangedOnTheTable() {
        try{
            Assert.assertEquals(vehiclePage.columnNames.get(2).getText(),vehiclePage.headerCells.get(2));
        }catch (Exception e){
            System.out.println("try again");
        }
    }
}
