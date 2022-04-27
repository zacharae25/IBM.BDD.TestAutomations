package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonPages {
	
//	1. Accomodate the elements and its description
//	2. create the methods that can return the elements
//	3. argument based constructor to initialize all the element present in the pages to the browser that is executed in the test case.
//	
	WebDriver driver;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement SearchTxtField;
	
	public WebElement getSearchTxtField() {
		return SearchTxtField;
	}
	
	@FindBy(name="url")
	WebElement Category;
	
	public Select getCategory() {
		Select sel = new Select(Category);
		return sel;
	}
	
	@FindBy(id="nav-search-submit-button")
	WebElement MagnifierBtn;
	
	public WebElement getMagnifierBtn() {
		return MagnifierBtn;
	}
	
	@FindAll(@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']"))
	List<WebElement> AllItems;
	
	public List<WebElement> getAllItems() {
		return AllItems;
	}

	@FindAll(@FindBy(className="nav_a"))
	List<WebElement> AllFooterLinks;
	
	public List<WebElement> getAllFooterLinks() {
		return AllFooterLinks;
	}
	
	@FindBy(id="nav-link-accountList")
	WebElement AccountandLists;
	
	public WebElement getAccountandLists() {
		return AccountandLists;
	}
	
	@FindBy(linkText="Start here.")
	WebElement starthereLink;
	
	public WebElement getstarthereLink() {
		return starthereLink;
	}
	
	@FindBy(name="customerName")
	WebElement YourNameTextField;
	
	public WebElement getYourNameTextField() {
		return YourNameTextField;
	}
	
	@FindBy(id="ap_phone_number")
	WebElement PhNumTextField;
	
	public WebElement getPhNumTextField() {
		return PhNumTextField;
	}
	
	@FindBy(id="ap_email")
	WebElement emailTextField;
	
	public WebElement getemailTextField() {
		return emailTextField;
	}
	
	@FindBy(linkText="Careers")
	WebElement CareersLink;
	
	public WebElement getCareersLink() {
		return CareersLink;
	}
	
	public AmazonPages(WebDriver rDriver) {
		this.driver = rDriver;
		PageFactory.initElements(rDriver, this);
	}

}

