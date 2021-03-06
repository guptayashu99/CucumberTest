package com.mindtree.BDD_Cucumber.ReusableComponents;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.BDD_Cucumber.Utilities.PropertyFileUtil;

public class ReusableMethods {
	
	public static void getURL(WebDriver driver) {
		try {
			driver.get(PropertyFileUtil.loadFile().getProperty("url"));
		}
		catch(Exception e){
			System.out.println("URL not Found in config.properties");
		}
	}
	
	public static String getBrowser(WebDriver driver) {
		try {
			return PropertyFileUtil.loadFile().getProperty("browser");
		}
		catch(Exception e){
			System.out.println("Browser not Found in config.properties");
			return null;
		}
	}
	
	public static void impWait(WebDriver driver) throws NumberFormatException, IOException {
		
		int time = Integer.parseInt(PropertyFileUtil.loadFile().getProperty("wait1"));
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		
	}
	
	public static WebElement getElement(WebDriver driver, By locator) {
		try {
			WebElement l =  driver.findElement(locator);
			return l;
		}
		catch(Exception e) {
			//throw new TestException("Could not locate element at"+locator);
			System.out.println("Element not Found at"+locator);
			return null;
		}
		
	}
	
	
	


}
