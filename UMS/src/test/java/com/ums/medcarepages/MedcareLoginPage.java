package com.ums.medcarepages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ums.utilities.Loggers;
import com.ums.utilities.ReadExcelHashMap;

public class MedcareLoginPage 
{
	//public WebDriver driver;
	public WebDriver driver;
	
	public static Logger log = Logger.getLogger(Loggers.class.getName());
	
		// LoginPage Username Textfield element
		@FindBy(how = How.XPATH, using = "//input[@data-automation-attribute='text-passcode']")
		private WebElement User_Login;
		
		// Constructor for LoginPage
		public MedcareLoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver = driver;
		}
			
		
		public void loginSuperUser() throws Exception, InterruptedException
		{
			String Super_User = ReadExcelHashMap.getValue("SuperUser");
			log.info("Logging User : "+Super_User);
			User_Login.sendKeys(Super_User);
			//User_Login.sendKeys(Keys.RETURN);	
			
		}
		
		public void loginFrontEndUser() throws Exception, InterruptedException
		{
			String FrontEnd_User = ReadExcelHashMap.getValue("FrontEnd");
			log.info("Logging User : "+FrontEnd_User);
			User_Login.sendKeys(FrontEnd_User);
		}
		
		
}
