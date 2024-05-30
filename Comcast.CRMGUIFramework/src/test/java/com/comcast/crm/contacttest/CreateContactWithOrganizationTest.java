package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.newWindowPage;

public class CreateContactWithOrganizationTest extends BaseClassTest {
	
	@Test
	public  void CreateContactWithOrganizationTest() throws EncryptedDocumentException, IOException {
		



		
	//Read testscript data from excel file
		   String OrgName=eLib.getDataFromExcel("Contact", 7, 2)+ jLib.getRandomNumber();
		   String ContactLastName=eLib.getDataFromExcel("Contact", 7, 3)+ jLib.getRandomNumber();
		

		   //Step-2: Navigate to Organization Module 
	       HomePage hp=new HomePage(driver);
	       hp.getOrgLink().click();
	       
		  
		  //Step-3: Click on "createoraganization" button
	       OrganizationsPage op=new OrganizationsPage(driver);
	       op.getCreateNewOrgBtn().click();
		  
		  //Step-4: enter all the details & create new Organization
	       CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
	       cnop.createOrg(OrgName);
	       
		//Step-5: Navigate to contact Module 
		  hp.getContactLink().click(); 
		  
		  //Step-6: Click on "createcontact" button
		  ContactPage cp = new ContactPage(driver);
			cp.getCreateNewContact().click();
		  
		  //Step-7: enter all the details & create new Contact
			CreatingNewContactPage cncp= new CreatingNewContactPage(driver);
			cncp.getLastName().sendKeys(ContactLastName);
			cncp.getOrgnameplusbtn().click();
		   
		 String mainid= wLib.switchToChildWindowAndMainWindow(driver,"module=Contacts");
		 newWindowPage wp=new newWindowPage(driver);
		 wp.getSearchttext().sendKeys(OrgName);
		 wp.getSearchbtn().click();
		
		  driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		  driver.switchTo().window(mainid);
		  cncp.getSave().click();
		  
		//Verify Header msg Expected Result
		  
		  ContactInfoPage ci=new ContactInfoPage(driver);
			String actLastName = ci.getHeaderText().getText();
		  if(actLastName.contains(ContactLastName)) {
			  System.out.println(ContactLastName + "header msg is verified==Pass");
		  }else {
			  System.out.println(ContactLastName + "header msg is not verified==Fail");
		  }
		  
		//Verify Header orgName info Expected Result
		  String actorgName=ci.getOrgName().getText();
		  System.out.println(actorgName);
		  
		  if(actorgName.trim().equals(OrgName)) {
			  System.out.println(OrgName + "information is created==Pass");
		  }else {
			  System.out.println(OrgName + "information is not created==Fail");
		  }
		 
	
		 
			
	}


}


