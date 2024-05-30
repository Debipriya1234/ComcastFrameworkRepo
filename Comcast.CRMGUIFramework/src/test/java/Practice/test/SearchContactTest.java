package Practice.test;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClassTest;
import com.comcast.crm.objectrepositoryutility.LoginPage;

/**
 * test class for contact module
 * @author HP
 *
 */

public class SearchContactTest extends BaseClassTest {
	
	/**
	 * Scenario: login()===> navigate contact===> create contact===>verify
	 */
	
	@Test
	public void searchContact() {
		/* Step-1: login to application */
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApp("url", "username", "password");
	}

}
