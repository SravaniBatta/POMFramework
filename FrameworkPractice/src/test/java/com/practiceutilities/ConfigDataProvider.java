package com.practiceutilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public ConfigDataProvider() {
		
		File src=new File("./Configuration/Config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		} 
		catch (Exception e) {
			System.out.println("Cant load the properties file"+e.getMessage());
		}
		
	
	}
	
	public String getBrowser() {
		return pro.getProperty("Browser");
	}
	
	public String getQaUrl() {
		return pro.getProperty("Appurl");
	}
	public String getConfigData(String key) {
		return pro.getProperty(key);
	}


}
