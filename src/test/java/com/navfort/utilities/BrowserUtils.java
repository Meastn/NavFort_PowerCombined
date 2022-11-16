package com.navfort.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserUtils {
    // This method accepts a String "expectedTitle" and Asserts if it is true

    public static void switchWindowAndVerify(String expectedInURL, String expectedInTitle){
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();
        for (String each : allWindowHandles){
            Driver.getDriver().switchTo().window(each);
            if (Driver.getDriver().getCurrentUrl().contains(expectedInURL)){
                break;
            }
        }
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedInTitle));
    }

    public static void verifyTitle (WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Title verified");
    }

    public static void sleep (long second){
        long millis = second*1000;
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
           // throw new RuntimeException();
            e.printStackTrace(); //added by Serdar
        }
        System.out.println("Wait for " + second + " seconds and continue");
    }
    //   Creating a utility method for ExplicitWait so we dont have to repeat the lines
    public static void waitForInvisibility (WebElement webElement) {
       // Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));   //done by Serdar
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15)); //it was 0, changed to 15 seconds
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public static void verifyURLContains (String expectedURL) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedURL));
    }
    // This method will accept a dropdown menu as a WebElement and turn it into a List of Strings and return the List
    public static List<String> dropdownOptionsAsAString (WebElement dropdownWebElements) {
        Select select = new Select(dropdownWebElements);
        List <WebElement> actualOptionsAsWebElement = select.getOptions();
        List <String> actualOptionsAsString = new ArrayList<>();
        for (WebElement each : actualOptionsAsWebElement){
            actualOptionsAsString.add(each.getText());
        }
        return actualOptionsAsString;
    }
    //    This method will accept a List of Radiobuttons, and will select the matching radio button
//     * with the provided value (string)
    public static void clickRadioButton (List<WebElement> radioButtons, String attributeValue) {
        for (WebElement each : radioButtons){
            if (each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                each.click();
            }
        }
    }
    public static void waitForVisibility (WebElement webElement) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15)); //it was 0, changed to 15 seconds
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitForClickable (WebElement webElement) {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15)); //it was 0, changed to 15 seconds
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}

