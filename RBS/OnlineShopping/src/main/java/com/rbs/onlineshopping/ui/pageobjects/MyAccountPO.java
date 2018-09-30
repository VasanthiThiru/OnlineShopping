package com.rbs.onlineshopping.ui.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rbs.onlineshopping.ui.helpers.Browser;
import com.rbs.onlineshopping.ui.helpers.CustomizedException;
import com.rbs.onlineshopping.ui.helpers.Generic;

public class MyAccountPO {

	WebDriver driver;

	@FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']//li//following-sibling::li//a[contains(text(),'T-shirts')]")
	WebElement clickTShirtLnk;

	public MyAccountPO() {
		this.driver = Browser.driver;
		PageFactory.initElements(driver, this);
	}

	public void clickTShirtLink() throws CustomizedException {
		Generic.webClick(clickTShirtLnk);

	}

}
