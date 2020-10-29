package com.orangehrm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.orangehrm.qa.util.Testutil;
import com.orangehrm.qa.util.WebEventListener;

public class Testbase {

	public static WebDriver driver;
public static Properties prop;
public static EventFiringWebDriver e_driver;
public static WebEventListener wbListener;

	public Testbase()
	{

		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:\\Users\\riyshaik\\eclipsePersonal\\SeleniumProject\\src\\main\\java\\com\\orangehrm\\qa\\config\\config.properties");
			prop.load(fis);
		}
		catch(FileNotFoundException e){

			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}


public static void initialization()
{
	String browsername = prop.getProperty("browser");
	
	if(browsername.equalsIgnoreCase("chrome"))
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\riyshaik\\eclipsePersonal\\SeleniumProject\\src\\main\\java\\com\\orangehrm\\qa\\util\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
	}
	else if(browsername.equalsIgnoreCase("firefox"))
	{
		System.setProperty("webdriver.gecko.driver","C:\\Users\\riyshaik\\eclipsePersonal\\SeleniumProject\\src\\main\\java\\com\\orangehrm\\qa\\util\\deckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	e_driver= new EventFiringWebDriver(driver);
	
	wbListener= new WebEventListener();
	e_driver.register(wbListener);
	driver=e_driver;
	
	
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Testutil.Page_load_timeout, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(Testutil.implicitwait, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));	
}

}












