package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;
import com.pagemanager.PageObjectManager;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
/**
 * 
 * @author Linges
 * @Descriptiom Perform book hotel scenarios
 * @Date 7-Jul-2020
 */
public class BookHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param billingaddress
	 * @param dataTable
	 * @throws Throwable
	 */
	
	@When("User should book hotel by passing {string},{string}and{string}")
	public void userShouldBookHotelByPassingAnd(String firstname, String lastname, String billingaddress,
			DataTable dataTable) throws Throwable {

		List<Map<String, String>> map = dataTable.asMaps();
		Map<String, String> map2 = map.get(2);
		String creditcardnumber = map2.get("Credit Card No");
		String creditcardtype = map2.get("Credit Card Type");
		String expirymonth = map2.get("Expiry Month");
		String cardexpiryYear = map2.get("Expiry Year");
		String cvvnumber = map2.get("CVV Number");
		pom.getBookHotelPage().bookhotel(firstname, lastname, billingaddress, creditcardnumber, creditcardtype,
				expirymonth, cardexpiryYear, cvvnumber);

	}
	
	/**
	 * 
	 * @param expectedSuccessMsg
	 */
	
	@Then("User should verify after bookhotel {string}")
	public void userShouldVerifyAfterBookhotel(String expectedSuccessMsg) {
		
		WebElement bookingconfirmtext = pom.getBookingConfirmationPage().getBookingconfirmtext();
		String actualbookingconfirmtext = getText(bookingconfirmtext);
		Assert.assertEquals("BookHotelSuccessMsg", expectedSuccessMsg, actualbookingconfirmtext);
	}
	
	@When("User should click Book Now without passing any credentials")
	public void userShouldClickBookNowWithoutPassingAnyCredentials() {

		pom.getBookHotelPage().bookhotelnoarg();

	}
	/**
	 * 
	 * @param expectedFirstNameErrorMsg
	 * @param expectedlastNameErrorMsg
	 * @param expectedBillingAddressErrorMsg
	 * @param expectedCreditCardNumErrorMsg
	 * @param expectedCreditCardTypeErrorMsg
	 * @param expectedCreditCardExpiryErrorMsg
	 * @param expectedCreditCardCvvErrorMsg
	 */
	@Then("User should verify error message on book hotel page {string},{string},{string},{string},{string},{string}and{string}")
	public void userShouldVerifyErrorMessageOnBookHotelPageAnd(String expectedFirstNameErrorMsg, String expectedlastNameErrorMsg, String expectedBillingAddressErrorMsg, String expectedCreditCardNumErrorMsg, String expectedCreditCardTypeErrorMsg, String expectedCreditCardExpiryErrorMsg, String expectedCreditCardCvvErrorMsg) {

		WebElement firstnameErrorMsg = pom.getBookHotelPage().getFirstnameErrorMsg();
		String actualfirstnameErrorMsg = getText(firstnameErrorMsg);
		Assert.assertEquals("FirstNameErrorMsg", expectedFirstNameErrorMsg, actualfirstnameErrorMsg);
		
		WebElement lastnameErrorMsg = pom.getBookHotelPage().getLastnameErrorMsg();
		String actuallastnameErrorMsg = getText(lastnameErrorMsg);
		Assert.assertEquals("LastNameErrorMsg", expectedlastNameErrorMsg, actuallastnameErrorMsg);
		
		WebElement billingAddressErrorMsg = pom.getBookHotelPage().getBillingAddressErrorMsg();
		String actualBillingAddressErrorMsg = getText(billingAddressErrorMsg);
		Assert.assertEquals("BillingAddressErrorMsg", expectedBillingAddressErrorMsg, actualBillingAddressErrorMsg);
		
		WebElement creditCardNumErrorMsg = pom.getBookHotelPage().getCreditCardNumErrorMsg();
		String actualCreditCardNumErrorMsg = getText(creditCardNumErrorMsg);
		Assert.assertEquals("CreditCardNumErrorMsg", expectedCreditCardNumErrorMsg, actualCreditCardNumErrorMsg);
		
		WebElement creditCardTypeErrorMsg = pom.getBookHotelPage().getCreditCardTypeErrorMsg();
		String actualCreditCardTypeErrorMsg = getText(creditCardTypeErrorMsg);
		Assert.assertEquals("CreditCardTypeErrorMsg", expectedCreditCardTypeErrorMsg, actualCreditCardTypeErrorMsg);
		
		WebElement creditCardExpiryErrorMsg = pom.getBookHotelPage().getCreditCardExpiryErrorMsg();
		String actualCreditCardExpiryErrorMsg = getText(creditCardExpiryErrorMsg);
		Assert.assertEquals("CreditCardExpiryErrorMsg", expectedCreditCardExpiryErrorMsg, actualCreditCardExpiryErrorMsg);
		
		WebElement creditCardCvvErrorMsg = pom.getBookHotelPage().getCreditCardCvvErrorMsg();
		String actualCreditCardCvvErrorMsg = getText(creditCardCvvErrorMsg);
		Assert.assertEquals("CreditCardCvvErrorMsg", expectedCreditCardCvvErrorMsg, actualCreditCardCvvErrorMsg);
		
		}
	
	}
	


