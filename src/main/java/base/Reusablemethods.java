package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

public class Reusablemethods {
	
	Select sel;
	Faker faker;
	WebDriver driver;
	Actions action;
	JavascriptExecutor js ;
	
	public Reusablemethods(WebDriver driver)
	{
		this.driver= driver;
		action = new Actions(driver);
	    js = (JavascriptExecutor) driver;
	}
	
	public void selectBy_value(WebElement ele, String day )
	{
		 sel = new Select (ele);
		sel.selectByValue(day);
	}
	
	public void selectBy_visibleText(String day, WebElement ele )
	{
		sel = new Select (ele);
		sel.selectByVisibleText(day);
	}
	
	public void selectBy_index(WebElement ele, int num)
	{
		sel = new Select (ele);
		sel.selectByIndex(num);
	}
	
	 public String random_email()
	 {
		 faker = new Faker();
		return faker.name().firstName()+faker.number().digits(2)+"@gmail.com";
	 }
	 
	public void hover_ele(WebElement ele)
	{
		action.moveToElement(ele).perform();
	}
	
	public void scroll_ele(WebElement ele)
	{
		js.executeScript("arguments[0].scrollIntoView()", ele);
	}
	
	

}
