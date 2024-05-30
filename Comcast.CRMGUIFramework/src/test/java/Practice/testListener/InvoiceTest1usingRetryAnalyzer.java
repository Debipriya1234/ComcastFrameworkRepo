package Practice.testListener;

import org.testng.Assert;
import org.testng.annotations.Test;



public class InvoiceTest1usingRetryAnalyzer {

	@Test(retryAnalyzer=com.comcast.crm.listenerutility.RetryListenerImpClass.class)
		public void activateSim() {
			System.out.println("execute activatesim");
			Assert.assertEquals("","Login");
			System.out.println("step-1");
			System.out.println("step-2");
			System.out.println("step-3");
			System.out.println("step-4");
			
		}


}
