package com.rbs.onlineshopping.ui.testrunner;

import java.io.File;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.cucumber.listener.ExtentCucumberFormatter;
import com.cucumber.listener.Reporter;
import com.rbs.onlineshopping.ui.helpers.Browser;
import com.rbs.onlineshopping.ui.helpers.Generic;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(plugin = { "com.cucumber.listener.ExtentCucumberFormatter:",
		"junit:target/cucumber-reports/UI.xml" }, 
		features = { "Features" },
		glue = { "com/rbs/onlineshopping/ui/stepdefinition" }, 
		tags = { "@Sanity" })

public class OnlineShoppingUIRunner {

	private TestNGCucumberRunner testNGCucumberRunner;
	public ExtentCucumberFormatter ExtentCucumberFormatter;

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		Browser.LoadConfigFile();
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		ExtentCucumberFormatter = new ExtentCucumberFormatter(new File(
				System.getProperty("user.dir") + "//TestReports//UIReports// "
						+ "Run_" + Generic.getCuttentTimeStamp()
						+ "//report.html"));
	}

	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		Reporter.loadXMLConfig(new File(
				System.getProperty("user.dir")
						+ "//src//main//java//com//rbs//onlineshopping//ui//config//extent-config.xml"));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		Reporter.setSystemInfo("Machine", "Windows 10" + " 64 Bit");
		Reporter.setSystemInfo("Selenium", "3.7.0");
		Reporter.setSystemInfo("Maven", "3.5.2");
		Reporter.setSystemInfo("Java Version", "1.8.0_151");
		testNGCucumberRunner.finish();
		Generic.closeBrowser();
	}

}
