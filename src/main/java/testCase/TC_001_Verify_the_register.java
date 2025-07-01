package testCase;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import base.BaseTest;
import base.Reusablemethods;
import pageObject.LoginPage;
import pageObject.RegisterPage;

public class TC_001_Verify_the_register extends BaseTest {

	@Test
	public void Register() {
		try {
			LoginPage lp = new LoginPage(driver);
			Reusablemethods rm = new Reusablemethods(driver);
			String email=rm.random_email();
			System.out.println(email);

			lp.set_signup_name(prop.getProperty("name"));
			lp.set_signup_email(email);
			lp.click_signup_Btn();

			RegisterPage rp = new RegisterPage(driver);
			rp.click_title_male();

			Assert.assertEquals(rp.get_name(), prop.getProperty("name"));
			Assert.assertEquals(rp.get_email(), email);

			rp.set_password(prop.getProperty("password"));
			rp.Select_day_value(prop.getProperty("day"));
			rp.Select_month_visible(prop.getProperty("month"));
			rp.Select_year_value(prop.getProperty("years"));
			rp.set_firatName(prop.getProperty("firstname"));
			rp.set_lastname(prop.getProperty("lastname"));
			rp.set_address(prop.getProperty("address"));
			rp.Select_country_visible(prop.getProperty("country"));
			rp.set_state(prop.getProperty("state"));
			rp.set_city(prop.getProperty("city"));
			rp.set_zipcode(prop.getProperty("zipcode"));
			rp.set_mobilenumber(prop.getProperty("mobilenumber"));
			rp.click_create_account();
			Thread.sleep(3000);
			Assert.assertEquals(driver.getTitle(), "Automation Exercise - Account Created");
			rp.click_continue();

		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
	}

	/*
	 * @Test(dataProvider = "signup") public void Register(String name, String
	 * email, String password, String day, String month, String year, String
	 * firstname, String lastname, String address, String country, String state,
	 * String city, String zipcode, String mobilenumber) { try { LoginPage lp = new
	 * LoginPage(driver); lp.set_signup_name(name); lp.set_signup_email(email);
	 * lp.click_signup_Btn();
	 * 
	 * RegisterPage rp = new RegisterPage(driver); rp.click_title_male();
	 * 
	 * Assert.assertEquals(rp.get_name(), name); Assert.assertEquals(rp.get_email(),
	 * email);
	 * 
	 * rp.set_password(password); rp.Select_day_value(day);
	 * rp.Select_month_visible(month); rp.Select_year_value(year);
	 * rp.set_firatName(firstname); rp.set_lastname(lastname);
	 * rp.set_address(address); rp.Select_country_visible(country);
	 * rp.set_state(state); rp.set_city(city); rp.set_zipcode(zipcode);
	 * rp.set_mobilenumber(mobilenumber); Assert.assertTrue(true);
	 * 
	 * } catch (Exception e) { e.printStackTrace(); e.getMessage(); }
	 * 
	 * }
	 * 
	 * @DataProvider(name = "signup") Object[][] signup_data() { Object[][] data = {
	 * { "santhosh", "zsas7845666@gmail.com", "Santhosh@123", "10", "April", "2014",
	 * "Saravanan", "Sivanantham", "123", "Australia", "tamilnadu", "Nagercoil",
	 * "658902", "5657783121" } }; return data; }
	 */

}
