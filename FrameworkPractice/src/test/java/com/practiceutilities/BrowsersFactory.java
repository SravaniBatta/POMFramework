package com.practiceutilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowsersFactory {

	public static WebDriver startApplication(WebDriver driver,String browserName,String appUrl ) {

		if(browserName.equals("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "./BrowserDrivers/chromedriver.exe");

			driver=new ChromeDriver();

		}
		else if(browserName.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", "URL for driver.exe");

			driver=new ChromeDriver();

		}
		else if(browserName.equals("IE")) {

			System.setProperty("webdriver.IE.driver", "URL for driver.exe");

			driver=new ChromeDriver();

		}
		else {
			System.out.println("This browser is not supported");
		}

		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

	public static void quitBrowser(WebDriver driver) {

		driver.quit();
	}

}
