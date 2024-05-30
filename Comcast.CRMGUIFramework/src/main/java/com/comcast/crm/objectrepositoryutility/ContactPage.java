package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver driver;
	public ContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//img[@title='Create Contact...']")
			private WebElement createNewContact;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement Startdateverified;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement Enddateverified;
	
	
	
	public WebElement getStartdateverified() {
		return Startdateverified;
	}



	public WebElement getEnddateverified() {
		return Enddateverified;
	}



	public WebElement getCreateNewContact() {
		return createNewContact;
	}
	
	
	
	}


