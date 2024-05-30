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
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClassTest;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrganizationTest extends BaseClassTest {

	@Test
	public void OrganizationsPage() throws EncryptedDocumentException, IOException {
		
		

				
				
				//Read testscript data from excel file
				    
				String OrgName= eLib.getDataFromExcel("Org", 1, 2)+ jLib.getRandomNumber();
				

				  
				   //Step-2: Navigate to Organization Module 
				  HomePage hp=new HomePage(driver);
				  hp.getOrgLink().click();
				  
				  
				  //Step-3: Click on "createoraganization" button
				  OrganizationsPage cnp=new OrganizationsPage(driver);
				  cnp.getCreateNewOrgBtn().click();
				 
				  
				  //Step-4: enter all the details & create new Organization
				  CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
				  cnop.createOrg(OrgName);
			
				  
				  //Verify Header msg Expected Result
				  OrganizationInfoPage oip=new OrganizationInfoPage(driver);
				  String actorgName= oip.getHeadermsg().getText();
				    if(actorgName.contains(OrgName)) {
				    	System.out.println(OrgName + "name is verified ==PASS");
				    }else {
				    	System.out.println(OrgName + "name is not verified ==FAIL");
				    }
				    
				  
			
				 
				 
					
					

	}

}
