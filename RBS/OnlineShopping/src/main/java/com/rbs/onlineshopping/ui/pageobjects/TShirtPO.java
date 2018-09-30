package com.rbs.onlineshopping.ui.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rbs.onlineshopping.ui.helpers.Browser;
import com.rbs.onlineshopping.ui.helpers.CustomizedException;
import com.rbs.onlineshopping.ui.helpers.Generic;

public class TShirtPO {

	WebDriver driver;

	@FindBy(xpath = "//h1//span[@class='cat-name']")
	WebElement eleTShirtPge;

	@FindBy(xpath = "//ul[@class='product_list grid row']")
	WebElement eleProductCount;

	@FindBy(id = "selectProductSort")
	WebElement selectSortBy;

	public TShirtPO() {
		this.driver = Browser.driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyTShirtPage(String strExpectedTextValue)
			throws CustomizedException {
		return Generic.verifyGetText(eleTShirtPge, strExpectedTextValue);

	}

	public boolean verifyProductCount() throws CustomizedException {
		boolean blnProductStatus = false;
		List<WebElement> list = eleProductCount.findElements(By.tagName("li"));
		if (list.size() > 0) {
			blnProductStatus = true;
		}
		return blnProductStatus;
	}

	public void sortTShirtBy(String strSortByValue) throws CustomizedException {
		Generic.selectByVisibleText(selectSortBy, strSortByValue);
	}

	public void openTShirt(String strProductName) throws CustomizedException {
		Generic.webClick(Generic
				.FindElementByXpath("//h5[@itemprop='name']//a[contains(text(),'"
						+ strProductName + "')]"));

	}

}
