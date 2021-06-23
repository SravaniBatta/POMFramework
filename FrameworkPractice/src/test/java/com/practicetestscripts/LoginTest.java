package com.practicetestscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.practicepages.BaseClass;
import com.practicepages.LoginPage;
import com.practiceutilities.BrowsersFactory;

public class LoginTest extends BaseClass{

	@Test
	public void loginApplication() throws InterruptedException {
		
		logger=report.createTest("Login to FreeCRM");
		
		LoginPage page=PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Login to the application");
		
		page.loginToCRM(excel.getStringData("Login", 0, 0),excel.getStringData("Login", 0, 1));
		
		logger.pass("Successfully logged in to the Free CRM");
	
	}

}
