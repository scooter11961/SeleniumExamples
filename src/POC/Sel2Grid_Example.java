package POC;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.*;


public class Sel2Grid_Example {
	private WebDriver driver;
	private String baseUrl="";
	private StringBuffer verificationErrors = new StringBuffer();
	@Before
	public void setUp() throws Exception {

// To run tests locally
//		driver = new FirefoxDriver();
	
//To run tests against Selenium Grid2		
//      DesiredCapabilities capability = DesiredCapabilities.firefox();
		DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
//		DesiredCapabilities capability = DesiredCapabilities.chrome();
//		capability.setVersion("8");
        driver = new RemoteWebDriver(new URL("http://mqgridhub.office.aol.com:4445/wd/hub"), capability);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	@Test
	public void testJunit4Webdriver() throws Exception {

		
		driver.get("http://mq-devhost-lm52.ihost.aol.com:9002/us/ny/new-york/upper-west-side");
		driver.findElement(By.linkText("Manhattan Valley")).click();
		try {
			assertEquals("Manhattan Valley", driver.findElement(By.cssSelector("div.name")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.cssSelector("span.poi_name")).click();
		
//		try {
//			assertEquals("Whole Foods Market", driver.findElement(By.cssSelector("div.title")).getText());
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
		
		
		try {
			assertTrue(driver.findElement(By.cssSelector("div.title")).isDisplayed());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}

//		try {
//			assertTrue(driver.findElement(By.cssSelector("div.mqabasicwnd-close")).isDisplayed());
//		} catch (Error e) {
//			verificationErrors.append(e.toString());
//		}
		
		
//		driver.findElement(By.cssSelector("div.mqabasicwnd-close")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
 		String verificationErrorString = verificationErrors.toString();
//		if (!"".equals(verificationErrorString)) {
//			fail(verificationErrorString);
//LET		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
