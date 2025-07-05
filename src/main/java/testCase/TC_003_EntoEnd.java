package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pageObject.Cartpage;
import pageObject.CheckoutPage;
import pageObject.Homepage;
import pageObject.LoginPage;
import pageObject.Paymentpage;
import pageObject.ProductList;

public class TC_003_EntoEnd extends BaseTest {

	LoginPage lp;
	Homepage hp;
	
	@Test (priority=1)
	public void login() {
		lp = new LoginPage(driver);

		lp.set_login_email(prop.getProperty("logEmail"));
		lp.set_login_password(prop.getProperty("logPassword"));
		lp.click_login_btn();
		//Assert.assertEquals(driver.getTitle(), "Automation Exercise - Signup / Login");
	}
	
	@Test (priority=2)
	public void search_product() throws InterruptedException
	{
		try
		{
			hp = new Homepage(driver);
			ProductList pl = new ProductList (driver);
			hp.click_product();
			pl.scroll_ele();
	     	pl.hover_ele();
			pl.click_list_product();
			Thread.sleep(2000);
			pl.click_view_cart();
			Assert.assertEquals(driver.getTitle(), "Automation Exercise - Checkout");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			e.getMessage();
		}
		
	}
	
	@Test (priority=3, dependsOnMethods= {"search_product"})
	public void add_to_cart()
	{
		try
		{
			Cartpage cp = new Cartpage (driver);
			cp.click_checkout_btn();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			e.getMessage();
		}
		
	}
	
	@Test (priority=4)
	public void checkout()
	{
		try
		{
			CheckoutPage chp = new CheckoutPage (driver);
			chp.Enter_note("good");
			chp.click_placeorder_btn();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			e.getMessage();
		}
		
	}
	
	@Test (priority=5)
	public void payment()
	{
		try
		{
			Paymentpage pp = new Paymentpage (driver);
			pp.Set_payment_name(prop.getProperty("name"));
			pp.set_cardnumber(prop.getProperty("cardnumber"));
			pp.set_cvc(prop.getProperty("cvc"));
			pp.set_expiry_month(prop.getProperty("exp"));
			pp.set_expiry_year(prop.getProperty("year"));
			pp.click_submit_btn();
			
			Assert.assertEquals(pp.get_confirm_msg(), "Congratulations! Your order has been confirmed!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			e.getMessage();
		}
		
	}
	
	

}
