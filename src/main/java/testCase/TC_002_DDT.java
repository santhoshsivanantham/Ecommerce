package testCase;

import org.testng.annotations.Test;

import base.BaseTest;
import pageObject.Homepage;
import pageObject.LoginPage;
import utilities.Dataproviders;

public class TC_002_DDT extends BaseTest {

	@Test(dataProvider = "logindata", dataProviderClass = Dataproviders.class)

	public void verify_login(String email, String password, String result) {
		LoginPage lp = new LoginPage(driver);

		lp.set_login_email(email);
		lp.set_login_password(password);
		lp.click_login_btn();
		System.out.println(result);
		Homepage hp = new Homepage (driver);
		
		if(driver.getTitle().equals("Automation Exercise"))
		{
			hp.Click_logout();
		}
		else
		{
			lp.clear_login();
			lp.clear_password();
		}
		System.out.println(result);

	}
}
