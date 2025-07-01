package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import base.Basepage;
import base.Reusablemethods;
import constants.FrameworkConstants;
import utilities.WaitUtils;

public class RegisterPage extends Basepage {

	WaitUtils waitUtils;
	Reusablemethods rm;
	
	public RegisterPage(WebDriver driver) {
		super(driver);
		waitUtils = new WaitUtils (driver, FrameworkConstants.timeout_wait);
	    rm = new Reusablemethods (driver);

	}
	
	
	
	// Locators
	@FindBy(id = "id_gender1")
	WebElement gender_mr;

	@FindBy(xpath = "//input[@data-qa='name']")
	WebElement name;

	@FindBy(xpath = "//input[@data-qa='email']")
	WebElement email;

	@FindBy(xpath = "//input[@data-qa='password']")
	WebElement password;

	@FindBy(id = "first_name")
	WebElement firstname;

	@FindBy(id = "last_name")
	WebElement lastname;

	@FindBy(id = "address1")
	WebElement address;

	@FindBy(id = "state")
	WebElement state;

	@FindBy(id = "city")
	WebElement city;

	@FindBy(id = "zipcode")
	WebElement zipcode;

	@FindBy(id = "mobile_number")
	WebElement mobilenumber;

	@FindBy(id = "days")
	WebElement day_drp;

	@FindBy(id = "months")
	WebElement month_drp;

	@FindBy(id = "years")
	WebElement year_drp;

	@FindBy(id = "country")
	WebElement country_drp;
	
	@FindBy(xpath = "//button[@data-qa='create-account']")
	WebElement create_account_btn;
	
	@FindBy(xpath = "//button[@data-qa='account-created']//b")
	WebElement welcome;
	
	@FindBy(xpath = "//a[@data-qa='continue-button']")
	WebElement continue_btn;

	// Actions
	
	@SuppressWarnings("deprecation")
	public String get_name()
	{
		return name.getAttribute("value");
	}
	
	@SuppressWarnings("deprecation")
	public String get_email()
	{
		return email.getAttribute("value");
	}
	
	public void Select_day_value(String day) {
		rm.selectBy_value(day_drp, day);
	}

	public void Select_month_visible(String month) {
		rm.selectBy_visibleText(month, month_drp);
	}

	public void Select_year_value(String year) {
		rm.selectBy_value(year_drp, year);
	}

	public void Select_country_visible(String country) {
		rm.selectBy_visibleText(country, country_drp);
	}

	public void click_title_male() {
		gender_mr.click();
	}

	public void set_password(String pass) {
		password.sendKeys(pass);
	}

	public void set_firatName(String firstName) {
		firstname.sendKeys(firstName);
	}

	public void set_lastname(String Lastname) {
		lastname.sendKeys(Lastname);
	}

	public void set_address(String Address) {
		address.sendKeys(Address);
	}

	public void set_state(String State) {
		state.sendKeys(State);
	}

	public void set_city(String City) {
		city.sendKeys(City);
	}

	public void set_zipcode(String Zipcode) {
		zipcode.sendKeys(Zipcode);
	}

	public void set_mobilenumber(String Mobilenumber) {
		mobilenumber.sendKeys(Mobilenumber);
	}
	
	public void click_create_account()
	{
		create_account_btn.click();
	}
	
	public void click_continue()
	{
		continue_btn.click();
	}
	
	public String get_welcome_text()
	{
		waitUtils.wait_visiblity_ele(welcome);
		return welcome.getText();
	}
}
