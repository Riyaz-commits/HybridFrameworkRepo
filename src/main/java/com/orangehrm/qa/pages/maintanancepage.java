package com.orangehrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangehrm.qa.base.Testbase;

public class maintanancepage extends Testbase{
	
	@FindBy(xpath="//h1[contains(text(),'Purge Employee Records')]")
	WebElement maintananceemployerecord;
	
	
	
	
	public maintanancepage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String employeerecord()
	{
		return maintananceemployerecord.getText();
	}

}
