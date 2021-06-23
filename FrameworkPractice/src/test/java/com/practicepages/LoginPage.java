package com.practicepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver) {
		
		this.driver=ldriver;
		
	}
	//Adding new comment
	@FindBy(xpath="//span[text()='Log In']") WebElement Loginbtn;
	
	@FindBy(name="email") WebElement Uname;
	
	@FindBy(name="password") WebElement Pwd;
	
	public void loginToCRM(String Username,String Password) throws InterruptedException {
		
		Loginbtn.click();
		Thread.sleep(3000);
		Uname.sendKeys(Username);
		Thread.sleep(3000);
		Pwd.sendKeys(Password);

	}
	
	
	
	
}
