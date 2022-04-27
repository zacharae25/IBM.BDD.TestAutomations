package com.qa.testrunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"C:\\Users\\P102GDPH1\\eclipse-workspace\\IBM.BDD.TestAutomations\\src\\test\\java\\com\\qa\\features\\GoogleFeature.feature"},
        glue = {"com.qa.StepDeff"},
        monochrome=true,
        plugin = {"json:target/cucumber.json"},
        publish=true
        
		)
public class TestRunner2 {
}
