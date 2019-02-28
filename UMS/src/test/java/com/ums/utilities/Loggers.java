package com.ums.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.BeforeMethod;




public class Loggers 
{
	public static Logger log=Logger.getLogger(Loggers.class.getName());
	
	//info
	//error
	//warning
	//fatal
	@BeforeMethod
	public Logger settingLoggers()
	{
		//DOMConfigurator.configure("log4j.xml");
		PropertyConfigurator.configure("log4j.properties");
			return log;
	}
}
