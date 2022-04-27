package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePages {
WebDriver driver;
	
	@FindBy(name="q")
	WebElement SearchTxtField;
	
	public WebElement getSearchTxtField() {
		return SearchTxtField;
	}
	
	
	
	@FindAll(@FindBy(className="sbct"))
	List<WebElement> AllItems;

	
	public List<WebElement> getAllItems() {
		return AllItems;
}
	
	@FindBy(name="userName") 
		WebElement UserTextField;
	
		public WebElement getUserTextField() {
			return UserTextField;
	}
		
		@FindBy(name="password") 
		WebElement PasswordTextField;
	
		public WebElement getPasswordTextField() {
			return PasswordTextField ;
	}
	
	public GooglePages(WebDriver rDriver) {
		this.driver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	

}
