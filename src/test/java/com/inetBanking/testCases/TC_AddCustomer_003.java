package com.inetBanking.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

import junit.framework.Assert;

public class TC_AddCustomer_003 extends BaseClass{
	
	@Test
	public void addNewCustomer()
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User Name is provided");
		lp.setPassword(password);
		logger.info("Password is provided");
		lp.clickSubmit();
		logger.info("Clicked on Submit button");
		
		
		AddCustomerPage addCust=new AddCustomerPage(driver);
		addCust.clickAddNewCustomer();
		logger.info("Clicked on Add Customer Link");
		addCust.setCustomerName("Narayan");
		logger.info("Customer Name is entered");
		addCust.clickOnGender("male");
		logger.info("Selected Gender");
		addCust.setDOB("10", "05", "1983");
		logger.info("Date of Birth is entered");
		addCust.setCustAddress("India");
		logger.info("Customer Address is entered");
		addCust.setCustCity("Gurgaon");
		logger.info("Customer City is entered");
		addCust.setCustState("Haryana");
		logger.info("Customer State is entered");
		addCust.setCustPIN("122001");
		logger.info("Customer PIN is entered");
		addCust.setCustMobile("987456321");
		logger.info("Customer Mobile is entered");
		addCust.setCustEmail(randomString()+"@gmail.com");
		logger.info("Customer Email is entered");
		addCust.setPassword("abcdes");
		logger.info("Customer Password is entered");
		addCust.clickOnSubmit();
		logger.info("Click on Submit button");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res)
		{
			logger.info("Registration completed successfully");
			Assert.assertTrue(true);
		}
		else
		{
			logger.warn("Registration Failed");
			captureScreenShot(driver, "AddNewCustomer");
			logger.info("Screen Shot Captured");
			Assert.assertTrue(false);
		}
		
	}
	
	
	

}
