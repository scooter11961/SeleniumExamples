package POC;
import java.net.MalformedURLException;
import java.net.URL;
 
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
import com.mapquest.vibe.uitest.Facebook.FacebookSelectors;
import com.mapquest.vibe.uitest.PageLayout.PageLayoutSelectors;
import com.thoughtworks.selenium.Selenium;
 
import junit.framework.Assert;

public class ShowSel1andSel2Syntax {

	//for selenium2 webdriver
	protected WebDriver driver;
	//for selenium1 
	//private Selenium selenium;
	 @Parameters({"browser","port"})
	 @BeforeClass
	 public void beforeClass(String browser,String port){
	  DesiredCapabilities capability= new DesiredCapabilities();
	  capability.setBrowserName(browser);
	  try {
	   //WebDriver driver= new RemoteWebDriver(new URL("http://mqgridhub.office.aol.com:".concat(port).concat("/wd/hub")), capability);
		  driver= new RemoteWebDriver(new URL("http://mqgridhub.office.aol.com:".concat(port).concat("/wd/hub")), capability);
	   
	   //to use Selenium1 syntax
	   //selenium = new WebDriverBackedSelenium(driver, "http://search.aol.com");
	  } catch (MalformedURLException e) {
	    
	   e.printStackTrace();
	  }
	 }
	  
	 @Test
	 public void search() {
	  	 
	  driver.get("http://search.aol.com");	 
	  isElementPresent(driver, By.cssSelector("id=csbquery1"));
	  
	  WebElement el1 = driver.findElement(By.cssSelector("id=csbquery1"));
	  driver.findElement(By.cssSelector("id=csbquery1")).sendKeys("testing");
	  driver.findElement(By.cssSelector("id=csbbtn1")).click();
	  
	  //Selenium 1 syntax
	  //selenium.open("/");
	  //selenium.type("id=csbquery1", "testing");
	  //selenium.click("id=csbbtn1");
	  for (int second = 0;; second++) {
	   if (second >= 60)
	    Assert.fail("timeout");
//	   sel1
//	   try {
//	    if (selenium
//	      .isElementPresent("link=Software testing - Wikipedia, the free encyclopedia"))
//		   break;
//	   } catch (Exception e) {
//	   }

//sel2
	   try {
		   if (isElementPresent(driver, By.linkText("link=Software testing - Wikipedia, the free encyclopedia")))
			   break;
	   } catch (Exception e) {
		   
	   }
	   try {
	    Thread.sleep(1000);
	   } catch (InterruptedException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	   }
	  }
	   
	   
//		   selenium.click("link=Software testing - Wikipedia, the free encyclopedia");
	  driver.findElement(By.linkText("link=Software testing - Wikipedia, the free encyclopedia")).click();

	  for (int second = 0;; second++) {
	   if (second >= 60)
	    Assert.fail("timeout");
	   try {
//	    if (selenium.isTextPresent("Software testing"))
		if (driver.getPageSource().contains("Software testing"))
			
		   break;
	   } catch (Exception e) {
	   }
	   try {
	    Thread.sleep(1000);
	   } catch (InterruptedException e) {
	 
	    e.printStackTrace();
	   }
	  }
	 }

	 
	 
	 @AfterClass
	 public void afterClass(){
	  //selenium.stop();
	 driver.quit();	 
	 }
	 
	 public boolean isElementPresent(WebDriver driver, By by){
		    try{
		        driver.findElement(by);
		        return true;
		    }catch(NoSuchElementException e){
		        return false;
		    }
		}
	  
	}	
	
	
