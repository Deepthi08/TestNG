package com.selenium.automation.EcommerceProject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LinksTesting1 
{

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
		driver.get("https://google.com");
		//driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	}
	
	
	
	@Test()
	public void linktesting1()
	
	 {
		String expval="Google Images";
		
		driver.findElement(By.linkText("Images")).click();		
		String actval=driver.getTitle();
		
		Assert.assertEquals(actval, expval);
		/*if(actval.contentEquals(expval))
		{
			System.out.println("Images links are same \n" +  actval  +  "\n"  + expval);
		}
		else
		{
			System.out.println("Images links are different \n"+actval+"\n"+ expval);
		}*/
	 }
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
