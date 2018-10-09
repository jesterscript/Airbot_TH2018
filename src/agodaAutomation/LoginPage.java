package agodaAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import agodaAutomation.DriverManager;

public class LoginPage {
	
	WebDriver driver;
	public static String browserNameHolder = "";

	@Parameters("browserName")
	@Test
	public void openBrowser(String browserName) {
		System.out.println(browserName);
		browserNameHolder = browserName;
		driver = DriverManager.getProperDriver(browserName);
		driver.manage().window().maximize();
		driver.get("https://www.agoda.com");
		

	}
	
	@Test(dependsOnMethods = { "openBrowser" })
	public void openLoginWindow()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-in-btn")));
		driver.findElement(By.id("sign-in-btn")).click();
		driver.findElement(By.id("signin-email-input")).sendKeys("airtiesqatest@gmail.com");
		driver.findElement(By.id("signin-password-input")).sendKeys("QAteam2017");
		driver.findElement(By.id("sign-in-submit-button")).click();
	}
	
	@Test(dependsOnMethods = { "openLoginWindow" })
	public void handleCurrency() {
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(@class,'currency-trigger__text')]")));
		driver.findElement(By.xpath("//span[contains(@class,'currency-trigger__text')]")).click();
		
		
		
		
	}

	

}
