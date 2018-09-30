package com.rbs.onlineshopping.ui.helpers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Generic {
	
	public static WebDriver driver;
	public static JavascriptExecutor executor;
	
	public Generic(){
		this.driver = Browser.driver;
	}
	
	/*******************************************************************************************************************************************************************************************************************
    'Created By			:Vasanthi					
    'Created On			: 30Sep-2018			
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: ele - element to which data to be enter ,strTextValue - Value 
    'Purpose			:  Enter the value to the particuar element
    'Steps:
    '
	 ************************************************************************************************************************************************************************************************************************/		
	public static void webEnter(WebElement ele,String strTextValue) throws CustomizedException, IOException{
		try {
				ele.clear();
				ele.sendKeys(strTextValue);
			}catch (NoSuchElementException e) {
				throw new CustomizedException("Failed to find the Element " + ele);
			}catch (WebDriverException e) {
				throw new CustomizedException("The browser is not available for unknown reason.");
			}catch (Exception e) {
        		throw new CustomizedException("Unable to enter the value: " + strTextValue);	
		}
	}
	
	
	/*******************************************************************************************************************************************************************************************************************
    'Created By			:Vasanthi					
    'Created On			: 30Sep-2018			
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: ele - element to be clicked
    'Purpose			: Method to click the particular element
    'Steps:
    '
	************************************************************************************************************************************************************************************************************************/	
	public static void webClick(WebElement ele) throws CustomizedException{		
		try {
			ele.click();
		}catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		}catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		}catch (Exception e) {
    		throw new CustomizedException("Unable to click the element");	
	    }
	}
	
	/*******************************************************************************************************************************************************************************************************************
    'Created By			:Vasanthi					
    'Created On			: 30Sep-2018			
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: 
    'Purpose			: Wait until the page gets loaded
    'Steps:
    '
    ************************************************************************************************************************************************************************************************************************/		
	public static void waitForPageLoaded() throws CustomizedException {
	        ExpectedCondition<Boolean> expectation = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver) {
	                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
	                }
	        };
	        try {
	            Thread.sleep(1000);
	            WebDriverWait wait = new WebDriverWait(driver, 10);
	            wait.until(expectation);
	        } catch (Exception e) {
	        	throw new CustomizedException(e.getMessage());
	        }
	}
	    
		
	/*******************************************************************************************************************************************************************************************************************
	 'Created By			:Vasanthi					
	 'Created On			: 30Sep-2018			
	 'Last Updated By	    : NA
	 'Last Updated On	    : NA
	 'Parameters Used	    : ele - element to be verified
	 'Purpose			    : To verify the element is displayed or not
	 'Steps:
	 ************************************************************************************************************************************************************************************************************************/
	 public static boolean isDisplayed(WebElement ele) throws CustomizedException{
			boolean blnDisplayStatus = false;
			try{
				if(ele.isDisplayed()){
					blnDisplayStatus = true;
				}
			}catch (NoSuchElementException e) {
				throw new CustomizedException("Failed to find the Element " + ele);
			}catch (WebDriverException e) {
				throw new CustomizedException("The browser is not available for unknown reason.");
			}catch (Exception e) {
	    		throw new CustomizedException("Element is not displayed");	
		    }
			return blnDisplayStatus;			
	 }	
		
	/*******************************************************************************************************************************************************************************************************************
	 'Created By		:Vasanthi					
	 'Created On		: 30Sep-2018			
	 'Last Updated By	: NA
	 'Last Updated On	: NA
	 'Parameters Used	: strPageTitle - the expected title of the page
	 'Purpose			: Verify the title of the page
	 'Steps:
	 ************************************************************************************************************************************************************************************************************************/	
	 public static boolean verifyTitle(String strPageTitle) throws CustomizedException {
		  boolean bReturn = false;
		  String actualTitle;
		  try{
			  actualTitle = getTitle();
			  if(actualTitle.equals(strPageTitle)){
				 bReturn = true;
			  }else{
				 throw new CustomizedException("The expected page title " +"\""+ strPageTitle + "\"" + " Actual page title: " + "\""+ actualTitle +"\"" + " are not matched");  
			  }
		  }catch(Exception e){
			  throw new CustomizedException(e.getMessage()); 
		  }
		  return bReturn;
	 }
			
	 /*******************************************************************************************************************************************************************************************************************
	  'Created By		:Vasanthi					
      'Created On		: 30Sep-2018			
      'Last Updated By	: NA
	  'Last Updated On	: NA
	  'Parameters Used	: NA
	  'Purpose			:  Get page title
	  'Steps:	    
	 ************************************************************************************************************************************************************************************************************************/	
	 public static String getTitle() throws CustomizedException {
		String sReturn = "";
		try {
			 sReturn = driver.getTitle();
		}catch(WebDriverException e) {
			 throw new CustomizedException("The browser is not available for unknown reason.");
		}catch(Exception e){
			 throw new CustomizedException("Unable to get the title"); 
		}
		return sReturn;
	 }
	
	/*******************************************************************************************************************************************************************************************************************
     'Created By		:Vasanthi					
     'Created On		: 30Sep-2018			
     'Last Updated By	: NA
	 'Last Updated On	: NA
	 'Parameters Used	:ele - element to which value to be selected,strDropdownVisibleText - Visible Text to be selected in dropdown as String
	 'Purpose			:Select Visible Text in a dropdown 
	 'Steps:
	 ************************************************************************************************************************************************************************************************************************/								
	 public static void selectByVisibleText(WebElement ele,String strDropdownVisibleText) throws CustomizedException{
		    try {
				Select selectDropDown = new Select(ele);
				selectDropDown.selectByVisibleText(strDropdownVisibleText);
		    }catch(NoSuchElementException e) {
				throw new CustomizedException("Failed to find the Element " + ele);
		    }catch (WebDriverException e) {
				throw new CustomizedException("The browser is not available for unknown reason.");
		    }catch (Exception e) {
		    	throw new CustomizedException("Item is not listed in the listbox: " + strDropdownVisibleText);	
		    }
	 }
	 
   /*******************************************************************************************************************************************************************************************************************
    'Created By			:Vasanthi					
    'Created On			: 20-july-2018				
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: ele - element to be clicked
    'Purpose			: Method to click using JavaScriptExecutor
	************************************************************************************************************************************************************************************************************************/	
	public static void clickUsingJavaScriptExe(WebElement ele) throws CustomizedException{		
		try {
			executor.executeScript("arguments[0].click();",ele);
		}catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		}catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		}catch (Exception e) {
    		throw new CustomizedException("unable to click the element");	
	    }
	}	 
	
			
	/*******************************************************************************************************************************************************************************************************************
    'Created By			:Vasanthi					
    'Created On			: 30Sep-2018			
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: strlocatorId - ID
    'Purpose			: To find the element by locator ID
    ************************************************************************************************************************************************************************************************************************/
	public static WebElement FindElementByID(String strlocatorId) throws CustomizedException{
		WebElement ele = null;
		try{
		   ele = driver.findElement(By.id(strlocatorId));
		}catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		}catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		}catch (Exception e) {
    		throw new CustomizedException(e.getMessage());	
	    }
		return ele;	
	}
	
	/*******************************************************************************************************************************************************************************************************************
    'Created By			:Vasanthi					
    'Created On			: 30Sep-2018			
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: strlocatorName - Name
    'Purpose			: To find the element by locator Name
    'Steps:
    '
    ************************************************************************************************************************************************************************************************************************/
	public static WebElement FindElementByName(String strlocatorName) throws CustomizedException{
		WebElement ele = null;
		try{
		   ele = driver.findElement(By.name(strlocatorName));
		}catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		}catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		}catch (Exception e) {
    		throw new CustomizedException(e.getMessage());	
	    }
		return ele;	
	}
			
	/*******************************************************************************************************************************************************************************************************************
    'Created By			:Vasanthi					
    'Created On			: 30Sep-2018			
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: strlocatorClassName - ClassName
    'Purpose			: To find the element by locator ClassName
    'Steps:
    '
    ************************************************************************************************************************************************************************************************************************/
	public static WebElement FindElementByClassName(String strlocatorClassName) throws CustomizedException{
		WebElement ele = null;
		try{
		   ele = driver.findElement(By.className(strlocatorClassName));
		}catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		}catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		}catch (Exception e) {
    		throw new CustomizedException(e.getMessage());	
	    }
		return ele;	
	}
	
			
	/*******************************************************************************************************************************************************************************************************************
    'Created By			:Vasanthi					
    'Created On			: 30Sep-2018			
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: strlocatorLinkText - linkedtext
    'Purpose			: To find the element by locator linkedText
    'Steps:
    '
    ************************************************************************************************************************************************************************************************************************/
	public static WebElement FindElementByLinkText(String strlocatorLinkText) throws CustomizedException{
		WebElement ele = null;
		try{
		   ele = driver.findElement(By.linkText(strlocatorLinkText));
		}catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		}catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		}catch (Exception e) {
    		throw new CustomizedException(e.getMessage());	
	    }
		return ele;	
	}
			
	/*******************************************************************************************************************************************************************************************************************
    'Created By			:Vasanthi					
    'Created On			: 30Sep-2018			
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: strlocatorPartialLinkText -partial linkedtext
    'Purpose			: To find the element by locator locatorPartialLinkText
    'Steps:
    '
    ************************************************************************************************************************************************************************************************************************/
	public static WebElement FindElementByPartialLinkText(String strlocatorPartialLinkText) throws CustomizedException{
		WebElement ele = null;
		try{
		   ele = driver.findElement(By.partialLinkText(strlocatorPartialLinkText));
		}catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		}catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		}catch (Exception e) {
    		throw new CustomizedException(e.getMessage());	
	    }
		return ele;	
	}
	
	/*******************************************************************************************************************************************************************************************************************
    'Created By			:Vasanthi					
    'Created On			: 30Sep-2018			
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: strlocatorTagName - TagName
    'Purpose			: To find the element by locator TagName
    'Steps:
    '
	************************************************************************************************************************************************************************************************************************/
	public static WebElement FindElementByTagname(String strlocatorTagName) throws CustomizedException{
		WebElement ele = null;
		try{
		   ele = driver.findElement(By.tagName(strlocatorTagName));
		}catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		}catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		}catch (Exception e) {
    		throw new CustomizedException(e.getMessage());	
	    }
		return ele;	
	}
	
	/*******************************************************************************************************************************************************************************************************************
    'Created By			:Vasanthi					
    'Created On			: 30Sep-2018			
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: strlocatorCSS - CSS value
    'Purpose			: To find the element by locator CSS
    'Steps:
    '
	************************************************************************************************************************************************************************************************************************/
	public static WebElement FindElementByCSS(String strlocatorCSS) throws CustomizedException{
		WebElement ele = null;
		try{
		   ele = driver.findElement(By.cssSelector(strlocatorCSS));
		}catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		}catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		}catch (Exception e) {
    		throw new CustomizedException(e.getMessage());	
	    }
		return ele;	
	}
	
	/*******************************************************************************************************************************************************************************************************************
    'Created By			:Vasanthi					
    'Created On			: 30Sep-2018			
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: strlocatorXpath - Xpath
    'Purpose			: To find the element by locator Xpath
    'Steps:
    '
    ************************************************************************************************************************************************************************************************************************/
	public static WebElement FindElementByXpath(String strlocatorXpath) throws CustomizedException{
		WebElement ele = null;
		try{
		   ele = driver.findElement(By.xpath(strlocatorXpath));
		}catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		}catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		}catch (Exception e) {
    		throw new CustomizedException(e.getMessage());	
	    }
		return ele;	
	}
	
	
	/*******************************************************************************************************************************************************************************************************************
    'Created By			:Vasanthi					
    'Created On			: 30Sep-2018			
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: NA
    'Purpose			: To Close the browser
    'Steps:
    '
	************************************************************************************************************************************************************************************************************************/	
	
	public static void closeBrowser() throws CustomizedException {
		try {
			driver.close();
		} catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		}catch(Exception e){
			throw new CustomizedException("Unable to close the Browser");	 
		}

	}
	
	/*******************************************************************************************************************************************************************************************************************
    'Created By			:Vasanthi					
    'Created On			: 30Sep-2018			
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: NA
    'Purpose			: To quit the browser
    'Steps:
    '
	 ************************************************************************************************************************************************************************************************************************/	
	public static void quitBrowser() throws CustomizedException {
		try {
			driver.quit();
		}catch(WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		}catch(Exception e){
			throw new CustomizedException("Unable to quit the Browser");	  
		}
	}
	/*******************************************************************************************************************************************************************************************************************
    'Created By			:Vasanthi					
    'Created On			: 30Sep-2018			
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: NA
    'Purpose			: To get the current date and time
    'Steps:
	************************************************************************************************************************************************************************************************************************/	
	public static String getCuttentTimeStamp(){
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("Eyyyy.MM.dd'_'hh:mm:ssa");
		return ft.format(date).replaceAll(":", "_");
	}
	
	/*******************************************************************************************************************************************************************************************************************
    'Created By			:Vasanthi					
    'Created On			: 30Sep-2018			
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: ele - element to be clicked
    'Purpose			: Method to click the particular element
    'Steps:
    '
	************************************************************************************************************************************************************************************************************************/	
	public static String getText(WebElement ele) throws CustomizedException{	
		
		String strGetText = "";
		try {
			strGetText = ele.getText();
		}catch (NoSuchElementException e) {
			throw new CustomizedException("Failed to find the Element " + ele);
		}catch (WebDriverException e) {
			throw new CustomizedException("The browser is not available for unknown reason.");
		}catch (Exception e) {
    		throw new CustomizedException("Unable to click the element");	
	    }
		return strGetText;
	}
	
	/*******************************************************************************************************************************************************************************************************************
    'Created By			:Vasanthi					
    'Created On			: 30Sep-2018			
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: ele - element to be clicked,strExpectedTextValue- value to be compared
    'Purpose			: Method to verify the text value
    'Steps:
    '
	************************************************************************************************************************************************************************************************************************/	
	public static boolean verifyGetText(WebElement ele,String strExpectedTextValue) throws CustomizedException{
		boolean blnReturn = false;
		try {
			String verifyText = getText(ele);
			if (verifyText.contains(strExpectedTextValue)) {
				blnReturn= true;
			} else {
				throw new CustomizedException("The expected text " +"\""+ strExpectedTextValue + "\"" + " Actual text: " + "\""+ verifyText +"\"" + " are not matched");					
			} 
		}catch(Exception e){
			throw new CustomizedException(e.getMessage());
		}
		return blnReturn;
	}
	/*******************************************************************************************************************************************************************************************************************
    'Created By			:Vasanthi					
    'Created On			: 30Sep-2018			
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: strExpectedValue,strActualValue
    'Purpose			: Method to compare two values
    'Steps:
    '
	************************************************************************************************************************************************************************************************************************/	
	public static boolean verifyExpectedActualValue(String strExpectedValue,String strActualValue){
		 boolean blnStatus = false;

		if(strExpectedValue.contains(strActualValue)){
			blnStatus = true;
			
		}
		return blnStatus;	
	}
	

   
	
		
}

