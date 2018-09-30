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

public class CartConfirmationPO {

	WebDriver driver;
	public static String strActualProductInfoValue = "";

	@FindBy(xpath = "//div[@id='layer_cart']//h2")
	WebElement eleConformationMsg;

	@FindBy(xpath = "//div[@class='layer_cart_product_info']")
	WebElement eleProductInfo;

	@FindBy(xpath = "//a[@title='Proceed to checkout']//span")
	WebElement clickCheckoutBtn;

	public CartConfirmationPO() {
		this.driver = Browser.driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyAlertMessage(String strExpectedValue)
			throws CustomizedException {
		return Generic.verifyGetText(eleConformationMsg, strExpectedValue);
	}

	public boolean verifyProductInfo(String strProductName, String strColour,
			String strSize, String strQuantity) throws CustomizedException {
		Wait.waitUntilVisibilityofElement(eleProductInfo);
		String strExpectValue = strProductName + "," + strColour + ","
				+ strSize + "," + strQuantity;
		List<WebElement> list = eleProductInfo.findElements(By.tagName("Span"));
		for (int i = 0; i <= list.size() - 1; i++) {
			strActualProductInfoValue = strActualProductInfoValue + ","
					+ list.get(i).getText().trim();
		}
		strActualProductInfoValue = strActualProductInfoValue.substring(1,
				strActualProductInfoValue.length()).replace(" ", "");
		return Generic.verifyExpectedActualValue(strActualProductInfoValue,
				strExpectValue.replace(" ", ""));

	}

	public void verifyConfirmationMsg(String strExpectedValue)
			throws CustomizedException {
		Generic.verifyGetText(eleConformationMsg, strExpectedValue);
	}

	public void clickProceedCheckoutBtn() throws CustomizedException {
		Generic.webClick(clickCheckoutBtn);
	}

}
