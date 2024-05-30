package com.comcast.crm.orgtest;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClassTest;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.listenerutility.ListenerImpClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

/**
 * test class for organization module
 * @author HP
 *
 */

@Listeners(com.comcast.crm.listenerutility.ListenerImpClass.class)
public class CreateOrganizationAllBaseClassTest extends BaseClassTest {
	
	@Test(groups="SmokeTest")
	public void CreateOrganizationsPage() throws EncryptedDocumentException, IOException {
		
		UtilityClassObject.getTest().log(Status.INFO, "Read data from excel");
		
		 //Step-1: Read testscript data from excel file
		    String OrgName= eLib.getDataFromExcel("Org", 1, 2)+ jLib.getRandomNumber();
		    

		  //Step-2: Navigate to Organization Module 
		    UtilityClassObject.getTest().log(Status.INFO, "Navigate to org module");
		  HomePage hp=new HomePage(driver);
		  hp.getOrgLink().click();
		  
		  
		  //Step-3: Click on "createoraganization" button
		  UtilityClassObject.getTest().log(Status.INFO, "Click on create org page");
		  OrganizationsPage cnp=new OrganizationsPage(driver);
		  cnp.getCreateNewOrgBtn().click();
		 
		  
		  //Step-4: enter all the details & create new Organization
		  UtilityClassObject.getTest().log(Status.INFO, "Create a new org");
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
	@Test(groups="RegressionTest")
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
				  
				  
				  //Verify the industry 
					
				
			  String actindustry=cnop.getIndustryName().getText();
		  if(actindustry.equals(Industry)) {
			  System.out.println(Industry + "information is verified==Pass");
		  }else {
			  System.out.println(Industry + "information is not verified==Fail");
				  }

	
}
	 @Test(groups="RegressionTest")
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
