package com.comcast.crm.orgtest;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClassTest;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;


public class CreateOrganizationWithIndustryTest extends BaseClassTest{
	
	@Test
	public void CreatingNewOrganizationPagewithIndustry() throws EncryptedDocumentException, IOException {
		

				
			
				//Read testscript data from excel file
				
				    String OrgName =eLib.getDataFromExcel("Org2",4 , 2)+ jLib.getRandomNumber() ;
				    String Industry= eLib.getDataFromExcel("Org2",4 ,3 );
				    //String Type= eLib.getDataFromExcel("Org2", 4, 4);
				
  
				  //Step-2: Navigate to Organization Module 
				    HomePage hp=new HomePage(driver);
					  hp.getOrgLink().click();
				  
				  //Step-3: Click on "createoraganization" button
					  OrganizationsPage cnp=new OrganizationsPage(driver);
					  cnp.getCreateNewOrgBtn().click();

				  
				  //Step-4: enter all the details & create new Organization
					  CreatingNewOrganizationPage cnop=new  CreatingNewOrganizationPage(driver);
					  cnop.createOrg(OrgName, Industry);
					  cnop.getSavebtn().click();
				  
				  
				  //Verify the industry 
					
				
			  String actindustry=cnop.getIndustryName().getText();
		  if(actindustry.equals(Industry)) {
			  System.out.println(Industry + "information is verified==Pass");
		  }else {
			  System.out.println(Industry + "information is not verified==Fail");
				  }
				  
		       //Verify type info
				//  String acttype=driver.findElement(By.id("dtlview_Type")).getText();
				 // if(acttype.equals(Type)) {
					 // System.out.println(Type + "information is verified==Pass");
				  //}else {
					  //System.out.println(Type + "information is not verified==Fail");
				 // }
				  
		
				 
					
					

	}
}
