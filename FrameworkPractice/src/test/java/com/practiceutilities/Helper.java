package com.practiceutilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {
	
	public static String captureScreenshot(WebDriver driver) {
		
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String screenshotpath=System.getProperty("user.dir")+"/Screenshots/FreeCRM"+dateTimeStamp()+".png";		
		try {
			FileHandler.copy(screenshot, new File("./Screenshots/FreeCRM"+dateTimeStamp()+".png"));
			
		} catch (Exception e) {
			System.out.println("Unable to capture the screenshot"+e.getMessage());
		}
		
		return screenshotpath;
	}

	public static String dateTimeStamp() {
		String pattern = "MM_dd_yyyy_HH_mm_ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		return date;
	}
}
