package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(how=How.XPATH, using="//a[text()='New Customer']") 
	@CacheLookup
	WebElement lnkAddCustomer;
	
	@FindBy(how=How.NAME, using="name") 
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(how=How.NAME, using="rad1") 
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how=How.ID_OR_NAME, using="dob") 
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(how=How.NAME, using="addr") 
	@CacheLookup
	WebElement txtAddress;
	
	@FindBy(how=How.NAME, using="city") 
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(how=How.NAME, using="state") 
	@CacheLookup
	WebElement txtState;
	
	@FindBy(how=How.NAME, using="pinno") 
	@CacheLookup
	WebElement txtPin;
	
	@FindBy(how=How.NAME, using="telephoneno") 
	@CacheLookup
	WebElement txtMobile;
	
	@FindBy(how=How.NAME, using="emailid") 
	@CacheLookup
	WebElement txtEmail;
	
	@FindBy(how=How.NAME, using="password") 
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(how=How.NAME, using="sub") 
	@CacheLookup
	WebElement btnSubmit;
	
	
	public void clickAddNewCustomer()
	{
		lnkAddCustomer.click();
	}
	
	public void setCustomerName(String custName)
	{
		txtCustomerName.sendKeys(custName);
	}
	
	public void clickOnGender(String cGender)
	{
		rdGender.click();
	}
	
	public void setDOB(String mm, String dd, String yy)
	{
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	public void setCustAddress(String add)
	{
		txtAddress.sendKeys(add);
	}
	public void setCustCity(String city)
	{
		txtCity.sendKeys(city);
	}
	public void setCustState(String state)
	{
		txtState.sendKeys(state);
	}
	public void setCustMobile(String mobile)
	{
		txtMobile.sendKeys(mobile);
	}
	public void setCustEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setCustPIN(String pin)
	{
		txtPin.sendKeys(pin);
	}
	
	public void setPassword(String pass)
	{
		txtPassword.sendKeys(pass);
	}
	
	public void clickOnSubmit()
	{
		btnSubmit.click();
	}
	
	

}
