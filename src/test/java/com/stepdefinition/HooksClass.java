package com.stepdefinition;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.baseclass.BaseClass;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
/**
 * 
 * @author Linges
 * @Descriptiom Perform hooks class functions
 * @Date 7-Jul-2020
 */
public class HooksClass extends BaseClass {
	
	/**
	 * 
	 * @throws IOException
	 */
	@Before
	public void beforeScenario() throws IOException {

		getdrivers(getpropertyfile("browserType"));
		launchUrl(getpropertyfile("url"));
		maximize();
		implicitWait(30);
		
	}
	
	
	/**
	 * 
	 * @param sc
	 */
	@After
	public void afterScenario(Scenario sc) {

		if(!sc.isFailed()) {
		
		TakesScreenshot tss = (TakesScreenshot) driver;
		
		byte[] b = tss.getScreenshotAs(OutputType.BYTES);
		
		sc.embed(b, "Every Scenario");
		
		closeAllWindow();
		
		}
		
	}

}
