package agodaAutomation;

import java.util.Date;
import java.util.Calendar;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
		driver.get("https://www.agoda.com/tr-tr/");

	}

	@Test(dependsOnMethods = { "openBrowser" })
	public void openLoginWindow() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-in-btn")));
		driver.findElement(By.id("sign-in-btn")).click();
		driver.findElement(By.id("signin-email-input")).sendKeys("airtiesqatest@gmail.com");
		driver.findElement(By.id("signin-password-input")).sendKeys("QAteam2017");
		driver.findElement(By.id("sign-in-submit-button")).click();
	}

	@Test(dependsOnMethods = { "openLoginWindow" })
	public void handleCurrency() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Türkçe'])[1]/following::span[1]"))
				.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='€'])[1]/following::span[1]"))
				.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Parameters({ "cityName", "monthIndex", "checkinDay", "checkoutDay" })
	@Test(dependsOnMethods = { "handleCurrency" })
	public void handleRooms(String cityName, String monthIndex, String checkinDay, String checkoutDay) {

		driver.get("https://www.agoda.com/tr-tr/?cid=-1");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[contains(@data-selenium,'textInput')]")).click();
		driver.findElement(By.xpath("//input[contains(@data-selenium,'textInput')]")).clear();
		driver.findElement(By.xpath("//input[contains(@data-selenium,'textInput')]")).sendKeys(cityName);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[contains(@data-selenium,'textInput')]")).sendKeys(Keys.RETURN);

		Calendar localCalendar = Calendar.getInstance(TimeZone.getDefault());

		Date currentTime = (Date) localCalendar.getTime();
		int currentDay = localCalendar.get(Calendar.DATE);
		int currentMonth = localCalendar.get(Calendar.MONTH) + 1;
		int desiredMothIndex = Integer.parseInt(monthIndex);
		int difference = currentMonth - desiredMothIndex;
		boolean rightNavigation = (difference < 0) ? false : true;
		int absDif = Math.abs(difference);

		for (int i = 0; i < absDif; ++i) {

			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();

		}

		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Pz'])[1]/following::span[" + checkinDay +"]")).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Pz'])[1]/following::span["+ checkoutDay + "]")).click();

		System.out.println(currentMonth);
		
		for(int i = 0 ; i < 1 ; ++i)
		{
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver.findElement(By.xpath("/html/body/div[7]/div/section[1]/section[1]/div/div[2]/div[1]/div/div[5]/div/div/div/div[3]/span[4]")).click();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("/html/body/div[7]/div/section[1]/section[1]/div/div[2]/div[1]/div/div[5]/div/div/div/div[4]/ul/li/div/select/option[4]")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("/html/body/div[7]/div/section[1]/section[1]/div/div[2]/div[1]/div/div[5]/div/div/div/div[5]/div[1]/span")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("/html/body/div[7]/div/section[1]/section[1]/div/div[2]/div[1]/div/button")).click();
	}

}
