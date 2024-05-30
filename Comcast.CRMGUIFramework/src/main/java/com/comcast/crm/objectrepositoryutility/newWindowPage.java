package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class newWindowPage {

	WebDriver driver;
	public newWindowPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="search_txt")
	private WebElement searchttext;
	
	@FindBy(xpath="//input[@type='button']")
	private WebElement searchbtn;
	
	public WebElement getSearchttext() {
		return searchttext;
	}


	public WebElement getSearchbtn() {
		return searchbtn;
	}

}
