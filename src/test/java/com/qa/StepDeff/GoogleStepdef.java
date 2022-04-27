package com.qa.StepDeff;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.pages.GooglePages;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class GoogleStepdef {
	
	
	WebDriver driver;
	GooglePages GoogleOR;
	FileInputStream fileLoc;
	Properties prop;

	@Before
	public void setUp() throws IOException {
		fileLoc = new FileInputStream("C:\\Users\\P102GDPH1\\eclipse-workspace\\IBM.BDD.TestAutomations\\src\\test\\java\\com\\qa\\testData\\config.properties");
		prop = new Properties();
		prop.load(fileLoc);
		
	}

	@Given("the browser is invoked")
	public void the_browser_is_invoked() {
		String Browser = prop.getProperty("Browser");
		if(Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else if(Browser.equalsIgnoreCase("Ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}else if(Browser.equalsIgnoreCase("Firefo")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		GoogleOR = new GooglePages(driver);
	
	}
	@Given("the url the launched")
	public void the_url_the_launched() {
		 String Url = prop.getProperty("Url");
			
		driver.get(Url);
	}
	
	@Given("The user is on google home page")
		public void the_user_is_on_google_home_page() {
			boolean contains = driver.getTitle().contains("Google");
			AssertJUnit.assertTrue(contains);
		   
		}
	

	@When("The user types {string} search item")
	public void the_user_types_search_item(String SearchTxtField) throws InterruptedException {
		GoogleOR.getSearchTxtField().sendKeys(SearchTxtField);
		Thread.sleep(3000);	
    }

	@When("The title of page should be same as {string}")
	public void the_title_of_page_should_be_same_as(String SearchTxtField) {
		boolean contains = driver.getTitle().contains(SearchTxtField);
		AssertJUnit.assertTrue(contains);
}

	@When("The items related to search term is shown")
	public void the_items_related_to_search_term_is_shown() {
		List<WebElement> allItems =GoogleOR.getAllItems();
		System.out.println(allItems.size());
		for(WebElement item: allItems) {
			System.out.println(item.getText());
			
		}
	    
	}

	@Then("search the automation testing keyword")
	public void search_the_automation_testing_keyword() {
		GoogleOR.getSearchTxtField().submit();
	    
	}

	@When("The title of page should be same as search term")
	public void the_title_of_page_should_be_same_as_search_term() {
		boolean contains = driver.getTitle().contains("automation testing");
		AssertJUnit.assertTrue(contains);
	    
	}

	@Then("close the browser")
	public void close_the_browser() {
		driver.close();
	}

}
