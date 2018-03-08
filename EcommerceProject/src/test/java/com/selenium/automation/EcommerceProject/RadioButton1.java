package com.selenium.automation.EcommerceProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class RadioButton1 
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
			driver.get("http://echoecho.com/htmlforms10.htm");
	  }
	
	
	@Test
	public void radioButton()
	{
		WebElement radio=driver.findElement(By.xpath("html/body/div[2]/table[9]/tbody/tr/td[4]/table/tbody/tr/td/div/span/form/table[3]/tbody/tr/td/table/tbody/tr/td"));
		List<WebElement> rbutton=radio.findElements(By.name("group2"));
		for(int i=0;i<rbutton.size();i++)
		{
			System.out.println(rbutton.get(i).getAttribute("value")+ "----" + rbutton.get(i).getAttribute("checked"));
		}
	}
 

  @AfterMethod
  public void afterMethod() 
  {
	  driver.quit();
  }
	
}
