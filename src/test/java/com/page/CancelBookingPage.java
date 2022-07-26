package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;
/**
 * 
 * @author Linges
 * @Descriptiom Create POJO class for Cancel Booking Page
 * @Date 7-Jul-2020
 */
public class CancelBookingPage extends BaseClass {

	public CancelBookingPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[@id='search_result_error']")
	private WebElement bookingCancelMsg;

	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement BookedItinerary;

	@FindBy(id = "order_id_text")
	private WebElement searchBox;

	@FindBy(id = "search_hotel_id")
	private WebElement btnsearchGo;

	@FindBy(xpath = "//input[@name='ids[]']")
	private WebElement btnselectedorderid;

	@FindBy(xpath = "//input[contains(@name,'btn_id')]")
	private WebElement Cancelorderid;
	
	public WebElement getBookingCancelMsg() {
		return bookingCancelMsg;
	}

	public WebElement getBookedItinerary() {
		return BookedItinerary;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getBtnsearchGo() {
		return btnsearchGo;
	}

	public WebElement getBtnselectedorderid() {
		return btnselectedorderid;
	}

	public WebElement getCancelorderid() {
		return Cancelorderid;
	}
	
	/**
	 * 
	 * @param orderid
	 */
	public void cancelbooking(String orderid) {
		click(getBookedItinerary());
		type(getSearchBox(), orderid);
		click(getBtnsearchGo());
		click(getBtnselectedorderid());
		click(getCancelorderid());
		simpleAlert();
	}
	
	public void cancelExiOrderId() {

		click(getBookedItinerary());
		click(getCancelorderid());
		simpleAlert();

	}

}
