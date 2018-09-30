package com.rbs.onlineshopping.ui.helpers;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;

import com.rbs.onlineshopping.ui.pageobjects.LoginPO;

import cucumber.api.Scenario;


public class Browser {
	
    public static WebDriver driver;
    public static  int timeout;
    public static  int pagetimeout;
    public static Properties prop; 
    public static String UserID;
    public static String strPassword;
    public static SessionId session;
    public static String strDriverValue; 
    public static int intLoginCounter = 0;	 
    public static Scenario sc;

	    
   /*******************************************************************************************************************************************************************************************************************
    'Created By			: Vasanthi						
    'Created On			:  30-sep-2018			
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: NA
    'Purpose			: To Launch the browser
    'Steps:
    '************************************************************************************************************************************************************************************************************************/
    public Browser() throws Exception{
  
    	intLoginCounter= intLoginCounter+1;
        	
    	if(!(driver == null)){
    		 if(!(driver.toString() == null)){
    			 strDriverValue = driver.toString();
    		 }else{
    			 strDriverValue = ""; 
    		 }
    	}
    	
    	if(driver == null || strDriverValue.contains("null")){	
    		 Browser.LoadConfigFile(); //Load the Config file    		
    		 Browser.SetSystemProperty(); //Launch the browser
	   		 try{
	   			 timeout = Integer.parseInt(prop.getProperty("TimeOut"));
	   			 pagetimeout = Integer.parseInt(prop.getProperty("PageTimeOut"));
	   			 pagetimeout = Integer.parseInt(prop.getProperty("PageTimeOut"));
	   			 driver.get(prop.getProperty("URL"));
	   			 driver.manage().timeouts().implicitlyWait(timeout,TimeUnit.SECONDS) ;	
	   			driver.manage().timeouts().pageLoadTimeout(pagetimeout, TimeUnit.SECONDS);
	   			 driver.manage().window().maximize();
	   			 
	   			 LoginPO login = new LoginPO();
	   			 String strEmailID = prop.getProperty("EmailID");
	   		     strPassword = prop.getProperty("Password");
	   			 login.LoginApplication(strEmailID, strPassword);
	   		 }
	   		 catch(Exception e){
	   			  throw new CustomizedException(e.getLocalizedMessage());
	    	}
    	}
    }
	  	  
    /*******************************************************************************************************************************************************************************************************************
    'Created By			: Vasanthi						
    'Created On			:  30-sep-2018				
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: NA
    'Purpose			: To load the config file
    'Steps:
    '*************************************************************************************************************************************************************************************************************************/
    public static Properties LoadConfigFile(){
    	try{
     	   File file = new File(System.getProperty("user.dir") +"\\src\\main\\java\\com\\rbs\\onlineshopping\\ui\\config\\Config.properties"); 		  
 		   FileInputStream  fileInput = new FileInputStream(file);
 		    prop = new Properties();
 		    prop.load(fileInput);
 			return prop; 	    		   
    	}
    	catch (IOException e) {
            throw new RuntimeException("Couldn't load Properties", e);
	     }
    }
    
    /*******************************************************************************************************************************************************************************************************************
    'Created By			: Vasanthi					
    'Created On			:  30-sep-2018					
    'Last Updated By	: NA
    'Last Updated On	: NA
    'Parameters Used	: NA
    'Purpose			: To set system property for browser
    'Steps:
    '*************************************************************************************************************************************************************************************************************************/
	public static void SetSystemProperty() throws Exception {		
		  
		 String browserName = prop.getProperty("BrowserName");	
	
		 switch(browserName){
				case "Chrome":
					DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("disable-infobars");
					capabilities.setCapability(ChromeOptions.CAPABILITY, options);
					System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\com\\rbs\\onlineshopping\\ui\\resources\\chromedriver.exe");
				    driver = new ChromeDriver(capabilities);
				    break;				    
				case "Firefox":
				    driver = new FirefoxDriver();
				    break;
			    case "IExplorer":
			    	DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			    	ieCapabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
			        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			        ieCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			        ieCapabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
				    System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\src\\main\\java\\com\\rbs\\onlineshopping\\resources\\IEDriverServer.exe");
				    driver = new InternetExplorerDriver(ieCapabilities);
				    break;
		 }	
    }	
		
}