package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(name= "accountname")
	private WebElement Orgnameedt;
	
	@FindBy(name= "button")
	private WebElement Savebtn;
	
	@FindBy(name= "industry")
	private WebElement industrydrpdwn;
	
	@FindBy(id="phone")
	private WebElement phone;
	
	@FindBy(id="dtlview_Industry")
	private WebElement industryName;

	public WebElement getOrgnameedt() {
		return Orgnameedt;
	}

	public WebElement getSavebtn() {
		return Savebtn;
	}
	
	
	public WebElement getIndustrydrpdwn() {
		return industrydrpdwn;
	}

	

	public WebElement getIndustryName() {
		return industryName;
	}

	
	public WebElement getPhone() {
		return phone;
	}

	public void createOrg(String OrgName) {
	Orgnameedt.sendKeys(OrgName);
	Savebtn.click();
	
	}

	public void createOrg(String OrgName,String Industry) {
		Orgnameedt.sendKeys(OrgName);
		Select s= new Select(industrydrpdwn);
		s.selectByVisibleText(Industry);
		Savebtn.click();
		
		
	}
	
	public void createOrgWithPhoneNo(String OrgName, String Phoneno) {
		Orgnameedt.sendKeys(OrgName);
		phone.sendKeys(Phoneno);
		Savebtn.click();

	}
	
}
