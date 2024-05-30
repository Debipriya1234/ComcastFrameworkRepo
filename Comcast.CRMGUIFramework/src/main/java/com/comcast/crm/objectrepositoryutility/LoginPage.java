package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author HP
 * 
 * Contains Login page elements & business lib like login()
 *
 */

public class LoginPage extends WebDriverUtility{
	
	//Rule-1: Create a separate java class
	
	
	//Rule-3: Object Initialization
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	//Rule-2: Object creation
	@FindBy(name="user_name")
	private WebElement Usernameedt;
	
	@FindBy(name="user_password")
	private WebElement Passwordedt;
	
	
	@FindBy(id="submitButton")
	private WebElement Loginbtn;
	
	
	//Rule-4: Object Encapsulation
	public WebElement getUsernameedt() {
		return Usernameedt;
	}


	public WebElement getPasswordedt() {
		return Passwordedt;
	}


	public WebElement getLoginbtn() {
		return Loginbtn;
	}
	
	/**
	 * login to application based on username,password,url arguments
	 * @param url
	 * @param username
	 * @param password
	 */
	//Rule-5: Provide action
	
	public void LoginToApp(String url,String username,String password) {
		waitForPageToLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		Usernameedt.sendKeys(username);
		Passwordedt.sendKeys(password);
		Loginbtn.click();
	
	
	}
	
	
	
	

}
