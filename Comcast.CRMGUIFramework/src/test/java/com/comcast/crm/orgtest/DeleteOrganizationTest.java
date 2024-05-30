package com.comcast.crm.orgtest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class DeleteOrganizationTest {

	public static void main(String[] args) throws IOException {
		
		/* Create Object */
		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverUtility wLib=new WebDriverUtility();
		// Read common data from properties file
				
				String BROWSER=fLib.getDataFromPropertiesFile("browser");
				String URL=fLib.getDataFromPropertiesFile("url");
				String USERNAME=fLib.getDataFromPropertiesFile("username");
				String PASSWORD=fLib.getDataFromPropertiesFile("password");
				
				
				//Read testscript data from excel file
				    
				String OrgName= eLib.getDataFromExcel("Org2", 10, 2)+ jLib.getRandomNumber();
				
				WebDriver driver=null;
				
				if(BROWSER.equals("chrome")) {
					driver=new ChromeDriver();
				}
				else if(BROWSER.equals("firefox")) {
					driver=new FirefoxDriver();
				}
				else if(BROWSER.equals("edge")) {
					driver=new EdgeDriver();
				}
				else {
					driver=new ChromeDriver();
				}
				
				  ChromeOptions options= new ChromeOptions();
				  options.addArguments("--disable-notifications");
				  driver=new ChromeDriver(options);
				  
				  // Step-1: Login to app
				  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				  driver.get(URL);
				  
				  LoginPage lp=new LoginPage(driver);
				  lp.LoginToApp(URL, USERNAME, PASSWORD);
				  
				  
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
				    
				    //Go back to organizations page 
				      hp.getOrgLink().click();
				    //Search for Organization
					  cnp.getSearchedt().sendKeys(OrgName);
					  wLib.select(cnp.getSearchdropdwn(), "Organization Name");
					  cnp.getSearchbtn().click();
					  
					//in dynamic web table select & delete organization name
					  driver.findElement(By.xpath("//a[text()='"+OrgName+"']/../../td[8]/a[text()='del']")).click();
				    
				  
				  //Step-5: logout to application
				    //hp.Logout();
				    
				    //driver.quit();
				 
				 


	}

}
