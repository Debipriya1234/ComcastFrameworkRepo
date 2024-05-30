package com.comcast.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v114.log.Log;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DatabaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClassTest {
	
	public DatabaseUtility dLib=new DatabaseUtility();
	public FileUtility fLib=new FileUtility();
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	
	
	@BeforeSuite(groups={"SmokeTest", "RegressionTest"})
	public void configBS() throws SQLException {
		System.out.println("===Connect to Server and connect to db, Report config===");
		dLib.getDbconnection();
		
		       
				
	}
	
	
	//@Parameters("BROWSER")
	@BeforeClass(groups={"SmokeTest", "RegressionTest"})
	public void configBC(/*String browser*/) throws IOException {
		System.out.println("===Launch the Browser===");
		String BROWSER= fLib.getDataFromPropertiesFile("browser");
		//String BROWSER=browser;
		
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver=new EdgeDriver();
		}
//		else {
//			driver=new ChromeDriver();
//		}
		
		ChromeOptions options= new ChromeOptions();
		  options.addArguments("--disable-notifications");
		  driver=new ChromeDriver(options);
		  
		  sdriver=driver;
		  UtilityClassObject.setDriver(driver);
		
	}
	
	@BeforeMethod(groups={"SmokeTest", "RegressionTest"})
	public void configBM() throws IOException {
		System.out.println("===Login===");
		String URL=fLib.getDataFromPropertiesFile("url");
		String USERNAME=fLib.getDataFromPropertiesFile("username");
		String PASSWORD=fLib.getDataFromPropertiesFile("password");
        LoginPage lp=new LoginPage(driver);
		lp.LoginToApp(URL, USERNAME, PASSWORD);
		
	}
	
	@AfterMethod(groups={"SmokeTest", "RegressionTest"})
	public void configAM() {
		System.out.println("===Logout===");
		HomePage hp=new HomePage(driver);
		hp.Logout();
	}
	
	@AfterClass(groups={"SmokeTest", "RegressionTest"})
	public void configAC() {
		System.out.println("===Close the Browser===");
		driver.quit();
	}
	
	@AfterSuite(groups={"SmokeTest", "RegressionTest"})
	public void configAS() throws SQLException {
		System.out.println("===Close the Server and close db, Report ===");
		dLib.closeDbconnection();
		
	}


}
