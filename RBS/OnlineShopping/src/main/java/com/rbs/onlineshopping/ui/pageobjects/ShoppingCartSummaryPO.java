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
import com.rbs.onlineshopping.ui.helpers.Wait;

public class ShoppingCartSummaryPO {

	WebDriver driver;

	@FindBy(id = "cart_title")
	WebElement eleSummaryCartPageTitle;

	@FindBy(id = "cart_summary")
	WebElement eleCartSummaryTable;

	@FindBy(xpath = "//p[@class='cart_navigation clearfix']//a[@title='Proceed to checkout']//span")
	WebElement clickCheckoutBtn;

	public ShoppingCartSummaryPO() {
		this.driver = Browser.driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifySummaryCartPage(String strExpectedTextValue)
			throws CustomizedException {
		Wait.waitUntilVisibilityofElement(eleSummaryCartPageTitle);
		return Generic.verifyGetText(eleSummaryCartPageTitle,
				strExpectedTextValue);
	}

	public boolean VerifyProductinfo(String strProductName, String strQuality,
			String strSize, String strColour) {
		String strActualValue = "";
		boolean blnStatus = true;
		String strExpectedValue = strProductName + "," + strQuality + ","
				+ strSize + "," + strColour;
		String[] arrExpectedvalue = strExpectedValue.split(",");

		List<WebElement> list = eleCartSummaryTable.findElements(By
				.xpath("//img[@alt='" + strProductName + "']//ancestor::tr"));
		for (int i = 0; i <= list.size() - 1; i++) {
			strActualValue = strActualValue + "," + list.get(i).getText();
		}
		for (int j = 0; j <= arrExpectedvalue.length - 1; j++) {
			if (!strActualValue.contains(arrExpectedvalue[j])) {
				blnStatus = false;
				break;
			}

		}
		return blnStatus;
	}

	public void clickProceedCheckoutBtn() throws CustomizedException {
		Generic.webClick(clickCheckoutBtn);
	}

}
