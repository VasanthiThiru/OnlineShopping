package com.rbs.onlineshopping.ui.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OnlineShoppingUtility {
	
	
   WebDriver driver;
	 
	public OnlineShoppingUtility(){
		this.driver = Browser.driver;
		PageFactory.initElements(driver, this);		
	}
		
	@FindBy(xpath="//p[@class='alert alert-success']")
    WebElement eleAlertMsg;
	
	
    public boolean VeriftAlertSucessMessage(String strExpectedValue) throws CustomizedException{
    	return Generic.verifyGetText(eleAlertMsg, strExpectedValue);	
	}

	
	/*******************************************************************************************************************************************************************************************************************
    'Created By			: Vasanthi					
    'Created On			: 30-sep-2018				
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: NA
    'Purpose			: Wait until the Progressbar get loaded
    'Steps:
    '
	************************************************************************************************************************************************************************************************************************/	
	public boolean waitforProgressBarToDisappear() throws CustomizedException {

        boolean dispCssVal = false;
        try {
            do {
                dispCssVal = Generic.FindElementByXpath("//div[@class='loadingIcon ng-scope']").isDisplayed();
            } while (dispCssVal == true);
        }catch(Exception e){
        	
        }
        return dispCssVal;
    }
	
	

}

