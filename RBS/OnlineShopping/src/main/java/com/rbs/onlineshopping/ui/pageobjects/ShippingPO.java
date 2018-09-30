package com.rbs.onlineshopping.ui.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rbs.onlineshopping.ui.helpers.Browser;
import com.rbs.onlineshopping.ui.helpers.CustomizedException;
import com.rbs.onlineshopping.ui.helpers.Generic;

public class ShippingPO {

	WebDriver driver;

	@FindBy(xpath = "//button[@name='processCarrier']//span")
	WebElement clickCheckoutBtn;

	@FindBy(xpath = "//h1[@class='page-heading']")
	WebElement eleShippingPge;

	@FindBy(id = "uniform-cgv")
	WebElement clickTermsService;

	public ShippingPO() {
		this.driver = Browser.driver;
		PageFactory.initElements(driver, this);
	}

	public void checkTermsandService(String strTextValue)
			throws CustomizedException, IOException {
		Generic.webClick(clickTermsService);
	}

	public void clickProceedCheckoutBtn() throws CustomizedException {
		Generic.webClick(clickCheckoutBtn);
	}

	public boolean verifyShippingPage(String strExpectedTextValue)
			throws CustomizedException {
		return Generic.verifyGetText(eleShippingPge, strExpectedTextValue);

	}

}
