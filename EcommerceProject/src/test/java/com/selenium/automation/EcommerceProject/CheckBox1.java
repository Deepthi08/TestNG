package com.selenium.automation.EcommerceProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;

public class CheckBox1 {
  
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
			driver.get("http://echoecho.com/htmlforms09.htm");
	  }
	  
	  
	@Test
	public void checkboxTest()
	{
		List<WebElement> check=driver.findElements(By.xpath("//td[@class='table5']/input[@type='checkbox']"));
		for(int i=0;i<check.size();i++)
		{
			System.out.println(check.get(i).getAttribute("value")+"--"+check.get(i).getAttribute("checked"));
			//System.out.println(check.get(i).isSelected());
		}
	}
 

  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
  }

}
