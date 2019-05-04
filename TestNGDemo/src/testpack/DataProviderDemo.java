package testpack;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	@BeforeSuite
	public static void demoBfrSuite()
	{
		System.out.println("**********Start Execution***********");
	}
	
	@AfterSuite
	public static void demoAftSuite()
	{
		System.out.println("************Stop Execution**************");
	}
	
	@Test(dataProvider = "dp")
  public void f(String un, String pwd) {
	  System.out.println(un +"---->"+pwd);
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "UserNameOne", "PasswordOne" },
      new Object[] { "UserNameTwo", "PasswordTwo" },
    };
  }
}
