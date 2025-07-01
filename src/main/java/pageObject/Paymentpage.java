package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.Basepage;
import base.Reusablemethods;
import constants.FrameworkConstants;
import utilities.WaitUtils;

public class Paymentpage extends Basepage{

	Reusablemethods rm;
	WaitUtils waitutils;

	public Paymentpage (WebDriver driver) {
		super(driver);
		rm = new Reusablemethods(driver);
		waitutils = new WaitUtils(driver, FrameworkConstants.timeout_wait);
	}
	
	//Locators
	@FindBy (name="name_on_card")
	WebElement name;
	
	@FindBy (name="card_number")
	WebElement card_number;
	
	@FindBy (name="cvc")
	WebElement cvc;
	
	@FindBy (name="expiry_month")
	WebElement expiry_month;
	
	@FindBy (name="expiry_year")
	WebElement expiry_year;
	
	@FindBy (id="submit")
	WebElement submit_btn;
	
	@FindBy (xpath="//div[@class=\"col-sm-9 col-sm-offset-1\"]//p")
	WebElement get_con_msg;
	
	//Actions
	public void Set_payment_name(String Payment_name)
	{

		name.sendKeys(Payment_name);
	}
	
	public void set_cardnumber(String Cardnumber)
	{
		card_number.sendKeys(Cardnumber);
	}
	
	public void set_cvc (String CVC)
	{
		cvc.sendKeys(CVC);
	}
	
	public void set_expiry_month (String Expiry_month)
	{
		expiry_month.sendKeys(Expiry_month);
	}
	
	public void set_expiry_year (String Expiry_year)
	{
		expiry_year.sendKeys(Expiry_year);
	}
	
	public void click_submit_btn ()
	{
		submit_btn.click();
	}
	
	public String get_confirm_msg()
	{
		return get_con_msg.getText();
	}
	
	
	
	
	
}
