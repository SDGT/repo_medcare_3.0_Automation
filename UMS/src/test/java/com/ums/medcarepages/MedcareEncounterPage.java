package com.ums.medcarepages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ums.utilities.CoreClasses;
import com.ums.utilities.Loggers;
import com.ums.utilities.ReadExcelHashMap;

public class MedcareEncounterPage{
	public WebDriver driver;
	public static Logger log = Logger.getLogger(Loggers.class.getName());
		
	MedcareLoginPage LoginPage = new MedcareLoginPage(driver);
	CoreClasses core = new CoreClasses(driver);
	
	public MedcareEncounterPage(WebDriver driver) 
	{
	PageFactory.initElements(driver, this);
	this.driver=driver;
	}
	
	//MRN Number in Encounter Screen
	@FindBy(how=How.XPATH, using = "//mat-cell[@class='headerMRN mat-cell cdk-column-MRN mat-column-MRN ng-star-inserted']")
	public WebElement SearchedMRNNo;
	
	//Clicking on Icon button
	@FindBy(how=How.XPATH, using = "//i[@class='material-icons md-18 white iconMaterial']")
	public WebElement IconClick;
	
	//Clicking on Encounter tab
	@FindBy(how=How.XPATH, using = "(//span[contains(text(),'Encounter')])[1]")
	public WebElement EncounterTab;
		
	//Clicking on Search Button
	@FindBy(how=How.XPATH, using = "//input[@placeholder='Search']")
	public WebElement txt_Search_top;
	
	//Sending MRN details
	@FindBy(how=How.XPATH, using = "//input[@placeholder='Patient MRN']")
	public WebElement txt_Mrn;
	
	//Entering search details
	@FindBy(how = How.XPATH, using = "(//input[@placeholder='Search'])[2]")
	public WebElement txt_srch;
	
	//EncounterType
	@FindBy(how=How.XPATH, using="//mat-select[@formcontrolname='encounterType']")
	public WebElement EncounterTypes;
	
	//Department
	@FindBy(how=How.XPATH, using="//mat-select[@formcontrolname='departement']")
	public WebElement Department;
	
	//Room
	@FindBy(how=How.XPATH, using="//mat-select[@formcontrolname='clinic']")
	public WebElement Room;
	
	//Source
	@FindBy(how=How.XPATH, using="//mat-select[@formcontrolname='Source']")
	public WebElement Source;
	
	//Doctor
	@FindBy(how=How.XPATH, using="//mat-select[@formcontrolname='Doctor']")
	public WebElement Doctor;
	
	//WorkAroundForDoctor
	@FindBy(how=How.XPATH, using="//span[contains(text(),' Dr Teuh Yoke Sim (MD) ')]")
	public WebElement WorkAroundForDoctor;
		
	//Referral Type
	@FindBy(how=How.XPATH, using="//mat-select[@formcontrolname='referralType']")
	public WebElement ReferralType;
	
	//NextEncounterTab
	@FindBy(how=How.XPATH, using="//mat-icon[contains(text(),'keyboard_arrow_right')]")
	public WebElement NextEncounterTab;
	
	//NextOfKin
	@FindBy(how=How.XPATH, using="//div[contains(text(),'Please Add Next of Kin')]")
	public WebElement NextOfKin;
		
	//PrefixKin
	@FindBy(how=How.XPATH, using="//mat-select[@formcontrolname='kinPrefix']")
	public WebElement PrefixKin;
	
	
	//kinName
	@FindBy(how=How.XPATH, using="//input[@formcontrolname='kinName']")
	public WebElement kinName;
	
	//kinIDType
	@FindBy(how=How.XPATH, using="//mat-select[@formcontrolname='kinIDType']")
	public WebElement kinIDType;
	
	//kinIDDesc
	@FindBy(how=How.XPATH, using="//input[@formcontrolname='kinIDDesc']")
	public WebElement kinIDDesc;
	
	
	//kinRelation
	@FindBy(how=How.XPATH, using="//mat-select[@formcontrolname='kinRelation']")
	public WebElement kinRelation;
	
	//Kinmobile
	@FindBy(how=How.XPATH, using="//input[@formcontrolname='Kinmobile']")
	public WebElement Kinmobile;
	
	//kindAdress
	@FindBy(how=How.XPATH, using="//input[@formcontrolname='kindAdress']")
	public WebElement kindAdress;
	
	//kinCountry
	@FindBy(how=How.XPATH, using="//mat-select[@formcontrolname='kinCountry']")
	public WebElement kinCountry;
	
	//kinState
	@FindBy(how=How.XPATH, using="//mat-select[@formcontrolname='kinState']")
	public WebElement kinState;
	
	//kinCity
	@FindBy(how=How.XPATH, using="//mat-select[@formcontrolname='kinCity']")
	public WebElement kinCity;
	
	//kinPincode
	@FindBy(how=How.XPATH, using="//input[@formcontrolname='kinPincode']")
	public WebElement kinPincode;
	
	//Add button
	@FindBy(how=How.XPATH, using="//mat-icon[@mattooltip='Add new kin']")
	public WebElement btnAdd;
	
	//Payment Entitlement
	@FindBy(how=How.XPATH, using="//mat-icon[@mattooltip='Save']")
	public WebElement btnSave;
	
