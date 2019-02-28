package com.ums.utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.gargoylesoftware.htmlunit.BrowserVersion;

public class BrowserFactory {

	static WebDriver driver;
	static configReader configreader = new configReader();

	public static WebDriver startBrowser(String browsername) throws IOException, Exception {
		if (browsername.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", configreader.getChromePath());
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		} else if (browsername.equalsIgnoreCase("Headless")){
			driver = new HtmlUnitDriver(BrowserVersion.CHROME);
		}else if (browsername.equalsIgnoreCase("PhantomJs"))
			driver = new HtmlUnitDriver(BrowserVersion.CHROME);
		String urlName = ReadExcelHashMap.getValue("urlLink");
        driver.get(urlName);
        System.out.println(driver.getTitle());
     	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(100,TimeUnit.SECONDS);
		PropertyConfigurator.configure("log4j.properties");
		return driver;
		
	}

}
