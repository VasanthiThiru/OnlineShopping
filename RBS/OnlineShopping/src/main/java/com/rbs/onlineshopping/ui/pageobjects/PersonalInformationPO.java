package com.rbs.onlineshopping.ui.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rbs.onlineshopping.ui.helpers.Browser;
import com.rbs.onlineshopping.ui.helpers.CustomizedException;
import com.rbs.onlineshopping.ui.helpers.Generic;

public class PersonalInformationPO {

	WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'My personal info')]")
	WebElement clickMyPersonalInfoLnk;

	@FindBy(id = "firstname")
	WebElement enterFirstName;

	@FindBy(id = "old_passwd")
	WebElement enterConfirmpassord;

	@FindBy(name = "submitIdentity")
	WebElement clickSaveBtn;

	public PersonalInformationPO() {
		this.driver = Browser.driver;
		PageFactory.initElements(driver, this);
	}

	public void clickMyPersonalInfoLink() throws CustomizedException {
		Generic.webClick(clickMyPersonalInfoLnk);

	}

	public void enterFirstNameConfirmPassword(String strFirstName)
			throws CustomizedException, IOException {
		Generic.webEnter(enterFirstName, strFirstName);
		Generic.webEnter(enterConfirmpassord, Browser.strPassword);
	}

	public void clickSaveButton() throws CustomizedException {
		Generic.webClick(clickSaveBtn);
	}

}
