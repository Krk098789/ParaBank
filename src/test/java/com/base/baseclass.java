package com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class baseclass

{
	public static WebDriver driver;
	
	public static String getProperties(String key) throws IOException 
	{
		FileInputStream file = new FileInputStream("src\\test\\resources\\PropertyFile\\data.properties");
		Properties p = new Properties();
		p.load(file);
		return p.getProperty(key);
	}
		
		public static String getProjectPath() {

	        return System.getProperty("user.dir");
	}
		public byte[] cucumberScreenShot() {

	        TakesScreenshot ts = (TakesScreenshot) driver;

	        byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);

	        return screenshotAs;

	    }

	 
}
