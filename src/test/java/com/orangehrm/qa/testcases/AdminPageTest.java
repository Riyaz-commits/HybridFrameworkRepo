package com.orangehrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.Testbase;
import com.orangehrm.qa.pages.Homepage;
import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.pages.adminpages;
import com.orangehrm.qa.pages.maintanancepage;

public class AdminPageTest extends Testbase{
	
	LoginPage login;
	Homepage homepage;
	maintanancepage maintain;
	adminpages admin;
	public AdminPageTest()
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
	//	Assert.assertEquals(usern, "Welcome");
		
	}
	
	@Test
	public void adminaccess()	
	{
		admin=	homepage.adminlink();
		
		String direct =driver.getTitle();
		
		Assert.assertEquals(direct, "OrangeHRM");
	}
	

	@AfterMethod
	public void endsession()
	{
		driver.quit();
	}
	

	
}
