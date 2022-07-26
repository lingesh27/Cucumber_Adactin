package com.page;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

/**
 * 
 * @author Linges
 * @Descriptiom Generate POJO class for Booking Confirmation Page
 * @Date 7-Jul-2020
 */

public class BookingConfirmationPage extends BaseClass {

	public BookingConfirmationPage() {

		PageFactory.initElements(driver, this);
	}

	

	@FindBy(xpath = "//td[text()='Booking Confirmation ']")
	private WebElement bookingconfirmtext;

	@FindBy(xpath = "//input[@name='order_no']")
	private WebElement orderid;

	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement bookeditenary;
	
	public WebElement getBookingconfirmtext() {
		return bookingconfirmtext;
	}

	public WebElement getOrderid() {
		return orderid;
	}

	public WebElement getBookeditenary() {
		return bookeditenary;
	}
	
	/**
	 * 
	 * @return String
	 * @throws IOException
	 */
	public String orderid() throws IOException {

		String orderid = getAttribute(getOrderid(), "value");
		return orderid;
	}

}
