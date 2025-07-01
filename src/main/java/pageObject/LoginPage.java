package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.Basepage;

public class LoginPage extends Basepage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Locators
	@FindBy(xpath = "//input[@data-qa='signup-name']")
	WebElement sign_name;

	@FindBy(xpath = "//input[@data-qa='signup-email']")
	WebElement sign_email;

	@FindBy(xpath = "//button[@data-qa='signup-button']")
	WebElement signup_Btn;
	
	@FindBy(xpath = "//input[@data-qa='login-email']")
	WebElement login_email;
	
	@FindBy(xpath = "//input[@data-qa='login-password']")
	WebElement login_pass;
	
	@FindBy(xpath = "//button[@data-qa='login-button']")
	WebElement login_Btn;
	
	
	//Actions
	public void set_signup_name(String Name)
	{
		sign_name.sendKeys(Name);
	}
	
	public void set_signup_email(String Email)
	{
		sign_email.sendKeys(Email);
	}
	
	public void click_signup_Btn()
	{
		signup_Btn.click();
	}
	
	public void set_login_email(String Email)
	{
		login_email.sendKeys(Email);
	}
	
	public void set_login_password(String Password)
	{
		login_pass.sendKeys(Password);
	}
	
	public void click_login_btn()
	{
		login_Btn.click();
	}
	
	public void clear_login()
	{
		login_email.clear();
	}
	
	public void clear_password()
	{
		login_pass.clear();
	}
	
	

}