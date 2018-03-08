package com.selenium.automation.EcommerceProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class GmailLinkClicking {
  WebDriver driver;
	
  @BeforeMethod
  @Parameters("browser")
  public void beforeMethod(String browserType) 
  {
	   if(browserType.equalsIgnoreCase("CHROME"))
	   {
		   System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
	   }else if(browserType.equalsIgnoreCase("IE"))
	   {
		   System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
	   }
	  driver.manage().window().maximize();
	  driver.get("https://www.google.com");
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }
  
  @Test
  public void verifyGmailLink() 
  {
	  Assert.assertEquals(driver.getTitle(), "Google");
	  driver.findElement(By.linkText("Gmail")).click();
	  Assert.assertEquals(driver.getTitle(),"Gmail - Free Storage and Email from Google");
	   
  }

  @AfterMethod
  public void tearDown() 
  {
	  driver.close();
  }

}
