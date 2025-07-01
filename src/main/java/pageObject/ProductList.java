package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.Basepage;
import base.Reusablemethods;
import constants.FrameworkConstants;
import utilities.WaitUtils;

public class ProductList extends Basepage {
	
	Reusablemethods rm;
	WaitUtils waitutils;
	
	public ProductList(WebDriver driver) {
		super(driver);
		rm = new Reusablemethods(driver);
		 waitutils = new WaitUtils (driver, FrameworkConstants.timeout_wait);
	}
	
	//Locators
	@FindBy (xpath="//u[text()='View Cart']")
	WebElement view_cart;
	
	@FindBy(id="search_product")
	WebElement search;
	
	@FindBy(id="submit_search")
	WebElement submit_search;
	
	@FindBy(xpath="//div[@class='features_items']//div[@class='col-sm-4'][2]")
	WebElement product_list;
	
	@FindBy(xpath="//div[@class='features_items']//div[@class='col-sm-4'][2]//div[2]//a")
	WebElement product_click;
	
	@FindBy(xpath="//div[@class='features_items']//div[@class='col-sm-4'][2]//div[2]//p")
	WebElement product_name;

	
	//Actions
	public void click_view_cart()
	{
		view_cart.click();
	}
	
	public void enter_product_name(String Product_name)
	{
		search.sendKeys(Product_name);
	}
	
	public void submit_search()
	{
		submit_search.click();
	}
	
	public void hover_ele()
	{
		rm.hover_ele(product_list);
	}
	
	public void click_list_product()
	{
		waitutils.wait_visiblity_ele(product_click);
		product_click.click();
	}
	
	public void scroll_ele()
	{
		rm.scroll_ele(product_click);
	}
	
	public String get_product_name()
	{
		return product_name.getText();
	}

}
