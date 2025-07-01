package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Basepage {
	WebDriver driver;
	
	//creating constructor to initiate the PageFactory
	public Basepage (WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

}
