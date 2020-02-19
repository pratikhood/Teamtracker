package com.teamtracker.qa.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.teamtracker.qa.pages.LoginPage;
import com.teamtracker.qa.util.ReadConfig;
import com.teamtracker.qa.util.TestUtil;



public class BaseClass 
{

	
	public ReadConfig readConfig  = new ReadConfig();
	
	public String baseURL = readConfig.getApplicationURL();
	
	public String username = readConfig.getUsername();
	public String password = readConfig.getPassword();
	
	
	public String chromepath = readConfig.getChromePath();
	
	public static Logger logger;
	public static WebDriver driver;

	@Parameters("browser")
	@BeforeClass 
	public void setup(String br)
	{

		Logger logger = Logger.getLogger("Teamtracker");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
			
		System.setProperty("webdriver.chrome.driver", chromepath);
		driver = new ChromeDriver();
		
		}	
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", readConfig.getIEPath());
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(baseURL);
		logger.info("URL opened");
		

	}
	
	
	/*
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	 */
	
	
	
	
	
	public void captureScreen(WebDriver driver, String tname) throws IOException
	{
	TakesScreenshot ts = (TakesScreenshot) driver;	
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir")+"/Screenshots/" + tname + ".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot taken");
	}
	
	
	
}
