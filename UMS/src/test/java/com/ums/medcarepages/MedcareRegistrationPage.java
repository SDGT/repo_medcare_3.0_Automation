package com.ums.medcarepages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
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

public class MedcareRegistrationPage{
		
	WebDriver driver;
	public static Logger log = Logger.getLogger(Loggers.class.getName());
	CoreClasses core = new CoreClasses(driver);
		
		//Fetching the unit details
		@FindBy(how = How.XPATH, using = "//span[@class='span-unit']")
		public WebElement txtPuUnit;
	
		//Fetching the unit details
		@FindBy(how = How.XPATH, using = "//span[contains(text(),'Identification Type')]")
		public WebElement btnIdentificationType;
	
		//Entering search details
		@FindBy(how = How.XPATH, using = "(//input[@placeholder='Search'])[2]")
		public WebElement txtsrch;
		
		//Identification Number
		@FindBy(how = How.XPATH, using = "//input[@data-automation-attribute='txtPrimaryIDDesc']")
		public WebElement btnIdentificationNumber;
		
		//Title
		@FindBy(how = How.XPATH, using = "//span[contains(text(),'Title')]")
		public WebElement btnTitle;
		
		//First Name
		@FindBy(how = How.XPATH, using = "//input[@data-automation-attribute='txtFirstName']")
		public WebElement txtFirstName;
				
		//Race
		@FindBy(how = How.XPATH, using = "//span[contains(text(),'Race')]")
		public WebElement txtRace;
						
		//Selecting Martial Status
		@FindBy(how = How.XPATH, using = "//span[contains(text(),'Marital Status')]")
		public WebElement txt_MaritalStatus;
		
		//Selecting Occupation
		@FindBy(how = How.XPATH, using = "//span[contains(text(),'Occupation')]")
		public WebElement txt_Occupation;
		
		//Selecting Patient_Category
		@FindBy(how = How.XPATH, using = "//span[contains(text(),'Patient Category')]")
		public WebElement txt_Patient_Category;
		
		//Selecting Religion
		@FindBy(how = How.XPATH, using = "//span[contains(text(),'Religion')]")
		public WebElement txt_Religion;
		
		//Input Address
		@FindBy(how = How.XPATH, using = "//input[@data-automation-attribute='txtAddress']")
		public WebElement txt_Address;
		
		//Country
		@FindBy(how = How.XPATH, using = "//span[@class='mat-select-placeholder ng-tns-c17-42 ng-star-inserted']")
		public WebElement txt_Country;
		
		//State
		@FindBy(how = How.XPATH, using = "//span[@class='mat-select-placeholder ng-tns-c17-44 ng-star-inserted']")
		public WebElement txt_state;

		//City
		@FindBy(how = How.XPATH, using = "//span[@class='mat-select-placeholder ng-tns-c17-46 ng-star-inserted']")
		public WebElement txt_City;
		
		//Postcode
		@FindBy(how = How.XPATH, using = "//input[@data-automation-attribute='txtPincode']")
		public WebElement txt_postcode;
		
		//Mobile No
		@FindBy(how = How.XPATH, using = "//input[@data-automation-attribute='registration-form-localcontact']")
		public WebElement txt_MobileNo;
		
		//SaveButton
		@FindBy(how = How.XPATH, using = "//button[@data-automation-attribute='btnSave']")
		public WebElement txt_Save;
		
		//ConfirmButton
		@FindBy(how = How.XPATH, using = "//mat-icon[contains(text(),'done')]")
		public WebElement btn_Confirm;
		
		//Registration Sucess
		@FindBy(how = How.XPATH, using = "//h6[@class='modal-title']")
		public WebElement txt_RegSuccess;
		
		//MRN Number
		@FindBy(how = How.XPATH, using = "//h6[@class='modal-title']//ancestor::div[1]//following-sibling::div[1]//b")
		public WebElement MRN_No;
		
		//Encounter Yes
		@FindBy(how = How.XPATH, using = "//button[@data-automation-attribute='button-yes']")
		public WebElement MRNContinueYes;
		
		//Encounter Yes
		@FindBy(how = How.XPATH, using = "//button[@data-automation-attribute='button-No']")
		public WebElement MRNContinueNo;
		
	public MedcareRegistrationPage(WebDriver driver) 
	{
	PageFactory.initElements(driver, this);
	this.driver = driver;
	}
	
	public void fetchingUnitName() throws Exception
	{
		Thread.sleep(8000);
		String UnitName = txtPuUnit.getText();
		log.info(UnitName);
	}
	
	
		
