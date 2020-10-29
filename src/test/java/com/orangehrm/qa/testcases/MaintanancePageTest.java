package com.orangehrm.qa.testcases;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.Testbase;
import com.orangehrm.qa.pages.Homepage;
import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.pages.maintanancepage;

public class MaintanancePageTest extends Testbase {

	LoginPage login;
	Homepage homepage;
	maintanancepage maintain;
	public MaintanancePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		
		login = new LoginPage();
		homepage =	login.login(prop.getProperty("username"), prop.getProperty("password"));
		String usern =	homepage.usercheck();
		System.out.println(usern);
		maintain=	homepage.maintanancelink();
	//	Assert.assertEquals(usern, "Welcome");
		
	}
	
	@Test
	public void emprecord()
	{
	String emprec =	maintain.employeerecord();
	System.out.println(emprec);
	Assert.assertEquals(emprec, "Purge Employee Records");
	}
	
	@AfterMethod
	public void endsession()
	{
		driver.quit();
	}
	
}
