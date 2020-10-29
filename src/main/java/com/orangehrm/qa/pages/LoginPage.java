package com.orangehrm.qa.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.Testbase;
import com.orangehrm.qa.util.Testutil;

public class LoginPage extends Testbase{
	
	@FindBy(xpath="//div[@id='divUsername']//input[@id='txtUsername']")
	WebElement username;
	
	@FindBy(xpath="//div[@id='divPassword']//input[@id='txtPassword']")
	WebElement password;
	
	@FindBy(name="Submit")
	WebElement login;
	
	@FindBy(xpath="//div[@id='divLogo']//img")
	WebElement pagelogovalidation;
	
	@FindBy(xpath="//span[contains(text(),'Invalid credentials')]")
	WebElement invalidcreds;
	
	//initializing the page objects ..objects repository
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//action on driver
	
	public String titlepage()
	{
		return driver.getTitle();
	}
	
	public boolean logoval()
	{
		return pagelogovalidation.isDisplayed();
	}
	
	
	public Homepage login(String un , String pw )
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		login.click();
		driver.manage().timeouts().implicitlyWait(Testutil.implicitwait, TimeUnit.SECONDS);

		return new Homepage(); 
	}
	
	
	public  String loginfail(String un , String pw )
	{
		username.sendKeys(un);
		password.sendKeys(pw);
		login.click();
		driver.manage().timeouts().implicitlyWait(Testutil.implicitwait, TimeUnit.SECONDS);
	return 	invalidcreds.getText();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
