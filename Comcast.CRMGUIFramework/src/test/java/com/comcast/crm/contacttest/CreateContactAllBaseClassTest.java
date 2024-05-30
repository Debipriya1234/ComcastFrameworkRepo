package com.comcast.crm.contacttest;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClassTest;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.newWindowPage;

/**
 * test class for contact module
 * @author HP
 *
 */


public class CreateContactAllBaseClassTest extends BaseClassTest {
	
	@Test(groups="SmokeTest")
	public void CreateContactTest() throws EncryptedDocumentException, IOException, InterruptedException {
		// Read testscript data from excel file

		String LastName = eLib.getDataFromExcel("Contact", 1, 2) + jLib.getRandomNumber();

		// Step-2: Navigate to Contact Module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// Step-3: Click on "create contact" button
		ContactPage cp = new ContactPage(driver);
		cp.getCreateNewContact().click();

		// Step-4: enter all the details & create new contact
		CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
		ccp.getLastName().sendKeys(LastName);
		ccp.getSave().click();
		
		// Verify Lastname info in Expected Result
		ContactInfoPage ci=new ContactInfoPage(driver);
		String actLastName = ci.getLastName().getText();
		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actLastName, LastName);
		System.out.println("Actual lastname is verified");
		
		//Verify Header msg Expected Result
		  String actHeadermsg = ci.getHeaderText().getText();
		  boolean status=actHeadermsg.contains(LastName);
		  Assert.assertTrue(status);
		  System.out.println("Actual headermsg is showing");
		  
   }

	@Test(groups="RegressionTest")
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
					  String startdate= jLib.getSystemDateYYYYMMDD();
					  String endate= jLib.getRequiredDateYYYYMMDD(30);
					  CreatingNewContactPage ccp = new CreatingNewContactPage(driver);
					  ccp.getLastName().sendKeys(LastName);
					  ccp.createNewContactWithhDate(startdate, endate);
					  ccp.getSave().click();
						
						
					   //Verify Start date and Last date info in Expected Result
				
					  String actStartDate= cp.getStartdateverified().getText();
					 
				       SoftAssert sa=new SoftAssert();
				       sa.assertEquals(actStartDate, startdate);
					  System.out.println("Startdate is verified");
					  String actEndDate=cp.getEnddateverified().getText();
					   sa.assertEquals(actEndDate, endate);
					   System.out.println("Enddate is verified");

			
					 
		}

	@Test(groups="RegressionTest")
	public  void CreateContactWithOrganizationTest() throws EncryptedDocumentException, IOException, InterruptedException {
		



		
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
	       Thread.sleep(2000);
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
		  
		 // ContactInfoPage ci=new ContactInfoPage(driver);
		//String actLastName = ci.getHeaderText().getText();
		 // if(actLastName.contains(ContactLastName)) {
			  //System.out.println(ContactLastName + "header msg is verified==Pass");
		 // }else {
			 // System.out.println(ContactLastName + "header msg is not verified==Fail");
		  //}
		  
		//Verify Header orgName info Expected Result
		  ContactInfoPage ci=new ContactInfoPage(driver);
		  String actorgName= ci.getOrgName().getText();
		  //boolean status=actorgName.contains(OrgName);
		 // Assert.assertTrue(status);
		  SoftAssert sa=new SoftAssert();
		  sa.assertEquals(actorgName, OrgName);
		  System.out.println("Actual organization name is showing");
		 
		  
		 
	
		 
			
	}


	
	

}
