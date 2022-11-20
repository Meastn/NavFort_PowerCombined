package com.navfort.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {

    private Driver() {
        // We make WebDriver private, because we want to close the access from outside of the class
        // We make it static because we will use it in a static method
    }

    private static WebDriver driver;

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    // Create a reusable utility method which will return same driver instance when we call it
    // SINGLETON DESIGN PATTERN

    public static WebDriver getDriver(){
        if (driverPool.get()==null){
            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "safari":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }
        }
        return driverPool.get();
    }
    //This method ensures that our driver value is always null after using quit() method
    public static void closeDriver(){
        if (driverPool.get() != null) {
            driverPool.get().quit(); // terminate existing session
            driverPool.remove();//define driver as null for our singleton design pattern
        }
    }
}

