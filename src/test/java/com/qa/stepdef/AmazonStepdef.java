package com.qa.stepdef;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.qa.pages.AmazonPages;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonStepdef {
	
	WebDriver driver;
	AmazonPages AmazonOR;


	@Given("the browser is invoked")
	public void the_browser_is_invoked() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		AmazonOR = new AmazonPages(driver);
	
	}
	@Given("the url the launched")
	public void the_url_the_launched() {
		driver.get("https://www.amazon.in/");

	}

	@Given("The user is on amazon home page")
	public void the_user_is_on_amazon_home_page() {
		boolean contains = driver.getTitle().contains("Amazon");
		Assert.assertTrue(contains);
	}

	@When("the user selects {string} as category")
	public void the_user_selects_as_category(String CategoryName) {
		AmazonOR.getCategory().selectByVisibleText(CategoryName);
	}
	@When("the user types {string} as search item")
	public void the_user_types_as_search_item(String ItemName) {
		AmazonOR.getSearchTxtField().sendKeys(ItemName);

	}
	@Then("the title of page should be same as {string}")
	public void the_title_of_page_should_be_same_as(String ItemName) {
		boolean contains = driver.getTitle().contains(ItemName);
		Assert.assertTrue(contains);
	}
	
//	@When("the user selects Books as category")
//	public void the_user_selects_books_as_category() {
//		AmazonOR.getCategory().selectByVisibleText("Books");
//	}
//
//	@When("the user types Da vinci code as search item")
//	public void the_user_types_da_vinci_code_as_search_item() {
//		AmazonOR.getSearchTxtField().sendKeys("Da Vinci Code");
//	}

	@When("the magnifier button is clicked")
	public void the_magnifier_button_is_clicked() {
		AmazonOR.getMagnifierBtn().click();
	}

//	@Then("the title of page should be same as search term")
//	public void the_title_of_page_should_be_same_as_search_term() {
//		boolean contains = driver.getTitle().contains("Da Vinci Code");
//		Assert.assertTrue(contains);
//	}

	@Then("the items related to search term should be loaded")
	public void the_items_related_to_search_term_should_be_loaded() {
		List<WebElement> allItems = AmazonOR.getAllItems();
		System.out.println(allItems.size());
		for(WebElement item: allItems) {
			System.out.println(item.getText());
		}
	}

	@Then("close the browser")
	public void close_the_browser() {
		driver.close();
	}


	@When("the user does mouse over on accounts and lists element")
	public void the_user_does_mouse_over_on_accounts_and_lists_element() {
	    
		Actions act = new Actions(driver);
		WebElement ele = AmazonOR.getAccountandLists();
		act.moveToElement(ele).build().perform();
		
	}

	@Then("the start here should be clicked")
	public void the_start_here_should_be_clicked() {
		AmazonOR.getstarthereLink().click();
	}

	@Then("check if the user is landed on registration page")
	public void check_if_the_user_is_landed_on_registration_page() {
		boolean contains = driver.getTitle().contains("Registration");
		Assert.assertTrue(contains);
	}

	@Then("type the customer name")
	public void type_the_customer_name(DataTable dataTable) throws InterruptedException {
		List<String> data = dataTable.asList();
		for(String item: data) {
			AmazonOR.getYourNameTextField().sendKeys(item);
			Thread.sleep(3000);
			AmazonOR.getYourNameTextField().clear();
		}
	
		
	}


}
