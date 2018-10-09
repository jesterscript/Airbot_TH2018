package agodaAutomation;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverManager {
	
public static HashMap<String,WebDriver> drivers = new HashMap<>();
	
	private void createFirefoxDriver()
	{
		drivers.put("firefox", new FirefoxDriver());
	}
	private void createChromeDriver()
	{
		drivers.put("chrome", new ChromeDriver());
	}
	private void createEdgeDriver()
	{
		drivers.put("edge", new EdgeDriver());
		
	}
	public static WebDriver getProperDriver(String name)
	{
		return drivers.get(name);
	}
	
	@Parameters({"testType","chromePath","firefoxPath","edgePath"})
	@BeforeSuite
	public void initDriverList(String testType,String chromePath,String firefoxPath,String edgePath)
	{
		System.out.println("Test type is " + testType);
		System.setProperty("webdriver.chrome.driver",chromePath);
		System.setProperty("webdriver.gecko.driver",firefoxPath);
		System.setProperty("webdriver.edge.driver",edgePath);
		switch (testType) {
		case "firefox":
			createFirefoxDriver();
			break;
		case "chrome":
			createChromeDriver();
			break;
		case "edge":
			createChromeDriver();
			break;
		case "cross":
			createFirefoxDriver();
			createChromeDriver();
			createEdgeDriver();
			break;
			

		default:
			break;
		}
	}

}
