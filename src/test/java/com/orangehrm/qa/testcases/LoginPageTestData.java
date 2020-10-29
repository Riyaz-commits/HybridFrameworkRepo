package com.orangehrm.qa.testcases;

import org.apache.log4j.Logger;

import com.orangehrm.qa.pages.Homepage;
import com.orangehrm.qa.pages.LoginPage;

public class LoginPageTestData {
	public LoginPage login;
	public Homepage homepage;
	public Logger log;

	public LoginPageTestData(Logger log) {
		this.log = log;
	}
}