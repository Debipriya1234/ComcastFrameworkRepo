package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	
	WebDriver driver;
	public CreatingNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
@FindBy(name="lastname")
private WebElement lastName;

@FindBy(name="support_start_date")
private WebElement startDateTF;

@FindBy(name="support_end_date")
private WebElement endDateTF;

@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
private WebElement orgnameplusbtn;

@FindBy(name="button")
private WebElement save;

public WebElement getLastName() {
	return lastName;
}

public WebElement getStartDate() {
	return startDateTF;
}

public WebElement getEndDate() {
	return endDateTF;
}



public WebElement getOrgnameplusbtn() {
	return orgnameplusbtn;
}



public WebElement getSave() {
	return save;
}
 
public void createNewContactWithhDate(String startDate, String endDate) {
	Actions act=new Actions(driver);
	act.moveToElement(startDateTF).perform();
	startDateTF.clear();
	startDateTF.sendKeys(startDate);
	endDateTF.clear();
	endDateTF.sendKeys(endDate);

}



}
