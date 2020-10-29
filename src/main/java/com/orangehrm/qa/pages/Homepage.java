package com.orangehrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.Testbase;

public class Homepage extends Testbase{

	@FindBy(xpath="//a[@id='welcome']")
	WebElement verifyuser;
	
	@FindBy(xpath="//b[contains(text(),'Maintenance')]")
	WebElement maintanancelink;
	
	@FindBy(xpath="//b[contains(text(),'Admin')]")
	WebElement adminLink;
	
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String usercheck()
	{
		
		return verifyuser.getText();
		
	}
	
	public maintanancepage maintanancelink()
	{
		maintanancelink.click();
		
		return new maintanancepage();
		
	}
	
	public adminpages adminlink()
	{
		adminLink.click();
		
		return new adminpages();
		
	}
	
}
