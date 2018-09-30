package com.rbs.onlineshopping.ui.helpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	
	private static  WebDriverWait wait;

    /*******************************************************************************************************************************************************************************************************************
    'Created By			: Vasanthi						
    'Created On			: 30-sep-2018					
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: NA
    'Purpose			: To create webdriver Wait
    'Steps:
 
    '************************************************************************************************************************************************************************************************************************/	
	public static WebDriverWait WaitTime(){
		wait = new WebDriverWait(Browser.driver,Browser.timeout);
        return wait;
	}
	
	public static void waitUntilVisibilityofElement(WebElement element){
		Wait.WaitTime().until(ExpectedConditions.visibilityOf(element));
	}

}
