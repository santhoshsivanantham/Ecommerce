package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.Basepage;
import base.Reusablemethods;
import constants.FrameworkConstants;
import utilities.WaitUtils;

public class Homepage extends Basepage {
	
	Reusablemethods rm;
	WaitUtils waitutils;
	
	public Homepage (WebDriver driver) {
		super(driver);
		rm = new Reusablemethods (driver);
	    waitutils = new WaitUtils (driver, FrameworkConstants.timeout_wait);
	}
	
	//Locators
	@FindBy (xpath="//a[@href='/logout']")
	WebElement logout;
	
	@FindBy(xpath="//a[@href='/products']")
	WebElement product;
	
		
	//Actions
	public void Click_logout()
	{
		logout.click();
	}
	
	public void click_product()
	{
		product.click();
	}
	
	
	
	
	
	
	
	

}
