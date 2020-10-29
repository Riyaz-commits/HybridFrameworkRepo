package com.orangehrm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.qa.base.Testbase;
import com.orangehrm.qa.pages.LoginPage;
import com.orangehrm.qa.util.Testutil;

public class LoginPageTest extends Testbase {

	
	
	
	public LoginPageTest()
	{
		super();
	}
	
	LoginPageTestData data = new LoginPageTestData(Logger.getLogger(LoginPageTest.class));
	@BeforeMethod
	public void setup()
	{
		initialization();
		data.log.info("entering application URL");
		
		
		data.login = new LoginPage();
	}
	
	@Test(priority =1)
	public void loginpagetitlecase()
	{
		data.log.info("****************************** starting test case *****************************************");
		data.log.info("****************************** freeCrmTitleTest *****************************************");
		String title = data.login.titlepage();
		System.out.println(title);
		Assert.assertEquals(title, "OrangeHRM");
	}
	
	
	@Test(priority=2)
	public void loginapp() {
		
		data.homepage =	data.login.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@Test(dataProvider = "data-provider")
	public void loginappfail(String username,String Password) {
		
//	String err =	login.loginfail(prop.getProperty("usernameinvalid"), prop.getProperty("password"));
		String err =	data.login.loginfail(username, Password);
		
	}
	
	@AfterMethod
	public void endsession() throws EmailException
	{
		driver.quit();
		
//		EmailReport();
		
		
		
	}
/*
	public void EmailReport() throws EmailException {
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("skriyazbasha91@gmail.com", "Jareena@143"));
		email.setSSLOnConnect(true);
		email.setFrom("skriyazbasha91@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("skriyazbasha091@gmail.com");
		email.send();
	}
*/
	
	@DataProvider (name = "data-provider")
	 public Object[][] dpMethod(){
		 return new Object[][] {{"Admin1","admin123"}, {"Admin", "Admin1"},{"Admin9","admin123"}};
		 }
	
	
	
	
	
}
