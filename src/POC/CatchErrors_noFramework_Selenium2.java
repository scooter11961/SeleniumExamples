package POC;


	import java.util.concurrent.TimeUnit;

	import com.thoughtworks.selenium.Selenium;
	import org.openqa.selenium.*;
	import org.openqa.selenium.firefox.*;
	//import org.junit.*;
	//import org.testng.Assert;
	//import static org.testng.AssertJUnit.assertTrue;

	//import org.testng.annotations.AfterClass;
	//import org.testng.annotations.BeforeClass;
	//import org.testng.annotations.Test;

	
	//@SuppressWarnings("unused")
	
	
	public class CatchErrors_noFramework_Selenium2 {
		private static WebDriver driver;

	
	
		
	public static void main() throws Exception {

		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	//WebDriver driver = new FirefoxDriver();
	String baseUrl = "http://www.google.com";
	Selenium selenium = new WebDriverBackedSelenium(driver, baseUrl);
	selenium.open("");
	selenium.type("q", "selenium wiki");
	//selenium.type("q", "hamburger");
	selenium.click("btnG");
	Thread.sleep(5000);
	
	
	//build my own way to capture errors
	try {
		//example of java assertion
		assert (selenium.isTextPresent("Selenium Wiki"));
		//example of junit TestNG assertion
		//assertTrue(selenium.isTextPresent("Selenium Wiki"));
	System.out.println("OUTPUT: Selenium Wiki is present on the google search results page");
	}	catch (Exception e) {
	//log.error(e.getMessage());
		e.printStackTrace();
	System.out.println("OUTPUT: Selenium Wiki is NOT present on the google search results page");
	
	driver.close();
	driver.quit();
	throw e;
	}

	
	}	
	
}
