package com.rbs.onlineshopping.ui.stepdefinition;

import org.testng.Assert;

import com.rbs.onlineshopping.ui.helpers.Browser;
import com.rbs.onlineshopping.ui.helpers.Generic;
import com.rbs.onlineshopping.ui.helpers.OnlineShoppingUtility;
import com.rbs.onlineshopping.ui.pageobjects.PersonalInformationPO;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UpdatePersonalInformation extends Browser{
	
	public UpdatePersonalInformation() throws Exception {
		super();
	}

	PersonalInformationPO perinfo = new PersonalInformationPO();
	OnlineShoppingUtility utility = new OnlineShoppingUtility();
	
	
	@Given("^User is on My Account My store page$")
	public void user_is_on_My_Account_My_store_page() throws Throwable {
	 
	}

	@When("^User click on my personal info link$")
	public void user_click_on_my_personal_info_link() throws Throwable {
		perinfo.clickMyPersonalInfoLink();

	}

	@When("^User Update FirstName \"([^\"]*)\" and CurrentPassword$")
	public void user_Update_FirstName_and_CurrentPassword(String strFirstName) throws Throwable {
		perinfo.enterFirstNameConfirmPassword(strFirstName);

	}

	@When("^User click on Save button$")
	public void user_click_on_Save_button() throws Throwable {
		perinfo.clickSaveButton();
	
	}

	@Then("^User should see the update confirmation message \"([^\"]*)\"$")
	public void user_should_see_the_update_confirmation_message(String strExpectedValue) throws Throwable {
		Assert.assertTrue(utility.VeriftAlertSucessMessage(strExpectedValue));
	}



}
