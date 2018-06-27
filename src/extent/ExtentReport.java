package extent;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class ExtentReport extends Utility {
	@Test
	public void f() {

		System.setProperty("webdriver.gecko.driver", "D:\\lib\\geckodriver.exe");
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities = DesiredCapabilities.firefox();
		capabilities.setBrowserName("firefox");
		capabilities.setVersion("38.0");
		capabilities.setPlatform(Platform.WINDOWS);
		capabilities.setCapability("marionette", false);

		WebDriver driver = new FirefoxDriver(capabilities);

		driver.get("http://www.google.com");

		WebElement element = driver.findElement(By.name("q"));

		element.sendKeys("Cheese!");

		element.submit();

		System.out.println("Page title is: " + driver.getTitle());

		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().startsWith("cheese!");
			}
		});

		System.out.println("Page title is: " + driver.getTitle());
		if(driver.getTitle().equalsIgnoreCase("Cheese! - Google Search"))
		{
			
			Utility.getInstanceExport().startTest("Testpassed");
			Utility.getInstanceExtentTest().log(LogStatus.PASS, "Testpassed");
			System.out.println("Report written");
		}
	}
	@AfterTest
	 public void endReport(){
		
		Utility.getInstanceExport().endTest(Utility.getInstanceExtentTest());
	
		Utility.getInstanceExport().flush();
	                
		Utility.getInstanceExport().close();
	    }
}
