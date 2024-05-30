package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	//Rule-3: Object Initialization
		WebDriver driver;
		public HomePage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
   //Rule-2: Object Identification
	@FindBy(linkText= "Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText= "Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignLink;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG' ]")
	private WebElement adminimg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	
	//Rule-4: Object Encapsulation
	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}
	
	public WebElement getCampaignLink() {
		return campaignLink;
	}


	public WebElement getMoreLink() {
		return moreLink;
	}


	public void navigateToCampaignPage() {
		Actions act=new Actions(driver);
		act.moveToElement(moreLink).perform();
		campaignLink.click();
	}
	
	public void Logout() {
		Actions act=new Actions(driver);
		act.moveToElement(adminimg).perform();
		signoutLink.click();
	}
	
	
	
	
}
