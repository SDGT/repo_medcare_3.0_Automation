package com.medcare.TestScripts;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ums.medcarepages.MedCareOPBillingPage;
import com.ums.medcarepages.MedcareDashboardPage;
import com.ums.medcarepages.MedcareLoginPage;
import com.ums.utilities.BrowserFactory;
import com.ums.utilities.CoreClasses;
import com.ums.utilities.Loggers;
import com.ums.utilities.configReader;

public class MedCareOPBillingCreator {
	WebDriver driver;
	public static Logger log = Logger.getLogger(Loggers.class.getName());
	CoreClasses core = new CoreClasses(driver);
	configReader configreader = new configReader(); 
		
	@BeforeTest(description="Search patient and create encounter")
    public void setUpDriver() throws Exception 
    {   			
		driver = BrowserFactory.startBrowser(configreader.getBrowsername());
		log.info("opened Browser");
		final MedcareLoginPage MedcareLoginPage = new MedcareLoginPage(driver);
		MedcareLoginPage.loginSuperUser();
		
		final MedcareDashboardPage DashBoard = new MedcareDashboardPage(driver);
		DashBoard.clickOnAppButton();
	}
	
	@Test(description="Creating Final bill")
	public void OPBillCreator() throws Exception
	{
		MedCareOPBillingPage opBill = new MedCareOPBillingPage(driver);
		opBill.OutPatientBillingCreation();	
		
	}

}
