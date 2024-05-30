package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="mouseArea_Phone")
	private WebElement phoneNum;
	
	@FindBy(className= "dvHeaderText")
	private WebElement headermsg;
	
	
	public WebElement getHeadermsg() {
		return headermsg;
	}


	public WebElement getPhoneNum() {
		return phoneNum;
	}
	
	

}
