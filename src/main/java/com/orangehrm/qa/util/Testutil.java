package com.orangehrm.qa.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.orangehrm.qa.base.Testbase;

public class Testutil extends Testbase{

	public static long Page_load_timeout = 60;
	public static long implicitwait = 30;

	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
	//	FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		FileUtils.copyFile(scrFile, new File(currentDir +"/rbskscreenshots/"+ System.currentTimeMillis() + ".png"));
	}
}
