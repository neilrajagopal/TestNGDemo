package bookingTickets;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookTicketsValidation {
	WebDriver driver;

	@BeforeMethod
	public void demoBfrSuite()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Neel\\Desktop\\SeleniumTraining\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/");
	}
	
	@AfterMethod
	public void demoAftSuite()
	{
		driver.close();
	}
	
	@Test(dataProvider = "dp")
  public void f(String strWindowTitle, String strUserName, String strPassword, String strTripType, String strFromPort) {
		//Login
		Assert.assertEquals(driver.getTitle(), strWindowTitle);
		driver.findElement(By.name("userName")).sendKeys(strUserName);
		driver.findElement(By.name("password")).sendKeys(strPassword);
		driver.findElement(By.name("login")).click();
		Assert.assertTrue(driver.findElement(By.linkText("SIGN-OFF")).isDisplayed());
		
		//Select Trip Type
		List<WebElement> tTypes=driver.findElements(By.name("tripType"));
		for(WebElement tType:tTypes)
		{
			if(tType.getAttribute("value").equals(strTripType))
			{
				tType.click();
			}
		}
	 
		//Select From Port
		Select fPort=new Select(driver.findElement(By.name("fromPort")));
		fPort.selectByVisibleText(strFromPort);
		Assert.assertEquals(fPort.getFirstSelectedOption().getText().trim(), strFromPort);
		driver.findElement(By.linkText("SIGN-OFF")).click();
		
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Welcome: Mercury Tours","mercury", "mercury","oneway","New York" },
      new Object[] { "Welcome: Mercury Tours","mercury", "mercury","roundtrip","London" },
    };
  }

}
