package com.rbs.onlineshopping.ui.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rbs.onlineshopping.ui.helpers.Browser;
import com.rbs.onlineshopping.ui.helpers.CustomizedException;
import com.rbs.onlineshopping.ui.helpers.Generic;
import com.rbs.onlineshopping.ui.helpers.Wait;

public class PaymentPO {

	WebDriver driver;
	public static String strActualProductInfoValue = "";

	@FindBy(xpath = "//h1[@class='page-heading']")
	WebElement elePaymentPageTitle;

	public PaymentPO() {
		this.driver = Browser.driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyPaymentPage(String strExpectedTextValue)
			throws CustomizedException {
		Wait.waitUntilVisibilityofElement(elePaymentPageTitle);
		return Generic.verifyGetText(elePaymentPageTitle, strExpectedTextValue);
	}

}
