package com.navfort.step_definitions;

/*
In the class we will be able to pass pre- & post- conditions to
 each scenario and each step
 */

import com.navfort.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {



    public void setupScenario(){
        System.out.println("====Setting up browser using cucumber @Before");
    }


    public void setupScenarioForLogins(){
        System.out.println("====this will only apply to scenarios with @login tag");
    }


    public void setupForDatabaseScenarios(){
        System.out.println("====this will only apply to scenarios with @db tag");
    }


    @After
    public void teardownScenario(Scenario scenario){




      if (scenario.isFailed()){

            byte [] screenshot = ((TakesScreenshot) com.navfort.utilities.Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }




      Driver.closeDriver();


    }

   // @BeforeStep
    public void setupStep(){
        System.out.println("--------> applying setup using @BeforeStep");
    }

    //@AfterStep
    public void afterStep(){
        System.out.println("--------> applying tearDown using @AfterStep");
    }


}
