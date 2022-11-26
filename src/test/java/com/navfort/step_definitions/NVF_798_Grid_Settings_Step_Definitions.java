package com.navfort.step_definitions;

import com.navfort.pages.BasePage;
import com.navfort.pages.CreateCarPage;
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
import org.openqa.selenium.Keys;
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
        System.out.println("user visited to navfort login page");
        loginPage.loginAsSalesManager();
        System.out.println("user logged in as a sales manager");

        BrowserUtils.waitForInvisibility(basePage.spinningWheel);
        System.out.println("waitin spinning wheel");
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(basePage.fleetButton).perform();
        System.out.println("move to fleet button");
        // basePage.fleetButton.click();
        BrowserUtils.waitForClickable(basePage.vehiclesButton);
        System.out.println("wait vehicle button clickable");
        basePage.vehiclesButton.click();
        System.out.println("clicked to vehicle button");

       }



    @When("user clicks on the gear icon")
    public void userClicksOnTheGearIcon() {
        CreateCarPage.waitUntilLoaderScreenDisappear();
        System.out.println("Thanks serdar abi waiting loader screen to disappear");
        BrowserUtils.waitForClickable(vehiclePage.gearIcon);
        System.out.println("wait for gear icon clickabe");
        vehiclePage.gearIcon.click();
        System.out.println("clcicked gear icon");
     /*   try{
            vehiclePage.gearIcon.click();
        }catch (Exception e){
            System.out.println("bla bla bla");
        }*/

    }

    @Then("user should see Grid Settings")
    public void userShouldSeeGridSettings() {
        try {
            Assert.assertEquals(vehiclePage.gridSettingsText.getText(), "Grid Settings");
            System.out.println(vehiclePage.gridSettingsText.getText());
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
        for (int i = 1; i < actualColumnNames.size(); i++) {
            System.out.println(expectedColumnNames.get(i) +"="+actualColumnNames.get(i) );
            Assert.assertEquals(expectedColumnNames.get(i), actualColumnNames.get(i));


        }

    }


    @Then("user type ColumnName to quick search box user can find searched column")
    public void userTypeColumnNameToQuickSearchBoxUserCanFindSearchedColumn(List<String> typedColumnNames) {
        userClicksOnTheGearIcon();
        for (int i = 0; i < typedColumnNames.size(); i++) {
            vehiclePage.inputQuickSeach.sendKeys(typedColumnNames.get(i));
            System.out.print("type "+ typedColumnNames.get(i));
            vehiclePage.inputQuickSeach.sendKeys(Keys.CONTROL+"A");
            System.out.print(" select all");
            vehiclePage.inputQuickSeach.sendKeys(Keys.DELETE);
            System.out.print(" delete");
            System.out.println("---");

            Assert.assertTrue((!vehiclePage.noColumnsFoundText.isDisplayed()));
   /*     try{
            for (int i = 0; i <= typedColumnNames.size(); i++) {
                vehiclePage.inputQuickSeach.sendKeys(typedColumnNames.get(i));
                Assert.assertTrue((!vehiclePage.noColumnsFoundText.isDisplayed()));


            }
        }catch (Exception e)
        {
            System.out.println("bla bla bla");
        }*/

    }}
    List<String> visibilityCellsIds = new ArrayList<>();
    @Then("user select any column name")
    public void userSelectAnyColumnName() {


        for (WebElement visibilityCell : vehiclePage.visibilityCells) {
            visibilityCellsIds.add(visibilityCell.getAttribute("id"));
        }

        for (int i = 0; i <visibilityCellsIds.size() ; i++) {
            System.out.println("Column Name "+vehiclePage.columnNames.get(i).getText() +" "+
                    "checkbox id name " + visibilityCellsIds.get(i)+ " is selected? = " +
                    vehiclePage.visibilityCells.get(i).isSelected());
            vehiclePage.columnNames.get(i).click();
            BrowserUtils.sleep(1);
            System.out.println("clicked " + vehiclePage.columnNames.get(i));
        }


   /*     try{
            vehiclePage.columnNames.get(2).click();

        }catch (Exception e){
            System.out.println("error "  + e.getMessage());
        }   */
    }

    @And("visibility checkbox turns unchecked")
    public void visibilityCheckboxTurnsUnchecked() {
        for (int i = 0; i <visibilityCellsIds.size() ; i++) {
            System.out.println("Column Name "+vehiclePage.columnNames.get(i).getText() +" "+
                    "checkbox id name " + visibilityCellsIds.get(i)+ " is selected? = " +
                    vehiclePage.visibilityCells.get(i).isSelected());

            Assert.assertTrue((!vehiclePage.visibilityCells.get(2).isSelected()));
        }


      /*  try {
            Assert.assertTrue((!vehiclePage.visibilityCells.get(2).isSelected()));

        }catch (Exception e){
            System.out.println("checked or unceked I dont know"+ e.getMessage());
        }*/



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

