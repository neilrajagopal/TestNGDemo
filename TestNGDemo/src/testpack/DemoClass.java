package testpack;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;

public class DemoClass {
	

		@BeforeMethod
		public void demoBfrSuite()
		{
			System.out.println("Launch Application");
		}
		
		@AfterMethod
		public void demoAftSuite()
		{
			System.out.println("Close Application");
		}
		
		@Test(dataProvider = "dp")
	  public void f(String un, String pwd) {
			//Assert.assertTrue(false);
		/*	SoftAssert sa = new SoftAssert();
			System.out.println("Statement one");
			sa.assertEquals(false, true);
			System.out.println("Statement Two");
			sa.assertTrue(false);
			System.out.println(un +"---->"+pwd);
			sa.assertAll(); */
	  }

	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { "Mercury", "Mercury" },
	      new Object[] { "UserNameTwo", "PasswordTwo" },
	    };
	  }
	}



