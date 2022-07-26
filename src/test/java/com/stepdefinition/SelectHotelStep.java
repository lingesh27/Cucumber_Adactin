package com.stepdefinition;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
/**
 * 
 * @author Linges
 * @Descriptiom Perform select hotel scenarios
 * @Date 7-Jul-2020
 */
public class SelectHotelStep extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager();

	
	@When("User should select a hotel")
	public void userShouldSelectAHotel() {
		
		pom.getSelectHotelPage().selecthotel();
	}
	
	/**
	 * 
	 * @param expectedSuccessMsg
	 */
	@Then("User should verify after select hotel {string}")
	public void userShouldVerifyAfterSelectHotel(String expectedSuccessMsg) {
		WebElement bookHotelMsg = pom.getBookHotelPage().getBookHotelMsg();
		String actualbookHotelMsg = getText(bookHotelMsg);
		Assert.assertEquals("SelectHotelSuccessMsg", expectedSuccessMsg, actualbookHotelMsg);
	}
	
	@Then("User should click Continue without selecting any hotel")
	public void userShouldClickContinueWithoutSelectingAnyHotel() {
		
		pom.getSelectHotelPage().selectwithouthotel();
	}
	/**
	 * 
	 * @param expectedErrorMsg
	 */
	@Then("User should verify error message on select hotel page {string}")
	public void userShouldVerifyErrorMessageOnSelectHotelPage(String expectedErrorMsg) {
		
		WebElement selecthotelErrorMsg = pom.getSelectHotelPage().getSelecthotelErrorMsg();
		String actualselecthotelErrorMsg = getText(selecthotelErrorMsg);
		Assert.assertEquals("SelectHotelErrorMsg", expectedErrorMsg, actualselecthotelErrorMsg);
	}



	
	
}
