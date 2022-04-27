package com.qa.testrunners;


import org.junit.runner.RunWith;
//import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
//import io.cucumber.testng.AbstractTestNGCucumberTests;
//import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="C:\\Users\\P102GDPH1\\eclipse-workspace\\IBM.BDD.TestAutomations\\src\\test\\java\\com\\qa\\features\\GoogleFeature.feature",
		glue="com.qa.StepDeff",
		dryRun=false,
		monochrome=true,
		
		 plugin= {"pretty","json:target/MyReports/report.json",
	                "json:target/cucumber.json",
	        "junit:target/MyReports/report.xml"},
	        publish=true
	        )
	public class TestRunner  {
	   
}
