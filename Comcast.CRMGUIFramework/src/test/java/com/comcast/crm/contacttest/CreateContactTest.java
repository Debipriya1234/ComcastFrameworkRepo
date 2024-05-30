package com.comcast.crm.contacttest;

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
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.ContactInfoPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreateContactTest extends BaseClassTest {

	@Test
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
		System.out.println(actLastName);
		
		if (actLastName.equals(LastName)) {
			System.out.println(LastName + " information is verified==Pass");
		} else {
			System.out.println(LastName + " information is not verified==Fail");
		}

	}

}
