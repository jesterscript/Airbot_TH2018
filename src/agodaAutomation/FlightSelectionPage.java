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

public class FlightSelectionPage {

	WebDriver driver;

	@Parameters({"browserName","cityName", "monthIndex", "checkinDay", "checkoutDay", "year" })
	@Test
	public void flightSearch(String browserName,String cityName, String monthIndex, String checkinDay, String checkoutDay, String year) {

		driver = DriverManager.getProperDriver(browserName);
		driver.get("https://flights.agoda.com/flights");
		driver.findElement(By.xpath("//input[@id='LNzE-origin']")).click();
		driver.findElement(By.xpath("//input[@id='LNzE-origin']")).clear();
		driver.findElement(By.xpath("//input[@id='LNzE-origin']")).sendKeys("Istanbul");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@id='LNzE-origin']")).sendKeys(Keys.RETURN);
		
		driver.findElement(By.xpath("//input[@id='EjrH-destination']")).click();
		driver.findElement(By.xpath("//input[@id='EjrH-destination']")).clear();
		driver.findElement(By.xpath("//input[@id='EjrH-destination']")).sendKeys(cityName);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@id='EjrH-destination']")).sendKeys(Keys.RETURN);

		String departureDate = monthIndex + "/" + checkinDay + "/" + year;
		driver.findElement(By.xpath("//div[@id='JGgU-depart-input']")).click();
		driver.findElement(By.xpath("//div[@id='JGgU-depart-input']")).clear();
		driver.findElement(By.xpath("//div[@id='JGgU-depart-input']")).sendKeys(departureDate);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//div[@id='JGgU-depart-input']")).sendKeys(Keys.RETURN);
		
		String arrivalDate = monthIndex + "/" + checkoutDay+ "/" + year;
		driver.findElement(By.xpath("//div[@id='JGgU-return-input']")).click();
		driver.findElement(By.xpath("//div[@id='JGgU-return-input']")).clear();
		driver.findElement(By.xpath("//div[@id='JGgU-return-input']")).sendKeys(arrivalDate);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//div[@id='JGgU-return-input']")).sendKeys(Keys.RETURN);
		
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[4]/div[1]/div/div/div[1]/div/div[2]/div/div/div/section[3]/div/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[5]/div[1]/a/div[1]")).click();
		driver.findElement(By.xpath("//label[@id='Oq8O-cabin-e-label']")).click();
		driver.findElement(By.xpath("//button[@id='c2GHk']")).click();
		driver.findElement(By.xpath("//button[@id='PqDj']")).click();
		driver.findElement(By.xpath("//button[@id='GdNL-submit']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test(dependsOnMethods = { "flightSearch" })
	public void listFlights() {
		driver.findElement(By.xpath("//button[@id='PsuR-stops-2225-0-only']")).click();
		driver.findElement(By.xpath("//li[@id='EyRj-sortType_option_1']")).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
