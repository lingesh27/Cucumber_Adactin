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
 * @Descriptiom Perform search hotel scenarios
 * @Date 7-Jul-2020
 */
public class SearchHotelStep extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager();
	
	
	/**
	 * 
	 * @param location
	 * @param hotels
	 * @param roomtype
	 * @param roomnumber
	 * @param checkindate
	 * @param checkoutdate
	 * @param adultperroom
	 * @param childperroom
	 */
	@When("User should search hotel {string},{string},{string},{string},{string},{string},{string}and{string}")
	public void userShouldSearchHotelAnd(String location, String hotels, String roomtype, String roomnumber, String checkindate, String checkoutdate, String adultperroom, String childperroom) {

		pom.getSearchHotelPage().searchhotel(location, hotels, roomtype, roomnumber, checkindate, checkoutdate, adultperroom, childperroom);
	
	}
	
	/**
	 * 
	 * @param expectedSerachSuccessMessage
	 */
	@Then("User should verify after search hotel {string}")
	public void userShouldVerifyAfterSearchHotel(String expectedSerachSuccessMessage) {

		WebElement selecthotelMsg = pom.getSelectHotelPage().getSelecthotelMsg();
		String actualselecthotelMsg = getText(selecthotelMsg);
		Assert.assertEquals("ExpectedSerachHotelSuccessMessage", expectedSerachSuccessMessage, actualselecthotelMsg);
	
	}
	
	/**
	 * 
	 * @param location
	 * @param roomnumber
	 * @param checkindate
	 * @param checkoutdate
	 * @param adultperroom
	 */
	@When("User should search hotel by passing {string},{string},{string},{string}and{string}")
	public void userShouldSearchHotelByPassingAnd(String location, String roomnumber, String checkindate, String checkoutdate, String adultperroom) {
		
		pom.getSearchHotelPage().searchhotelMandatoryfields(location, roomnumber, checkindate, checkoutdate, adultperroom);
	
	}
	/**
	 * 
	 * @param expectedInDateErrorMsg
	 * @param expectedOutdateErrorMsg
	 */
	@Then("User should verify error message after search {string},{string}")
	public void userShouldVerifyErrorMessageAfterSearch(String expectedInDateErrorMsg, String expectedOutdateErrorMsg) {
		
		WebElement checkInErrorMsg = pom.getSearchHotelPage().getCheckInErrorMsg();
		String actualCheckInErrorMsg = getText(checkInErrorMsg);
		Assert.assertEquals("CheckInErrorMsg", expectedInDateErrorMsg, actualCheckInErrorMsg);
		
		WebElement checkOutErrorMsg = pom.getSearchHotelPage().getCheckOutErrorMsg();
		String actualCheckOutErrorMsg = getText(checkOutErrorMsg);
		Assert.assertEquals("CheckOutErrorMsg", expectedOutdateErrorMsg, actualCheckOutErrorMsg);

	}
	
	@When("User should perform search hotel without entering any fields")
	public void userShouldPerformSearchHotelWithoutEnteringAnyFields() {
		
		pom.getSearchHotelPage().clickwithoutenter();

	}
	/**
	 * 
	 * @param expectedErrorMsg
	 */
	@Then("User should click search and verify message after login {string}")
	public void userShouldClickSearchAndVerifyMessageAfterLogin(String expectedErrorMsg) {

		WebElement searchHotelErrorMsg = pom.getSearchHotelPage().getSearchHotelErrorMsg();
		String actualErrorMsg = getText(searchHotelErrorMsg);
		Assert.assertEquals("SearchHotelErrorMsg", expectedErrorMsg, actualErrorMsg);
	
	}


}
