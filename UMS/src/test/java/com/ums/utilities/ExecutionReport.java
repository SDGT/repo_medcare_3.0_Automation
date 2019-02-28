package com.ums.utilities;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.internal.TestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExecutionReport {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports reports;
	public static ExtentTest testInfo;
	public static TestResult result;

	configReader cr = new configReader();
	
	@BeforeTest
	public void createReportSetup() {
		
		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/MyOwnReport.html"));
		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir") + "/extent-config.xml"));
		reports = new ExtentReports();
		reports.setSystemInfo("Environment", cr.getclinicianURL());
		reports.setSystemInfo("Browser Used for Exeution",cr.getBrowsername());
		reports.attachReporter(htmlReporter);
		
		
	}

	@AfterMethod
	public void generateReportLog(ITestResult result) {
	
		if (result.getStatus() == ITestResult.SUCCESS) {
			testInfo.log(Status.PASS, "The test result for " + result.getName() + " -- Pass ");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			testInfo.log(Status.FAIL, "The test result for " + result.getName() + " -- Fail ");
			testInfo.log(Status.FAIL, "The test failure " + result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			testInfo.log(Status.SKIP, "The test is " + result.getName() + " -- Skipped");
		}
	}

	@BeforeMethod
	public void register(Method method) {
		String testName = method.getName();
		testInfo = reports.createTest(testName);
	}

	@AfterTest
	public void cleanup() {
		reports.flush();
	}
}