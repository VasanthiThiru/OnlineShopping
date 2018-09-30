package com.rbs.onlineshopping.ui.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rbs.onlineshopping.ui.helpers.Browser;
import com.rbs.onlineshopping.ui.helpers.CustomizedException;
import com.rbs.onlineshopping.ui.helpers.Generic;

public class LoginPO {

	WebDriver driver;

	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement clickSigninLnk;

	@FindBy(id = "email")
	WebElement enterEmailID;

	@FindBy(id = "passwd")
	WebElement enterPassword;

	@FindBy(id = "SubmitLogin")
	WebElement clickSiginbtn;

	public LoginPO() {
		this.driver = Browser.driver;
		PageFactory.initElements(driver, this);
	}
		
	public void LoginApplication(String strEmailID,String strPassword) throws CustomizedException, IOException{
		Generic.webClick(clickSigninLnk);
		Generic.webEnter(enterEmailID, strEmailID);
		Generic.webEnter(enterPassword, strPassword);
		Generic.webClick(clickSiginbtn);
	}
	


}
