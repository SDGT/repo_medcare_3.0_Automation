package com.ums.medcarepages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.apache.log4j.Logger;
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

public class MedCareOPBillingPage {
	
	public WebDriver driver;
	public static Logger log = Logger.getLogger(Loggers.class.getName());
	CoreClasses core = new CoreClasses(driver);
	
	// Constructor for LoginPage
	public MedCareOPBillingPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver = driver;
			}
			
	//OP Billing Tab
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Billing')]")
	public WebElement btnOPBillingGrid;
	
	//Bill
	@FindBy(how=How.XPATH, using="//i[@class='menu-caret icon icon-arrows-right']//ancestor::a//span[contains(text(),'Bill')]")
	public WebElement btnBill;
	
	//OutPatientBill
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Out Patient Bill')]")
	public WebElement btnOutPatientBill;
	
	//Clicking on Search Button
	@FindBy(how=How.XPATH, using = "//input[@placeholder='Search']")
	public WebElement txt_Search_top;
	
	//Sending MRN details
	@FindBy(how=How.XPATH, using = "//input[@placeholder='Patient MRN']")
	public WebElement txt_Mrn;
	
	//Click on Searched patient
	@FindBy(how=How.XPATH, using = "//div[@class='mat-radio-outer-circle']")
	public WebElement btnRadioMRN;
	
	//Warning msg
	@FindBy(how=How.XPATH, using = "//span[@class='mat-button-wrapper']")
	public WebElement warningMessage;
	
	//Add button in OP bill Screen
	@FindBy(how=How.XPATH, using = "//mat-icon[contains(text(),'add')]")
	public WebElement btnAddOPBill;
	
	//Add an Service
	@FindBy(how=How.XPATH, using = "//input[@data-automation-attribute='text-service-name']")
	public WebElement btnAddServiceName;
	
	//Click on Confirm button
	@FindBy(how=How.XPATH, using="(//mat-icon[@mattooltip='Search'])[2]")
	public WebElement btnSearch;
	
	//Add Quantity
	@FindBy(how=How.XPATH, using="//input[@formcontrolname='quantity']")
	public WebElement btnAddQuantityDetails;
		
	//btnAddServiceDetails
	@FindBy(how=How.XPATH, using="(//mat-icon[@data-automation-attribute='icon-add'])[1]")
	public WebElement btnAddServiceDetailsTop;
	
	//btnAddServiceDetails
	@FindBy(how=How.XPATH, using="(//mat-icon[@data-automation-attribute='icon-add'])[2]")
	public WebElement btnAddServiceDetailsBottom;
	
	//Final Bill
	@FindBy(how=How.XPATH, using="//mat-checkbox[@data-automation-attribute='chk-final-bill']")
	public WebElement btnFinalBill;
	
	//Click on Save OPD 
	@FindBy(how=How.XPATH, using="//mat-icon[@mattooltip='Save']")
	public WebElement btnFinalBillSave;
	
	//Click on Confirm Button
	@FindBy(how=How.XPATH, using="//mat-icon[@mattooltip='Yes']")
	public WebElement btnFinalBillConfirmYes;
	
	//Click on btnAddIconPaymentDetail
	@FindBy(how=How.XPATH, using="//mat-icon[@data-automation-attribute='icon-add']")
	public WebElement btnAddIconPaymentDetail;
	
	//Click on btnAddIconPaymentDetail
	@FindBy(how=How.XPATH, using="(//mat-icon[@mattooltip='Save'])[2]")
	public WebElement btnSavePaymentDetail;
	
	
	public void WebWait(WebElement ExplicitWait)
	{
		WebDriverWait wait = new WebDriverWait(driver, 18);
		wait.until(ExpectedConditions.elementToBeClickable(ExplicitWait));
	}
	
	public void OutPatientBillingCreation() throws Exception
	{
		core.waitForPageLoadComplete(driver, 15);
		
		//Click on OP Billing Grid
		WebWait(btnOPBillingGrid);
		btnOPBillingGrid.click();
		
		
		//Click on OP Bill Left screen
		Thread.sleep(2000);
		WebWait(btnBill);
		btnBill.click();
		
		//Click on OP Bill Tab
		WebWait(btnOutPatientBill);
		btnOutPatientBill.click();
		
		//Select and type mrn
		core.SearchPatientMRN(txt_Search_top, txt_Mrn);
		
		
		//Type In the MRN Number for encounter creation	
		String MrnNo = ReadExcelHashMap.getValue("MrnNumberOP");
		txt_Mrn.sendKeys(MrnNo);
		log.info(MrnNo);
				
		//Press Enter
		Thread.sleep(2000); //Application slowness
		btnSearch.click();
		
		
		//Radio Button of mrn
		WebWait(btnRadioMRN);
		btnRadioMRN.click();
		
		if(warningMessage.isDisplayed())
		{		
			String WarningMessage = warningMessage.getText();
			log.error(WarningMessage);
		}
		else
		{
			Thread.sleep(3000);
			WebWait(btnAddOPBill);
			btnAddOPBill.click(); // clicks on Add button
			
			Thread.sleep(3000);		
			WebWait(btnAddServiceName);
			btnAddServiceName.sendKeys(ReadExcelHashMap.getValue("AddServices"));//Adding the services in Service Details screen
				
			Robot rb = new Robot();
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyPress(KeyEvent.VK_ENTER);
			
			btnAddQuantityDetails.clear();
			btnAddQuantityDetails.sendKeys(ReadExcelHashMap.getValue("Quantity")); //Adding the Quantity in Service Details screen
		
			btnAddServiceDetailsTop.click(); // click on add button
			
			
			btnAddServiceDetailsBottom.click(); // Click on add button Below
			
			btnFinalBill.click(); // Click on Final Bill
			
			WebWait(btnFinalBillSave);
			Thread.sleep(2000);
			btnFinalBillSave.click(); // Click on Final bill Save Button
			
			
			Thread.sleep(2000);
			btnAddIconPaymentDetail.click(); //click on Icon Payment Detail
			
			btnSavePaymentDetail.click(); // Save Button in Payment details

			
			
			btnFinalBillConfirmYes.click(); //Confirm Button
			
		}
		
	}
	
	
}

