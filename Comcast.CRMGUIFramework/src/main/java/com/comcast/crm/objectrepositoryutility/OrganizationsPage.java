package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	WebDriver driver;
	public OrganizationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="search_text")
	private WebElement searchedt;
	
	@FindBy(name="search_field")
	private WebElement searchdropdwn;
	
	@FindBy(name="submit")
	private WebElement searchbtn;

	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createNewOrgBtn;

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}

	public WebElement getSearchedt() {
		return searchedt;
	}

	
	public WebElement getSearchdropdwn() {
		return searchdropdwn;
	}

	
    public WebElement getSearchbtn() {
		return searchbtn;
	}

	

	public WebDriver getDriver() {
		return driver;
	}
	
	

}
