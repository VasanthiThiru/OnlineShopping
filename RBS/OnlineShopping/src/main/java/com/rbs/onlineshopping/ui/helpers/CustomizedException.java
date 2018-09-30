package com.rbs.onlineshopping.ui.helpers;
import cucumber.api.Scenario;

	
  public class CustomizedException extends Exception {
		
		private static Scenario scenario;

	    public CustomizedException(String strMessage) {
	         super(strMessage);      
	    }
	}


