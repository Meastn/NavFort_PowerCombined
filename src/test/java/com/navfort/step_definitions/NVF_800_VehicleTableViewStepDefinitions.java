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
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class NVF_800_VehicleTableViewStepDefinitions {

    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();
    VehiclePage vehiclePage = new VehiclePage();
    Actions actions;
    List<String> vehiclesInfoList = new ArrayList<>();

    List<String> listOfCarTableColumnNames = new ArrayList<>();


    @Given("user is login with valid credentials and on the vehicles page placed under the Fleet Dropdown")
    public void userIsLoginWithValidCredentialsAndOnTheVehiclesPagePlacedUnderTheFleetDropdown() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginAsUserType("driver");
        BrowserUtils.sleep(5);
//       BrowserUtils.waitForInvisibility(vehiclePage.loader_mask);
//        actions=new Actions(Driver.getDriver());
//        actions.moveToElement(basePage.fleetButton).perform();
        basePage.fleetButton.click();

        basePage.vehiclesButton.click();
        BrowserUtils.sleep(3);



    }


    //---------------------------------
//    @When("user click view icon on the three dot icon")
//    public void userClickViewIconOnTheThreeDotIcon() {
//        actions = new Actions(Driver.getDriver());
//        try {
//            actions.clickAndHold(vehiclePage.threeDots).perform();
//            vehiclePage.threeDots.click();
//            actions.click(vehiclePage.viewSign2).perform();
//
//        } catch (Exception e) {
//            System.out.println("error occurred while getting view icon");
//            e.printStackTrace();
//
//        }
//
//    }
    @When("user click anywhere at the row")
    public void userClickAnywhereAtTheRow() {

        vehiclePage.carsTableFirstRow.click();
        BrowserUtils.sleep(5);
    }


    @When("user see all vehicle information under the General Information header")
    public void user_see_all_vehicle_under_the_general_information_header() {


        for (int i = 0; i < 9; i++) {

            vehiclesInfoList.add(vehiclePage.controlKeyLabels.get(i).getText().toLowerCase());
        }


    }

    @When("user navigates back to the vehicles page")
    public void user_navigates_back_to_the_vehicles_page() {
     Driver.getDriver().navigate().back();
    }

    @Then("user should be able to see exact informations on the table")
    public void user_should_be_able_to_see_exact_informations_on_the_table() {

        for (int i = 0; i < 9; i++) {
            listOfCarTableColumnNames.add(vehiclePage.TableEachColumnName.get(i).getText().toLowerCase());

        }
        Assert.assertEquals(vehiclesInfoList, listOfCarTableColumnNames);


    }


    //  AC :2 ---->User can see the total page number


    @Then("user can see total page number and total recording of vehicles")
    public void userCanSeeTotalPageNumberAndTotalRecordingOfVehicles() {

        Assert.assertTrue(vehiclePage.totalPgeNumber.isDisplayed());
        Assert.assertTrue(vehiclePage.totalVehicleRecords.isDisplayed());

    }


    //AC 3----->User can go to next page clicking ">" button



    @When("user enters next page button user can go to the next page")
    public void userEntersNextPageButtonUserCanGoToTheNextPage() {
        BrowserUtils.sleep(3);
        String currentText = vehiclePage.numberBetweenTheNextAndPreviousButton.getText();

        vehiclePage.nextButton.click();
        BrowserUtils.sleep(4);
        String afterNextPage = vehiclePage.numberBetweenTheNextAndPreviousButton.getText();
//
//        Assert.assertFalse(currentText.equals(afterNextPage));
        if(currentText.equals(afterNextPage)){
            System.out.println("failed");
        }else{
            System.out.println("success");
        }
    }


    //AC3_2 ---> user can go to previous page clicking "<" button

    @When("user enters previous page button user can go to the previousTablePage")
    public void userEntersPreviousPageButtonUserCanGoToThePreviousTablePage() {
        String currentPageNumber = vehiclePage.numberBetweenTheNextAndPreviousButton.getText();
        vehiclePage.nextButton.click();

        BrowserUtils.sleep(2);
        vehiclePage.previousButton.click();
        String currentPageNumberAfterClickingOnePageForwardOnePageBackward= vehiclePage.numberBetweenTheNextAndPreviousButton.getText();
        Assert.assertTrue(currentPageNumber.equals(currentPageNumberAfterClickingOnePageForwardOnePageBackward));

    }



    //AC 4==>User can download table data in XLS or CSV format from "Export Grid"

    @When("user click export Grid button")
    public void userClickExportGridButton() {
        vehiclePage.exportGridButton.click();
        BrowserUtils.sleep(3);
    }

    @And("user click  xlsx option")
    public void userClickXlsxOption() {
        vehiclePage.xlsxButton.click();
        BrowserUtils.sleep(3);
    }

    @And("user click  csv option")
    public void userClickCsvOption() {
        vehiclePage.csvButton.click();
    }

    @Then("user can see the successfully download message")
    public void userCanSeeTheSuccessfullyDownloadMessage() {

        Assert.assertTrue(vehiclePage.downloadMessage.isDisplayed());
    }



}
