package agodaAutomation;

import java.util.Date;
import java.util.Calendar;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

import agodaAutomation.DriverManager;

public class ReservationOperation {

	WebDriver driver;

	@Parameters({ "browserName", "money" })
	@Test
	public void handleCriteriaFilters(String browserName, String money) {

		driver = DriverManager.getProperDriver(browserName);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("price_box_1")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("price_box_1")).clear();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int pricePerNight = (int) (Integer.parseInt(money) / 3);
		driver.findElement(By.id("price_box_1")).sendKeys(pricePerNight + "");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("price_box_1")).sendKeys(Keys.RETURN);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//i[contains(@class,'ficon ficon-star-3 star-orange')]")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(
				"/html/body/div[13]/div/div[2]/div/div/div[1]/div/div/div/ul/li[3]/div[2]/ul/li[3]/span/span[3]/span[1]"))
				.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * driver.findElement(By.id(
		 * "/html/body/div[13]/div/div[2]/div/div/div[1]/div/div/div/ul/li[3]/div[2]/ul/li[1]/span/span[3]/span[1]"
		 * )).click();
		 * 
		 * try { Thread.sleep(10000); } catch (InterruptedException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); } driver.findElement(By.id(
		 * "/html/body/div[13]/div/div[2]/div/div/div[3]/div[2]/div/div[2]/div/div/ul/li[3]/div[2]/ul/li[1]/span/span[2]/span[1]"
		 * )).click(); try { Thread.sleep(10000); } catch (InterruptedException e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); }
		 * driver.findElement(By.id(
		 * "/html/body/div[13]/div/div[2]/div/div/div[3]/div[2]/div/div[2]/div/div/ul/li[5]/div[2]/ul/li[3]/span/span[2]/span[1]"
		 * )).click();
		 */

	}

	@Test(dependsOnMethods = { "handleCriteriaFilters" })
	public void getTopOffer() {
		driver.findElement(By.xpath("//img[contains(@data-element-index,'0')]")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(dependsOnMethods = { "getTopOffer" })
	public void clickBookNow() {

		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);var lenOfPage=document.body.scrollHeight;return lenOfPage;");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//button[@data-element-name='search-button'] ")).click();

	}

}
