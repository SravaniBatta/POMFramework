package com.practicepages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.practiceutilities.BrowsersFactory;
import com.practiceutilities.ConfigDataProvider;
import com.practiceutilities.ExcelDataProvider;
import com.practiceutilities.Helper;

public class BaseClass {
	
	public WebDriver driver;
	
	public ExcelDataProvider excel;
	
	public ConfigDataProvider config;
	
	public ExtentReports report;
	
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite() {
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/FreeCRM_"+Helper.dateTimeStamp()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeClass
	
	public void setupApp() {
		
		driver=BrowsersFactory.startApplication(driver, config.getBrowser(), config.getQaUrl());
		
	}
	
	@AfterClass
	public void tearDown() {
		
		BrowsersFactory.quitBrowser(driver);
		
	}
	
	@AfterMethod
	public void tearDownmethod(ITestResult result) {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			
			try {
				logger.fail("TestCase Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (Exception  e) {
				// TODO Auto-generated catch block
				System.out.println("Screenshot not found" +e.getMessage());
			}
			
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {

			try {
				logger.pass("TestCase Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			} catch (Exception  e) {
				// TODO Auto-generated catch block
				System.out.println("Screenshot not found" +e.getMessage());
			}
			
		}
		report.flush();
	}

}
