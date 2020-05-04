package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {
	
	@Test(dataProvider="loginData")
	public void loginDDT(String user, String pass)
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Entered User Name");
		lp.setPassword(pass);
		logger.info("Entered Password");
		lp.clickSubmit();
		logger.info("Clicked on Submit button");
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.warn("Login Failed");
			Assert.assertTrue(false);
			
			
		}
		else
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info("Login Successfully");
		}
		
	}
	
	public boolean isAlertPresent()
	{
		try{
			driver.switchTo().alert();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	@DataProvider(name="loginData")
	String[][] getData() throws IOException
	{
		String XLSPath=System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetBanking\\testData\\TestData.xlsx";
		int rownum=XLUtils.getRowCount(XLSPath, "Sheet1");
		int colcnt=XLUtils.getCellCount(XLSPath, "Sheet1", 1);
		String[][] logindata=new String[rownum][colcnt];
		for(int i=1; i<=rownum;i++)
		{
			for(int j=0; j<colcnt;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(XLSPath, "Sheet1", i, j);
			}
		}
		
	 return logindata;
	}
	

}
