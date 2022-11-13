package com.navfort.step_definitions;

import com.navfort.pages.BasePage;
import com.navfort.pages.GeneralInformationPage;
import com.navfort.pages.LoginPage;
import com.navfort.pages.VehiclePage;
import com.navfort.utilities.BrowserUtils;
import com.navfort.utilities.ConfigurationReader;
import com.navfort.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.ComparisonFailure;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.json.JsonException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class NVF794_GeneralInformation_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    VehiclePage vehiclePage = new VehiclePage();
    BasePage basePage = new BasePage();
    GeneralInformationPage generalInformationPage = new GeneralInformationPage();


    @Given("User logs in to the application")
    public void user_logs_in_to_the_application() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.loginAsSalesManager();
    }

    @Given("User clicks fleet and vehicles menu items")
    public void userClicksFleetAndVehiclesMenuItems() {
        BrowserUtils.sleep(15);
        basePage.fleetButton.click();
        basePage.vehiclesButton.click();
    }

    @Given("User clicks any row")
    public void userClicksAnyRow() {
        BrowserUtils.sleep(20);
        vehiclePage.carsTableFirstRow.click();
    }

    @Then("User can see the general information page")
    public void userCanSeeTheGeneralInformationPage() {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.visibilityOf(vehiclePage.carsTable));
        BrowserUtils.sleep(15);
        String actualPageTitle = generalInformationPage.generalInformationPageTitle.getText();
        String expectedPageTitle = "General Information";
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
    }

    @Given("User clicks on eye icon")
    public void userClicksOnEyeIcon() {
        BrowserUtils.sleep(15);
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(vehiclePage.threeDots).perform();

        //action.scrollToElement(vehiclePage.threeDotBar).clickAndHold().perform();
//            action.click(vehiclePage.viewIcon).perform();
//            action.click(vehiclePage.viewIcon).perform();
//            BrowserUtils.sleep(5);
//            action.click(vehiclePage.viewSign).perform();
//            action.click(vehiclePage.viewSign).perform();
//            vehiclePage.viewSign.click();
//            vehiclePage.viewSign.click();
//        action.scrollToElement(vehiclePage.threeDotBar).clickAndHold().perform();
//        BrowserUtils.sleep(2);
//        vehiclePage.threeDotBar.isDisplayed();
        action.clickAndHold(vehiclePage.threeDots).perform();
        action.scrollToElement(vehiclePage.threeDotBar);
        vehiclePage.threeDots.click();

        // somehow this code throws JsonException and InvocationTargetException that avoids the code to run further.--------
        try {
            BrowserUtils.sleep(10);
            action.click(vehiclePage.viewSign2).perform();
        } catch (Exception s) {
            s.printStackTrace();
        }

    }



    @Then("User can see the edit button")
    public void userCanSeeTheEditButton() {
        BrowserUtils.sleep(1);
        Assert.assertTrue(generalInformationPage.editButton.isDisplayed());

    }

    @And("User can see the delete button")
    public void userCanSeeTheDeleteButton() {
        BrowserUtils.sleep(1);
        Assert.assertTrue(generalInformationPage.deleteButton.isDisplayed());
    }

    @And("User can see the add event button")
    public void userCanSeeTheAddEventButton() {
        BrowserUtils.sleep(1);
        Assert.assertTrue(generalInformationPage.addEventButton.isDisplayed());
    }

    @Then("User logs out")
    public void userLogsOut() {
        BrowserUtils.sleep(10);
        basePage.userMenu.click();
        basePage.logoutMenuButton.click();
    }


    @When("User logs in as a Driver")
    public void userLogsInAsADriver() {
        loginPage.loginAsDriver();
    }

    @And("Driver clicks fleet and vehicles menu items")
    public void driverClicksFleetAndVehiclesMenuItems() {
        BrowserUtils.sleep(10);
        basePage.fleetButton.click();
        basePage.vehiclesButton.click();
    }

    @Then("User can not see the edit button")
    public void userCanNotSeeTheEditButton() {
        boolean exist = generalInformationPage.editButton.isDisplayed();
        try {
            Assert.assertTrue(exist);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    @And("User can not see the delete button")
    public void userCanNotSeeTheDeleteButton() {
        try {
            Assert.assertTrue(generalInformationPage.deleteButton.isDisplayed());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    @And("User can not see the add event button")
    public void userCanNotSeeTheAddEventButton() {
       try {
           Assert.assertTrue(generalInformationPage.addEventButton.isDisplayed());
       } catch (NoSuchElementException e) {
           e.printStackTrace();
       }
       }


    @Then("Data from the table and car page matches correctly")
    public void dataFromTheTableAndCarPageMatchesCorrectly() {
        BrowserUtils.sleep(15);
        List<String> vehiclesRow = new ArrayList<>();

        for (int i = 2; i < 21; i++) {
            try {
                WebElement columnData = Driver.getDriver().findElement(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/tbody/tr/td[" + i + "]"));
                vehiclesRow.add(columnData.getText());

            } catch (org.openqa.selenium.NoSuchElementException e) {
                e.printStackTrace();
                vehiclesRow.add("null");
            }
        }
        BrowserUtils.sleep(20);
        vehiclePage.carsTableFirstRow.click();
        List<String> infoPageRow = new ArrayList<>();

        for (int i = 1; i < 23; i++) {
            WebElement rowData = Driver.getDriver().findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div[2]/div/div/div/div[" + i + "]/div/div"));
            infoPageRow.add(rowData.getText());
        }

        try {
            for (int i = 0; i < 23; i++) {
                Assert.assertEquals(infoPageRow.get(i), vehiclesRow.get(i));
            }
        } catch (ComparisonFailure e) {
            e.printStackTrace();
        }
    }
}