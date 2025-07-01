package base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import constants.FrameworkConstants;
import io.reactivex.rxjava3.exceptions.Exceptions;

public class BaseTest {
	public static WebDriver driver;
	public FileReader file;
	public static Properties prop;

	@BeforeSuite
	@Parameters({ "browser" })
	public void setup_suite(String br) throws IOException {

		try
		{
			file = new FileReader(FrameworkConstants.config_path);
			prop = new Properties();
			prop.load(file);

			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			default:
				throw new IllegalArgumentException("no browser found");
		}
			
		}
		catch(Exception e)
		{
		   e.printStackTrace();
		   e.getMessage();
		}
	}	

	@BeforeClass
	public void setup_class() {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("login_URL"));
	}

	@AfterSuite
	public void teardown() {
		driver.quit();
	}

	// Take screenshorts
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = FrameworkConstants.sc_path + tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;
	}

}
