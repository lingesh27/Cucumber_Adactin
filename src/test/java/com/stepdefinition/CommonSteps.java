package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Then;
/**
 * 
 * @author Linges
 * @Descriptiom Perform login function
 * @Date 7-Jul-2020
 */
public class CommonSteps extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager();
	
	/**
	 * 
	 * @param successMsg
	 */

	@Then("User should verify after login successfully  {string}")
	public void userShouldVerifyAfterLoginSuccessfully(String successMsg) {
		

		WebElement txtWelcomeMsg = pom.getSearchHotelPage().getTextloginmesseage();
		String text = getAttribute(txtWelcomeMsg);
//		boolean contains = text.contains(successMsg);
		Assert.assertEquals("Login Successful Msg",successMsg , text);
	}

}
