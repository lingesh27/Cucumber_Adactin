package com.stepdefinition;

import java.awt.AWTException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
/**
 * 
 * @author Linges
 * @Descriptiom Perform login page scenarios
 * @Date 7-Jul-2020
 */
public class LoginPageStep extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager();
	
	/**
	 * 
	 * @throws IOException
	 */
	@Given("User should launch browser and pass adactinhotel page")
	public void userShouldLaunchBrowserAndPassAdactinhotelPage() throws IOException {
		
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @throws IOException
	 */
	@When("User should perform login  {string} , {string}")
	public void userShouldPerformLogin(String username, String password) throws IOException {
			
		
		pom.getLoginPage().login(username, password);
	}
	/**
	 * 
	 * @param username
	 * @param password
	 * @throws AWTException
	 */
	@When("User should perform login using {string} , {string} and press Enter Key")
	public void userShouldPerformLoginUsingAndPressEnterKey(String username, String password) throws AWTException {
		
		pom.getLoginPage().loginwithEnter(username, password);
	}
	
	/**
	 * 
	 * @param errorMsg
	 */
	@Then("User should verify error message contains {string}")
	public void userShouldVerifyErrorMessageContains(String errorMsg) {
		
		WebElement txtErrorMsg = pom.getLoginPage().getTxtErrorMsg();
		String text = getText(txtErrorMsg);
		boolean contains = text.contains(errorMsg);
		Assert.assertTrue("Login Error Msg", contains);
//		Assert.assertTrue(false);
	
	
	}


}
