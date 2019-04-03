package com.medcare.TestScripts;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ums.medcarepages.MedcareDashboardPage;
import com.ums.medcarepages.MedcareEncounterPage;
import com.ums.medcarepages.MedcareLoginPage;
import com.ums.utilities.BrowserFactory;
import com.ums.utilities.Loggers;
import com.ums.utilities.configReader;

/**
 * 
 * @author Akshay
 *
 */
public class MedCareEncounterCreator {
	WebDriver driver;
	configReader configreader = new configReader(); 
	public static Logger log = Logger.getLogger(Loggers.class.getName());
		
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
	
	@Test(description="Create Encounter by searching patient")
	public void CreateEncounter() throws Exception
	{
		final MedcareDashboardPage DashBoard = new MedcareDashboardPage(driver);
		DashBoard.clickOnOPD();
		final MedcareEncounterPage EncounterPage = new MedcareEncounterPage(driver);
		EncounterPage.EncounterTabSearchPatient();
		EncounterPage.EncounterTabDetails();
		EncounterPage.EncounterNextKin();
		EncounterPage.EncounterPaymentEntitlementSelf();
	}

}
