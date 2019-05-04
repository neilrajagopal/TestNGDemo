package testpack;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class NewTest {
  @Test
  public void f() {
	  Assert.assertEquals("a", "b");
	  System.out.println("Validate Test Case 1");
  }

  @Test(dependsOnMethods={"f"},alwaysRun=true)
  public void c() {
	  System.out.println("Validate Test Case 2");
  }
  
  @Test
  public void testIncomplete()
  {
	  System.out.println("Test scripting in progress");
  }
  @BeforeMethod
  public void beforeMethod() {
	System.out.println("Launch Application");  
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Close Application");
  }

}
