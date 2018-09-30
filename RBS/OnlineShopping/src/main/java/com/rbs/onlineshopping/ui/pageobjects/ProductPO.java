package com.rbs.onlineshopping.ui.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rbs.onlineshopping.ui.helpers.Browser;
import com.rbs.onlineshopping.ui.helpers.CustomizedException;
import com.rbs.onlineshopping.ui.helpers.Generic;

public class ProductPO {

	WebDriver driver;

	@FindBy(id = "quantity_wanted")
	WebElement enterQuantity;

	@FindBy(id = "group_1")
	WebElement enterSize;

	@FindBy(xpath = "//p[@id='add_to_cart']//span")
	WebElement clickAddtoCartBtn;

	public ProductPO() {
		this.driver = Browser.driver;
		PageFactory.initElements(driver, this);
	}

	public void selectColourSizeQuantity(String strColour, String strSize,
			String strQuantity) throws CustomizedException, IOException {
		Generic.webClick(Generic.FindElementByXpath("//a[@title='" + strColour
				+ "']"));
		Generic.selectByVisibleText(enterSize, strSize);
		Generic.webEnter(enterQuantity, strQuantity);
	}

	public void clickAddtoCartBtn() throws CustomizedException {
		Generic.webClick(clickAddtoCartBtn);
	}

}
