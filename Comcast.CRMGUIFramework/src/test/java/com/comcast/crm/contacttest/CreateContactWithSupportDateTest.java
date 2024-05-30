package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClassTest;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreateContactWithSupportDateTest extends BaseClassTest {
	
	@Test
	public void CreateContactWithSupportDateTest() throws Exception, IOException {
		

	
                  //Read testscript data from excel file
					    
					String LastName= eLib.getDataFromExcel("Contact", 4, 2) + jLib.getRandomNumber();
					
		
				
					  
					  //Step-2: Navigate to Contact Module 
					  
					HomePage hp = new HomePage(driver);
					hp.getContactLink().click();

					  
					  //Step-3: Click on "createcontact" button
					ContactPage cp = new ContactPage(driver);
					cp.getCreateNewContact().click();
					  
					  //Step-4: enter all the details & create new Contact and enter start and end date
					  
					  String Startdate=jLib.getSystemDateYYYYMMDD();
					  String Enddate=jLib.getRequiredDateYYYYMMDD(30);
					  CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
					  ccp.getLastName().sendKeys(LastName);
					  ccp.getStartDate().sendKeys(Startdate);
					  ccp.getEndDate().sendKeys(Enddate);
					  ccp.getSave().click();
						
						
					   //Verify Start date and Last date info in Expected Result
					  String actStartDate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
					  if(actStartDate.equals(Startdate)) {
						  System.out.println(Startdate + " information is verified==Pass");
					  }else {
						  System.out.println(Startdate + " information is not verified==Fail");
					  }
					  
					  String actEndDate=driver.findElement(By.id("dtlview_Support End Date")).getText();
					  if(actEndDate.equals(Enddate)) {
						  System.out.println(Enddate + " information is verified==Pass");
					  }else {
						  System.out.println(Enddate + " information is not verified==Fail");
					  }

			
					 
		}


	}


