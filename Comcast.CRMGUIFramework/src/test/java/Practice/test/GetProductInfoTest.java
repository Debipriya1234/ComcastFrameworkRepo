package Practice.test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoTest {
	@Test(dataProvider="getData")
	public void getProductInfoTest(String brandName, String productName) throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://amazon.in");
		
		//Search product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		
		//capture product info
		
		String x="//span[text()='"+productName+"']/../../../../../../..//span[@class='a-price']";
		
		WebElement wb=driver.findElement(By.xpath(x));
		Actions act=new Actions(driver);
		act.moveToElement(wb).perform();
		
		String price=driver.findElement(By.xpath(x)).getText();
		//if(price.replace('?','$') != null){
			//System.out.println(price);
		//}
		System.out.println(price);
		driver.quit();
	}

	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		ExcelUtility eLib=new ExcelUtility();
		int rowcount= eLib.getRowcount("product");
		Object[][] objarr=new Object[rowcount][2];
		
		for(int i=0; i<rowcount; i++) {
			objarr[i][0]= eLib.getDataFromExcel("product", i+1, 0);
		    objarr[i][1]= eLib.getDataFromExcel("product", i+1, 1);		
		}
		
		return objarr;
	
	
}

	
}
