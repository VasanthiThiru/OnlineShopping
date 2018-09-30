package com.rbs.onlineshopping.ui.stepdefinition;

import org.testng.Assert;

import com.rbs.onlineshopping.ui.helpers.Browser;
import com.rbs.onlineshopping.ui.helpers.Generic;
import com.rbs.onlineshopping.ui.pageobjects.LoginPO;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Login extends Browser {
	
	Generic  gen = new Generic();
		
	public Login() throws Exception {
		super();
	}

	
	@Given("^User have the valid credential and application is up$")
	public void user_have_the_valid_credential_and_application_is_up() throws Throwable {
		
	}

	@Given("^User login to the application with Valid Credentials$")
	public void user_login_to_the_application_with_Valid_Credentials() throws Throwable {

	
	}
	
	@Then("^login should be successful  \"([^\"]*)\"$")
	public void login_should_be_successful(String strExpectedPageTitle) throws Throwable {
	   Assert.assertTrue(Generic.verifyTitle(strExpectedPageTitle));
	}


}
