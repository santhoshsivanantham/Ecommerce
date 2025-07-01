package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.Basepage;
import base.Reusablemethods;
import constants.FrameworkConstants;
import utilities.WaitUtils;

public class Cartpage extends Basepage{
	
	Reusablemethods rm;
	WaitUtils waitutils;
	
	public Cartpage (WebDriver driver) {
		super(driver);
		rm = new Reusablemethods (driver);
	    waitutils = new WaitUtils (driver, FrameworkConstants.timeout_wait);
	}
	
	//Locators
	@FindBy (xpath="//a[text()='Proceed To Checkout']")
	WebElement checkout_btn;
	
	//Actions 
	public void click_checkout_btn()
	{
		waitutils.wait_clickable_ele(checkout_btn);
		checkout_btn.click();
	}
	

}
