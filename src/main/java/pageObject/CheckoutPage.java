package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.Basepage;
import base.Reusablemethods;
import constants.FrameworkConstants;
import utilities.WaitUtils;

public class CheckoutPage extends Basepage {

	Reusablemethods rm;
	WaitUtils waitutils;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		rm = new Reusablemethods(driver);
		waitutils = new WaitUtils(driver, FrameworkConstants.timeout_wait);
	}
	
	//Locators
	@FindBy (name="message")
	WebElement note;
	
	@FindBy (xpath="//a[text()='Place Order']")
	WebElement placeorder_btn;
	
	//Actions
	public void Enter_note(String text)
	{
		note.sendKeys(text);
	}
	
	public void click_placeorder_btn()
	{
		placeorder_btn.click();
	}
	
	

}
