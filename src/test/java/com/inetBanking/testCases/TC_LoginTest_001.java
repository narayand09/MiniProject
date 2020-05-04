package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest()
	{
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered User Name");
		lp.setPassword(password);
		
		logger.info("Entered Password");
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Test Case is passed");
		}
		else
		{
			captureScreenShot(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Test Case is failed");
		}
	}

}