	public void SelectValuedropDown(String dropdownValue) throws Exception
	{
		txtsrch.click();
		WebWait(txtsrch);
		log.info(dropdownValue);
		Thread.sleep(1000);
		txtsrch.sendKeys(dropdownValue);
		WebWait(txtsrch);
		txtsrch.sendKeys(Keys.ARROW_DOWN);
		txtsrch.sendKeys(Keys.RETURN);	
	}
	
	
	public void WebWait(WebElement ExplicitWait)
	{
		WebDriverWait wait = new WebDriverWait(driver, 18);
		wait.until(ExpectedConditions.elementToBeClickable(ExplicitWait));
	}

	public void BasicInformation() throws Exception
	{
		core.waitForPageLoadComplete(driver, 15);
		//Selecting Identifcation Type
		WebWait(btnIdentificationType);
		btnIdentificationType.click();
		String ValueNRIC= ReadExcelHashMap.getValue("NRICValue");
		SelectValuedropDown(ValueNRIC);
		
		//RandomIdentificationNumberType
		btnIdentificationNumber.sendKeys(core.RandomDigitsIdentificationType());
		
		//Title
		WebWait(btnTitle);
		btnTitle.click();
		String Title= ReadExcelHashMap.getValue("TitleValue");
		SelectValuedropDown(Title);
		
		//FirstName generation
		txtFirstName.sendKeys(core.RandomStringGeneration());
		
		//Selecting Race Value
		WebWait(txtRace);
		txtRace.click();
		String Race = ReadExcelHashMap.getValue("RaceValue");
		SelectValuedropDown(Race);
		
		//Selecting Marital Status
		WebWait(txt_MaritalStatus);
		txt_MaritalStatus.click();
		String MaritalStatus = ReadExcelHashMap.getValue("MaritalStatus");
		SelectValuedropDown(MaritalStatus);
		
		//Selecting Occupation
		WebWait(txt_Occupation);
		txt_Occupation.click();
		String Occupation = ReadExcelHashMap.getValue("OccupationValue");
		SelectValuedropDown(Occupation);
		
		//Selecting Patient_Category
		WebWait(txt_Patient_Category);
		txt_Patient_Category.click();
		String Patient_Category = ReadExcelHashMap.getValue("PatientCategory");
		SelectValuedropDown(Patient_Category);
		
		
		//Selecting Patient_Category
		WebWait(txt_Religion);
		txt_Religion.click();
		String Religion = ReadExcelHashMap.getValue("Religion");
		SelectValuedropDown(Religion);
		
		
		//Scroll down
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
				
		//Address
		Thread.sleep(1000);
		WebWait(txt_Address);
		txt_Address.click();
		String Address = ReadExcelHashMap.getValue("Address");
		log.info(Address);
		txt_Address.sendKeys(Address);
		
		//Country
		WebWait(txt_Country);
		txt_Country.click();
		String Country = ReadExcelHashMap.getValue("Country");
		SelectValuedropDown(Country);
		
		
		//State
		WebWait(txt_state);
		txt_state.click();
		String State = ReadExcelHashMap.getValue("State");
		SelectValuedropDown(State);
		
		//city
		WebWait(txt_City);
		txt_City.click();
		String city = ReadExcelHashMap.getValue("City");
		SelectValuedropDown(city);
		
		//postcode
		txt_postcode.click();
		String postCode = ReadExcelHashMap.getValue("PostCode");
		txt_postcode.sendKeys(postCode);
		
		//postcode
		txt_MobileNo.click();
		String MobileNo = ReadExcelHashMap.getValue("MobileNo");
		log.info(MobileNo);
		txt_MobileNo.sendKeys(MobileNo);
		
		//SaveButton
		core.SelectConfirmButton(txt_Save);
		
		//ConfirmButton
		core.SelectConfirmButton(btn_Confirm);		
		
		RegSucessMessage();
	}
		
	public String RegSucessMessage()
	{
		String SuccessMessage = txt_RegSuccess.getText();
		log.info(SuccessMessage);
		String MrnNumber = MRN_No.getText();
		log.info(MrnNumber);
		return MrnNumber;
	}
	
	public void MrnContinueYes() throws Exception {
		WebWait(MRNContinueYes);
		MRNContinueYes.click();
		String winHandleBefore = driver.getWindowHandle();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		Thread.sleep(5000);
		driver.switchTo().window(tabs.get(1));
		driver.close();
		driver.switchTo().window(winHandleBefore);
		Thread.sleep(5000);
		isAlertPresent();
	}
	public boolean isAlertPresent(){
	    boolean foundAlert = false;
	    WebDriverWait wait = new WebDriverWait(driver,10);
	    try {
	        wait.until(ExpectedConditions.alertIsPresent());
	        foundAlert = true;
	        Alert alt = driver.switchTo().alert();
	        alt.accept();
	    } catch (TimeoutException eTO) {
	        foundAlert = false;
	    }
	    return foundAlert;
	}
	
	public void MrnContinueNo() {
		MRNContinueNo.click();
	}
	
}

