package com.inetBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;


public class BaseClass {

	ReadConfig readconfig=new ReadConfig();
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		
		
		logger=Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChroPath());
			driver=new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFFPath());
			driver=new FirefoxDriver();
		}
		
		else if(br.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		logger.info("Opening URL");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseURL);
		logger.info("URL is opened");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreenShot(WebDriver driver, String tname)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File targets=new File(System.getProperty("user.dir")+"/ScreenShots/"+tname+".png");
		try {
			FileUtils.copyFile(source, targets);
			logger.info("ScreenShots Captured");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("ScreenShots Failed");
		}
		
	}
	
	public String randomString()
	{
		String geneartedString=RandomStringUtils.randomAlphabetic(8);
		return geneartedString;
	}
	
	public  static String randomNum()
	{
		String geneartedString=RandomStringUtils.randomNumeric(5);
		return geneartedString;
	}
}
