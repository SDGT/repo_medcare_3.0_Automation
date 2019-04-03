package com.ums.utilities;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoreClasses{
	public WebDriver driver;
	
	public CoreClasses(WebDriver driver) 
	{
	PageFactory.initElements(driver, this);
	this.driver=driver;
	}
	
	//*********************Public WebElement**************
	public WebElement txt_Search_top;
	
	
	
	
	public static Logger log = Logger.getLogger(Loggers.class.getName());
	
	/**
	 * 
	 * @param ExplicitWait
	 */
	public void WebWait(WebElement ExplicitWait)
	{
		WebDriverWait wait = new WebDriverWait(driver, 18);
		wait.until(ExpectedConditions.elementToBeClickable(ExplicitWait));
	}
	
	/**
	 * 
	 * @param Actual
	 * @param mrnNo
	 */
	public static void CompareText(WebElement Actual,String mrnNo)
	{
		String ActualText = Actual.getText().trim();
		String ExpectedText = mrnNo;
		assertEquals(ActualText,ExpectedText);
	}
	
	
	/**
	 * 
	 * @param Actual
	 * @param Expected
	 */
	public static void CompareString(String Actual,String Expected)
	{
		assertEquals(Actual,Expected);
	}
	
	/**
	 * 
	 * @param ButtonConfirm
	 */
	public void SelectConfirmButton(WebElement ButtonConfirm)
	{
		Boolean Save = ButtonConfirm.isEnabled();
		if(Save==true)
		{
			ButtonConfirm.click();
			log.info("Button is Enabled and Clicked");
		}
		else
		{
			log.info("Button is not Enabled ");
		}
	}
	
	/**
	 * 
	 * @returns RandomString
	 */
	public String RandomStringGeneration()
	{
		String RandomName = RandomStringUtils.randomAlphabetic(3, 6);
		String LastFourAlpha = "Automation"+RandomName;
		return LastFourAlpha;
	}
	

	/**
	 * 
	 * @returns RandomNumber
	 */
	public String RandomDigitsIdentificationType()
	{
		Random RN = new Random();
		int LastSixDigits = RN.nextInt(9999999);
		int FirstSixDigits = 910803;
		String NRICValue = Integer.toString(FirstSixDigits) + Integer.toString(LastSixDigits);
		return NRICValue;
	}
	
	/**
	 * 
	 * @return MobileNumber
	 */
	public String RandomDigitsMobileNumber()
	{
		Random RN = new Random();
		int LastSixDigits = RN.nextInt(9999999);
		int FirstSixDigits = 997272;
		String NRICValue = Integer.toString(FirstSixDigits) + Integer.toString(LastSixDigits);
		return NRICValue;
	}
	
	/**
	 * 
	 * @return Switching tabs
	 * @throws Exception 
	 */
	public void SearchPatientMRN(WebElement txt_Search_top,WebElement txt_Mrn) throws Exception
	{
		Thread.sleep(2000); //Application slowness
		txt_Search_top.click();//Click on TextSearch Button from Search Field
		Thread.sleep(2000); //Application slowness
		txt_Mrn.click();	//Mrn Click		
	}
	
	
	
	/**
	 * 
	 * @param driver
	 * @param specifiedTimeout
	 */
	public void waitForPageLoadComplete(WebDriver driver, int specifiedTimeout) {
	    Wait<WebDriver> wait = new WebDriverWait(driver, 15);
	    wait.until(driver1 -> String
	            .valueOf(((JavascriptExecutor) driver1).executeScript("return document.readyState"))
	            .equals("complete"));
	}
	
}