	public void WebWait(WebElement ExplicitWait)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(ExplicitWait));
	}
	
	public void SelectValuedropDown(String dropdownValue)
	{
		txt_srch.click();
		WebWait(txt_srch);
		log.info(dropdownValue);
		txt_srch.sendKeys(dropdownValue);
		WebWait(txt_srch);
		txt_srch.sendKeys(Keys.RETURN);	
	}	
		
	public void EncounterTab() throws Exception
	{
		LoginPage.waitForPageLoadComplete(driver, 5);
		//Click on Encounter Tab
		Thread.sleep(5000);
		WebWait(EncounterTab);
		EncounterTab.click();
		
		//Url for comparison
		String ActualEncounterUrl = "http://medcareqa.sdglobaltech.com:4300/#/OPD/encounter";
		String ExpectedEncounterUrl = driver.getCurrentUrl();
		CoreClasses.CompareString(ActualEncounterUrl, ExpectedEncounterUrl);
		
		//Click on TextSearch Button from Search Field
		WebWait(txt_Search_top);
		txt_Search_top.click();
		Thread.sleep(2000); //Application slowness
		WebWait(txt_Mrn);
		txt_Mrn.click();
		
		
		//Type In the MRN Number for encounter creation	
		String MrnNo = ReadExcelHashMap.getValue("MrnNumber");
		txt_Mrn.sendKeys(MrnNo);
		
		log.info(MrnNo);
		
		//Press Enter
		Thread.sleep(2000); //Application slowness
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		
		
		//Click on Searched Mrn Number
		SearchedMRNNo.click();
		CoreClasses.CompareText(SearchedMRNNo, MrnNo);
		IconClick.click();
		
		//Select the Encounter Type
		WebWait(EncounterTypes);
		EncounterTypes.click();
		String EncounterType = ReadExcelHashMap.getValue("EncounterType");
		SelectValuedropDown(EncounterType);
		
		//Select the department
		WebWait(Department);
		Department.click();
		String Department = ReadExcelHashMap.getValue("Department");
		SelectValuedropDown(Department);
		
		//Select the clinic
		WebWait(Room);
		Room.click();
		String Room = ReadExcelHashMap.getValue("Room");
		SelectValuedropDown(Room);
		
		//Select the Source
		WebWait(Source);
		Source.click();
		String Source = ReadExcelHashMap.getValue("Source");
		SelectValuedropDown(Source);
		
		//Select the Doctor - Search button is not there
		WebWait(Doctor);
		Doctor.click();
		/*String Doctor = ReadExcelHashMap.getValue("Doctor");
		SelectValuedropDown(Doctor);*/
		WebWait(WorkAroundForDoctor);		
		WorkAroundForDoctor.click();		
		
		//Select the ReferralType
		WebWait(ReferralType);
		ReferralType.click();
		String ReferralType = ReadExcelHashMap.getValue("ReferralType");
		SelectValuedropDown(ReferralType);
		
		//Click on Next button after 
		core.SelectConfirmButton(NextEncounterTab);	
	}

	public void EncounterNextKin() throws Exception {
		
		//NEXT OF KIN DETAILS
		String nxtOfKin = NextOfKin.getText();
		log.info(nxtOfKin);
		
		//Select the prefix
		WebWait(PrefixKin);
		PrefixKin.click();
		String PrefixKin = ReadExcelHashMap.getValue("PrefixKin");
		SelectValuedropDown(PrefixKin);
		
		//Enter the Kin Name
		kinName.sendKeys(core.RandomStringGeneration());
		
		//Enter the kinIDType
		WebWait(kinIDType);
		kinIDType.click();
		String kinIDType = ReadExcelHashMap.getValue("kinIDType");
		SelectValuedropDown(kinIDType);
		
		//Enter kinIDDesc
		kinIDDesc.sendKeys(core.RandomDigitsIdentificationType());
		log.info(core.RandomDigitsIdentificationType());
		
		//Enter the Kin Relation
		WebWait(kinRelation);
		kinRelation.click();
		String kinRelation = ReadExcelHashMap.getValue("kinRelation");
		SelectValuedropDown(kinRelation);
		
		//Enter Mobile Number
		Kinmobile.sendKeys(core.RandomDigitsMobileNumber());
		log.info(core.RandomDigitsMobileNumber());
		
		//Enter Kin Address
		WebWait(kindAdress);
		kindAdress.click();
		String kindAdres = ReadExcelHashMap.getValue("kindAdress");
		kindAdress.sendKeys(kindAdres);
		
		//Enter Kin Country
		WebWait(kinCountry);
		kinCountry.click();
		String kinCountry = ReadExcelHashMap.getValue("kinCountry");
		SelectValuedropDown(kinCountry);
		
		//Enter Kin State
		WebWait(kinState);
		kinState.click();
		String kinStates = ReadExcelHashMap.getValue("kinState");
		SelectValuedropDown(kinStates);
		
		//Enter Kin City
		WebWait(kinCity);
		kinCity.click();
		String kinCity = ReadExcelHashMap.getValue("kinCity");
		SelectValuedropDown(kinCity);
		
		//Enter Kin PostCode
		WebWait(kinPincode);
		kinPincode.click();
		String kinPincode = ReadExcelHashMap.getValue("kinPincode");
		kinState.sendKeys(kinPincode);
		
		//Add Button
		btnAdd.click();
		
		//Click on Next button after 
		core.SelectConfirmButton(NextEncounterTab);	
	}

	public void EncounterPaymentEntitlementSelf() 
	{
		btnSave.click();
		
	}

	public void EncounterPaymentEntitlementTPP() 
	{
	
		
	}	
	
}
