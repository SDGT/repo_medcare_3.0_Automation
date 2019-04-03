package com.ums.medcarepages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ums.utilities.Loggers;

public class MedcareDashboardPage {

	public WebDriver driver;
	public static Logger log = Logger.getLogger(Loggers.class.getName());
	
	
	//Clicking on Dashboard App button 
	@FindBy(how = How.XPATH, using = "//mat-icon[@mattooltip='Menu']")
	public WebElement btn_clickOnMenu;
	
	//Clicking on Dashboard App button 
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Out Patient Department')]")
	public WebElement btn_clickOnOPD;
	 		
	public MedcareDashboardPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}	
	
	public void WebWait(WebElement ExplicitWait)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(ExplicitWait));
	}
	
	public void clickOnAppButton() throws Exception
	{
		Thread.sleep(5000);
		WebWait(btn_clickOnMenu);
		String ActualTitlePage = driver.getCurrentUrl();
		log.info(ActualTitlePage);
		btn_clickOnMenu.click();
	}
	
	public void clickOnOPD() throws Exception
	{	
		WebWait(btn_clickOnOPD);
		btn_clickOnOPD.click();
	}
	
}
