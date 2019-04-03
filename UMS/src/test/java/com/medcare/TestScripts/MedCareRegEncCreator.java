package com.medcare.TestScripts;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ums.medcarepages.MedcareDashboardPage;
import com.ums.medcarepages.MedcareEncounterPage;
import com.ums.medcarepages.MedcareLoginPage;
import com.ums.medcarepages.MedcareRegistrationPage;
import com.ums.utilities.BrowserFactory;
import com.ums.utilities.Loggers;
import com.ums.utilities.configReader;

public class MedCareRegEncCreator {
	
	WebDriver driver;
	configReader configreader = new configReader(); 
	public static Logger log = Logger.getLogger(Loggers.class.getName());
	
	@BeforeTest(description="Browser is being Launched after setting up installation and Login to medcare and click on Dashboard button")
    public void setUpDriver() throws Exception 
    {   			
		driver = BrowserFactory.startBrowser(configreader.getBrowsername());
		log.info("opened Browser");
		final MedcareLoginPage MedcareLoginPage = new MedcareLoginPage(driver);
		MedcareLoginPage.loginSuperUser();
		//MedcareLoginPage.loginFrontEndUser();
				
		final MedcareDashboardPage DashBoard = new MedcareDashboardPage(driver);
		DashBoard.clickOnAppButton();
    }
	
	@Test()
	public void RegistrationEncounterCreation() throws Exception
	{
		final MedcareDashboardPage DashBoard = new MedcareDashboardPage(driver);
		DashBoard.clickOnOPD();
		final MedcareRegistrationPage Registration = new MedcareRegistrationPage(driver);
		Registration.fetchingUnitName();	
		Registration.BasicInformation();
		Registration.MrnContinueYes();
		
		final MedcareEncounterPage EncounterPage = new MedcareEncounterPage(driver);
		EncounterPage.RegEncMerging();
		EncounterPage.EncounterTabDetails();
		EncounterPage.EncounterNextKin();
		EncounterPage.EncounterPaymentEntitlementSelf();		
	}
	
	
	
	

}
