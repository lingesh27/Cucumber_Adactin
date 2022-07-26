package com.stepdefinition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
/**
 * 
 * @author Linges
 * @Descriptiom Perform cancel hotel scenarios
 * @Date 7-Jul-2020
 */
public class CancelHotelStep extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager();
	 
	/**
	 * 
	 * @throws IOException
	 */
	@Then("User Should cancel the order id")
	public void userShouldCancelTheOrderId() throws IOException {
		
		String orderid = pom.getBookingConfirmationPage().orderid();
		pom.getCancelBookingPage().cancelbooking(orderid);
	}
	
	/**
	 * 
	 * @param expectedbookingCancelMsg
	 */
	@Then("User should verify oredr id cancel message{string}")
	public void userShouldVerifyOredrIdCancelMessage(String expectedbookingCancelMsg) {
		
		WebElement bookingCancelMsg = pom.getCancelBookingPage().getBookingCancelMsg();
		String actualBookingCancelMsg = getText(bookingCancelMsg);
		Assert.assertEquals("BookingCancelMsg", expectedbookingCancelMsg, actualBookingCancelMsg);
	}
	/**
	 * 
	 * @param extOrderid
	 */
	@When("User should cancel the existing booked ordered id {string}")
	public void userShouldCancelTheExistingBookedOrderedId(String extOrderid) {
		
		pom.getCancelBookingPage().cancelExiOrderId();
	}


}
