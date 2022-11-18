package com.navfort.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            plugin = {
                    "html:target/cucumber-report.html",
                    "json:target/cucumber.json",
                    //"me.jvt.cucumber.report.PrettyReports:target/cucumber",
                    "rerun:target/rerun.txt",
            },
            features = "src/test/resources/features",
            glue =  "com/navfort/step_definitions",



            dryRun = true,
            tags ="",


            publish = false

    )

public class CukesRunner {
}
