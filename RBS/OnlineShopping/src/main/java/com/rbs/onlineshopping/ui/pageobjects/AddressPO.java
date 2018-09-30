package com.rbs.onlineshopping.ui.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rbs.onlineshopping.ui.helpers.Browser;
import com.rbs.onlineshopping.ui.helpers.CustomizedException;
import com.rbs.onlineshopping.ui.helpers.Generic;

public class AddressPO {
	
	 WebDriver driver;
		
	 @FindBy(xpath="//h1[@class='page-heading']")
     WebElement eleAddressPge;
	 
	 @FindBy(xpath="//a[contains(@title,'Update')]//span")
     WebElement clickDeliveryAddUpdateBtn;
	 
	 @FindBy(id="address1")
     WebElement enterAddress;
	 
	 @FindBy(id="submitAddress")
     WebElement clickSaveBtn;
	 
	 @FindBy(xpath="//li[@class='address_address1 address_address2']")
     WebElement eleAddressDelivery;
	 
	 
	 @FindBy(xpath="//button[@name='processAddress']//span")
     WebElement clickCheckoutBtn;
	 
	  
	public AddressPO(){
		this.driver = Browser.driver;
		PageFactory.initElements(driver, this);		
	}
	
	public boolean verifyAddresstPage(String strExpectedTextValue)
			throws CustomizedException {
		return Generic.verifyGetText(eleAddressPge, strExpectedTextValue);

	}
	
	public void clickDeliveryAddressUpdateBtn() throws CustomizedException{
		Generic.webClick(clickDeliveryAddUpdateBtn);
	}
	
	public void enterAddress(String strAddressValue) throws CustomizedException, IOException{
		Generic.webEnter(enterAddress, strAddressValue);
	}
	
	public void clickSaveButton() throws CustomizedException{
		Generic.webClick(clickSaveBtn);
	}
	
	public boolean verifyUpdatedAddress(String strAddressValue) throws CustomizedException{
		return Generic.verifyGetText(eleAddressDelivery, strAddressValue);

	}
	
	public void clickProceedCheckoutBtn() throws CustomizedException{
		 Generic.webClick(clickCheckoutBtn);	  
	}
	
	

}
