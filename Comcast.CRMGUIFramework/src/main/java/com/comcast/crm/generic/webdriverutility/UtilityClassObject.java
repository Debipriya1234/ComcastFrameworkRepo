package com.comcast.crm.generic.webdriverutility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {
	//sharing my test obj in multiple threads by using Extent test
	public static ThreadLocal<ExtentTest> test= new ThreadLocal<ExtentTest>();
	//sharing my driver obj in multiple threads by using Webdriver
	public static ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>();
	
	public static ExtentTest getTest() {
		return test.get();
	}
	public static void setTest(ExtentTest actTest) {
		test.set(actTest);
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}
	public static void setDriver(WebDriver actDriver) {
		driver.set(actDriver);
	}
	
	
	
	

}
