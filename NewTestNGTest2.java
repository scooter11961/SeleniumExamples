package com.mapquest.vibe.uitest;



	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.By;
	import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

import com.mapquest.vibe.uitest.PageLayout.PageLayoutSelectors;
import com.mapquest.vibe.util.Utils;
	 
	import java.util.ArrayList;
import java.util.List;


	public class NewTestNGTest2 {

		FirefoxDriver driver;

		
		 @BeforeTest
		    public void startDriver() {
			 driver = new FirefoxDriver();
		    }
		 
		    @AfterTest
		    public void stopDriver() {
		        driver.close();
		    }
		
		        
		        @Test
		        public void testLocationOne() {
		        	// load a specific location
		        	//driver.get(host + "/us/nj/upper-montclair/bellevue-ave-valley-rd");
		        	driver.get("http://mq-devhost-lm52.ihost.aol.com:9002/us/nj/upper-montclair/bellevue-ave-valley-rd");
		        	AssertJUnit.assertEquals(Utils.getElementText(driver,PageLayoutSelectors.TOP_NAME),"Bellevue Ave & Valley Rd");
		        }

		        
		        @Test
		        public void testLocationTwo() {
		        	// load a specific location
		        	//driver.get(host + "/us/nj/upper-montclair/preston-pl-valley-rd/");
		        	driver.get("http://mq-devhost-lm52.ihost.aol.com:9002/us/nj/upper-montclair/preston-pl-valley-rd/");
		        	AssertJUnit.assertEquals(Utils.getElementText(driver,PageLayoutSelectors.TOP_NAME),"Preston Pl & Valley Rd");
		        }

		        @Test
		        public void testLocationThree() {
		        	// load a specific location
		        	//driver.get(host + "/us/nj/montclair/");
		        	driver.get("http://mq-devhost-lm52.ihost.aol.com:9002/us/nj/upper-montclair/");
		        	AssertJUnit.assertEquals(Utils.getElementText(driver,PageLayoutSelectors.TOP_NAME),"Upper Montclair");
		        }

		        @Test
		        public void testLocationFour() {
		        	// load a specific location
		        	//driver.get(host + "/us/nj/upper-montclair/bellevue-ave-valley-rd");
		        	driver.get("http://mq-devhost-lm52.ihost.aol.com:9002/us/nj/upper-montclair/bellevue-ave-valley-rd");
		        	AssertJUnit.assertEquals(Utils.getElementText(driver,PageLayoutSelectors.TOP_NAME),"Bellevue Ave & Valley Rd");
		        }

		        
		        @Test
		        public void testLocationFive() {
		        	// load a specific location
		        	//driver.get(host + "/us/nj/upper-montclair/preston-pl-valley-rd/");
		        	driver.get("http://mq-devhost-lm52.ihost.aol.com:9002/us/nj/upper-montclair/preston-pl-valley-rd/");
		        	AssertJUnit.assertEquals(Utils.getElementText(driver,PageLayoutSelectors.TOP_NAME),"Preston Pl & Valley Rd");
		        }

		        @Test
		        public void testLocationSix() {
		        	// load a specific location
		        	//driver.get(host + "/us/nj/montclair/");
		        	driver.get("http://mq-devhost-lm52.ihost.aol.com:9002/us/nj/upper-montclair/");
		        	AssertJUnit.assertEquals(Utils.getElementText(driver,PageLayoutSelectors.TOP_NAME),"Upper Montclair");
		        }
		        
		        
	}
	
	
	
