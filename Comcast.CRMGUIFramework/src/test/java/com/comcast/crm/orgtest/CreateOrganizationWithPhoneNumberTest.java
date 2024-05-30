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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClassTest;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationWithPhoneNumberTest extends BaseClassTest {
	
  @Test
public void CreatingNewOrganizationPagewithPhonenum() throws EncryptedDocumentException, IOException {
		
		            String OrgName = eLib.getDataFromExcel("Org2", 7, 2)+ jLib.getRandomNumber();
				    String PhoneNumber=eLib.getDataFromExcel("Org2", 7, 3);
				
                   //Step-2: Navigate to Organization Module 
				    HomePage hp=new HomePage(driver);
					  hp.getOrgLink().click(); 
				  
				  //Step-3: Click on "createoraganization" button
					  OrganizationsPage cnp=new OrganizationsPage(driver);
					  cnp.getCreateNewOrgBtn().click();
				  
				  //Step-4: enter all the details & create new Organization
					  CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
					  cnop.createOrgWithPhoneNo(OrgName, PhoneNumber);
					  cnop.getSavebtn().click();

					  
	               //Verify Header msg Expected Result
					   OrganizationInfoPage oip=new OrganizationInfoPage(driver);
					  	String actorgName= oip.getHeadermsg().getText();
					  	 if(actorgName.contains(OrgName)) {
					  			System.out.println(OrgName + "is created==Pass");
					  	 }else {
					  		    System.out.println(OrgName + "is not created==Fail");
					  				  }
					  				  
					 //Verify Header phone number info Expected Result
					  	String actphoneNum=oip.getPhoneNum().getText();
					  	if(actphoneNum.contains(PhoneNumber)) {
					  			System.out.println(PhoneNumber+ "information is created==Pass");
					  	}else {
					  		    System.out.println(PhoneNumber+ "information is not created==Fail");
					  				  }
					  				  
					  			
					  				 
					  				}
				  

				  
			        }



