package POC;


	import java.util.concurrent.TimeUnit;

import com.google.common.base.Supplier;
import com.thoughtworks.selenium.Selenium;
	import org.openqa.selenium.*;
	import org.openqa.selenium.firefox.*;
//	import org.junit.*;
	import static org.junit.Assert.*;
	import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

	
	//@SuppressWarnings("unused")
	
	
	
	public class CatchErrors_WebDriverBackedSelenium {
	
		private static WebDriver driver;

		@BeforeClass
		public void setUp() throws Exception {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	
	
		@AfterClass
		public void tearDown() throws Exception {
			driver.close();
			driver.quit();
		}
		
		@Test	
	public static void main() throws Exception {
	//WebDriver driver = new FirefoxDriver();
	String baseUrl = "http://www.google.com";
	Selenium selenium = new WebDriverBackedSelenium(driver, baseUrl);
	selenium.open("");
	selenium.type("q", "selenium wiki");
	//selenium.type("q", "hamburger");
	selenium.click("btnG");
	Thread.sleep(5000);
	try
	{
	assertTrue(selenium.isTextPresent("Selenium Wiki"));
	System.out.println("OUTPUT: Selenium Wiki is present on the google search results page");
	}
	catch (Exception e)
	{
	System.out.println("OUTPUT: Selenium Wiki is NOT present on the google search results page");
	}
	//driver.close();
	}

	

	
}
