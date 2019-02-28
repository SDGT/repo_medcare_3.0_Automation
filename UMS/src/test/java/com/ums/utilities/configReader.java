package com.ums.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class configReader {
	
	Properties pro;
	static WebDriver driver;
	public configReader() throws NullPointerException
	{		
        try {
			File src = new File("./Configuration/Config.properties");			
			FileInputStream fis = new FileInputStream(src);			
			pro = new Properties();			
			pro.load(fis);			
		} catch (Exception e) {
			System.out.println("Exception is ===== "+e.getMessage());
		}				
	}
	
	public String getmedcare3url()
	{	
	String url = pro.getProperty("medcare3url");
	return url;	  
	}

	public String getPasscode()
	{	
	String password = pro.getProperty("passcode");
	return password;
	}
	

	public String getBrowsername()
	{	
		String browser= pro.getProperty("browser");
		return browser;	   
	}
	
	public String getChromePath()
	{	
		String path= pro.getProperty("ChromeDriver");
		return path;	   
	}
	
	
	public String getversionreleased()
	{	
		String path= pro.getProperty("versionreleased");
		return path;	   
	}
	
	
	
	public String getclinicareproducttesturl()
	{	
		String url = pro.getProperty("clinicareproducttesturl");
		return url;	   
	}
	
	public String getclinicianURL()
	{	
		String url = pro.getProperty("clinicianurl");
		return url;	   
	}
		
	public String getradiologistURL()
	{	
		String url = pro.getProperty("radiologisturl");
		return url;	   
	}	
	
	
	public String getcvhisURL()
	{	
		String url = pro.getProperty("cvhisurl");
		return url;	   
	}	
	
	
	public String getUsername()
	{		
		String username = pro.getProperty("username");
		return username;
	}
	public String getPassword()
	{		
		String password = pro.getProperty("password");
		return password;
	}
	
	public String getUnit()
	{		
		String unit = pro.getProperty("unit");
		return unit;
	}
	
	public String getMRNtoSearch()
	{		
		String mrn = pro.getProperty("MRN");
		return mrn;
	}
	public String getMED_Name()
	{		
		String MED_Name = pro.getProperty("M_Name");
		return MED_Name;
	}
	public String getMED_Frequency()
	{		
		String MED_Frequency = pro.getProperty("M_Frequency");
		return MED_Frequency;
	}
	public String getTemperatureValue()
	{		
		String TemperatureValue = pro.getProperty("TemperatureValue");
		return TemperatureValue;
	}
	public String getTemperatureQualifier()
	{		
		String TemperatureQualifier = pro.getProperty("TemperatureQualifier");
		return TemperatureQualifier;
	}
	public String getTemperatureComment()
	{		
		String TemperatureComment = pro.getProperty("TemperatureComment");
		return TemperatureComment;
	}
	public String getPulseValue()
	{		
		String PulseValue = pro.getProperty("PulseValue");
		return PulseValue;
	}
	public String getPulseQualifier()
	{		
		String PulseQualifier = pro.getProperty("PulseQualifier");
		return PulseQualifier;
	}
	public String getPulseComment()
	{		
		String PulseComment = pro.getProperty("PulseComment");
		return PulseComment;
	}
	public String getHeightValue()
	{		
		String HeightValue = pro.getProperty("HeightValue");
		return HeightValue;
	}
	public String getHeightComment()
	{		
		String HeightComment = pro.getProperty("HeightComment");
		return HeightComment;
	}
	public String getWeightValue()
	{		
		String WeightValue = pro.getProperty("WeightValue");
		return WeightValue;
	}
	public String getWeightComment()
	{		
		String WeightComment = pro.getProperty("WeightComment");
		return WeightComment;
	}
	public String getPainScoreValue()
	{		
		String PainScoreValue = pro.getProperty("PainScoreValue");
		return PainScoreValue;
	}
	public String getPainScoreComment()
	{		
		String PainScoreComment = pro.getProperty("PainScoreComment");
		return PainScoreComment;
	}
	public String getPulseOximetryValue()
	{		
		String PulseOximetryValue = pro.getProperty("PulseOximetryValue");
		return PulseOximetryValue;
	}
	public String getPulseOximetryComment()
	{		
		String PulseOximetryComment = pro.getProperty("PulseOximetryComment");
		return PulseOximetryComment;
	}
	
	public String getBloodPressureComment()
	{		
		String BloodPressureComment = pro.getProperty("BloodPressureComment");
		return BloodPressureComment;
	}
	public String getDiastolicQualifier()
	{		
		String DiastolicQualifier = pro.getProperty("DiastolicQualifier");
		return DiastolicQualifier;
	}
	public String getSystolicQualifier()
	{		
		String SystolicQualifier = pro.getProperty("SystolicQualifier");
		return SystolicQualifier;
	}
	public String getDiastolicValue()
	{		
		String DiastolicValue = pro.getProperty("DiastolicValue");
		return DiastolicValue;
	}
	public String getSystolicValue()
	{		
		String SystolicValue = pro.getProperty("SystolicValue");
		return SystolicValue;
	}
	
	public String getMED_ElectronicSignature()
	{		
		String MED_Electronic_Signature = pro.getProperty("Electronic_Signature");
		return MED_Electronic_Signature;
	}
	
	public String getNametoSearch()
	{		
		String name = pro.getProperty("NAME");
		return name;
	}
	
	
	public String getPostComment() {
		String comment = pro.getProperty("postComment");
		return comment;
	}
	
	public String getRVValue() {
		String RVValue = pro.getProperty("RVValue");
		return RVValue;
	}
		
	public String getLVValue() {
		String LVValue = pro.getProperty("LVValue");
		return LVValue;
	}
		
	public String getRVPHValue() {
		String RVPHValue = pro.getProperty("RVPHValue");
		return RVPHValue;
	}
		
	public String getLVPHValue() {
		String LVPHValue = pro.getProperty("LVPHValue");
		return LVPHValue;
	}
		
	public String getRVQualifier() {
		String RVQualifier = pro.getProperty("RVQualifier");
		return RVQualifier;
	}
		
	public String getLVQualifier() {
		String LVQualifier = pro.getProperty("LVQualifier");
		return LVQualifier;
	}
		
	public String getVisualAcuityComment() {
		String VisualAcuityComment = pro.getProperty("VisualAcuityComment");
		return VisualAcuityComment;
	}
		
			
	/*public static void main(String args[]) {
	
		configReader cr = new configReader(); 
		System.out.println(cr.getChromePath());
		System.out.println(cr.getclinicianURL());
		System.out.println(cr.getradiologistURL());
		System.out.println(cr.getUsername());
		System.out.println(cr.getPassword());
		
	}*/
	
}
