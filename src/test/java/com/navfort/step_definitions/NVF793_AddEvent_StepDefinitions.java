package com.navfort.step_definitions;

import com.navfort.pages.*;
import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.ConfigurationReader;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class NVF793_AddEvent_StepDefinitions {

    LoginPage loginPage = new LoginPage();

    VehiclePage vehiclePage = new VehiclePage();

    BasePage basePage = new BasePage();

    GeneralInformationPage generalInformationPage = new GeneralInformationPage();

    AddEventPage addEventPage = new AddEventPage();




    @Given("user is on the general information page")
    public void user_is_on_the_general_information_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginAsSalesManager();
        BrowserUtils.sleep(20);
        basePage.fleetButton.click();
        BrowserUtils.sleep(20);
        basePage.vehiclesButton.click();

        BrowserUtils.sleep(20);
        vehiclePage.secondRowOfCarList.click();


        BrowserUtils.sleep(20);
        String actualTitle = generalInformationPage.generalInformationPageTitle.getText();
        String expectedTitle = "General Information";
        Assert.assertEquals(expectedTitle, actualTitle);


    }

    @When("user can click on the Add Event button")
    public void user_can_click_on_the_add_event_button() {
        BrowserUtils.sleep(10);
        vehiclePage.addEventButton.click();

    }
    @Then("user lands on the Add Event pop up page")
    public void user_lands_on_the_add_event_pop_up_page() {

        BrowserUtils.sleep(5);

        String actualPageTitle = addEventPage.addEventPagePopupTitle.getText();

       // Alert alert = Driver.getDriver().switchTo().alert();
       // String actualPageTitle = alert.getText();
       // String actualPageTitle = addEventPage.addEventPagePopup.getText();

        System.out.println("actualPageTitle = " + actualPageTitle);

        String expectedPageTitle = "Add Event";

        Assert.assertEquals(expectedPageTitle, actualPageTitle);
    }

    @When("driver lands on general information page")
    public void driver_lands_on_general_information_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginAsDriver();
        BrowserUtils.sleep(20);
        basePage.fleetButtonForDriver.click();
        BrowserUtils.sleep(20);
        basePage.vehicleButtonForDriver.click();

        BrowserUtils.sleep(20);
        vehiclePage.secondRowOfCarList.click();

    }
    @Then("driver should not see the Add Event Button")
    public void driver_should_not_see_the_add_event_button() {

        boolean addEventButtonIsDisplayed = addEventPage.addEventButton.isDisplayed();

        if(addEventButtonIsDisplayed == true){
            System.out.println("AddEvent Button should not be displayed");

            Assert.assertTrue(!addEventButtonIsDisplayed);
        }

    }

    @When("user can click the Add Event button")
    public void user_can_click_the_add_event_button() {

        generalInformationPage.addEventButton.click();





    }



    @Then("user should land on the Add Event page")
    public void user_should_land_on_the_add_event_page() {
        BrowserUtils.sleep(10);

        String actualPageTitle = addEventPage.addEventPagePopupTitle.getText();
        String expectedPageTitle = "Add Event";

        System.out.println(actualPageTitle);

        if(actualPageTitle.equals(expectedPageTitle)){
            System.out.println("Add Event button is clickable");
        }

    }

}
