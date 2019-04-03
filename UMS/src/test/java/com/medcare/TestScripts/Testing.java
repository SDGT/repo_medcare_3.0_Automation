package com.medcare.TestScripts;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Testing {
	
	@Test
	public void startBrowser()
	{
		String exePath = "C:\\repo_clinicare2.0_automation\\UMS\\driverExecutables\\chromedriver.exe";
		 System.setProperty("webdriver.chrome.driver", exePath);
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://www.toolsqa.com/selenium-webdriver/javascript-and-selenium-javascriptexecutor/");	 
		driver.findElement(By.xpath("(//a[@title='Facebook'])[1]")).click();
		 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(0));
		 
	}

}
