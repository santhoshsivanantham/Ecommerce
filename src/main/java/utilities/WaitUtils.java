package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Basepage;

public class WaitUtils {
	
	WebDriver driver;
	WebDriverWait mywait;
	
	public WaitUtils (WebDriver driver, Duration timeunit)
	{
		this.driver=driver;
		mywait = new WebDriverWait (driver, timeunit );
		
	}
	
	public void wait_visiblity_ele (WebElement ele)
	{
		mywait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void wait_clickable_ele(WebElement ele)
	{
		mywait.until(ExpectedConditions.elementToBeClickable(ele));
	}

}
