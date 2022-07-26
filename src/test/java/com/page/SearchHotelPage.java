package com.page;

import com.baseclass.BaseClass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Linges
 * @Descriptiom Create POJO class for Search hotel Page
 * @Date 7-Jul-2020
 */
public class SearchHotelPage extends BaseClass {

	public SearchHotelPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//input[@type='text'])[1]")
	private WebElement textloginmesseage;

	@FindBy(xpath = "//span[@id='checkin_span']")
	private WebElement checkInErrorMsg;

	@FindBy(xpath = "//span[@id='checkout_span']")
	private WebElement checkOutErrorMsg;

	@FindBy(xpath = "//span[@id='location_span']")
	private WebElement searchHotelErrorMsg;

	@FindBy(xpath = "//select[@id='location']")
	private WebElement ddnLocation;

	@FindBy(id = "hotels")
	private WebElement ddnHotels;

	@FindBy(id = "room_type")
	private WebElement ddnRoomtype;

	@FindBy(id = "room_nos")
	private WebElement ddnRoomnumber;

	@FindBy(id = "datepick_in")
	private WebElement ChckIndateclear;

	@FindBy(id = "datepick_in")
	private WebElement ChckIndate;

	@FindBy(id = "datepick_out")
	private WebElement ChckOutdateclear;

	@FindBy(id = "datepick_out")
	private WebElement ChckOutdate;

	@FindBy(id = "adult_room")
	private WebElement ddnAdultperroom;

	@FindBy(id = "child_room")
	private WebElement ddnChildperroom;

	@FindBy(id = "Submit")
	private WebElement BtnSearch;
	
	
	
	public WebElement getCheckInErrorMsg() {
		return checkInErrorMsg;
	}

	public WebElement getCheckOutErrorMsg() {
		return checkOutErrorMsg;
	}

	public WebElement getSearchHotelErrorMsg() {
		return searchHotelErrorMsg;
	}

	public WebElement getTextloginmesseage() {
		return textloginmesseage;
	}

	public WebElement getDdnLocation() {
		return ddnLocation;
	}

	public WebElement getDdnHotels() {
		return ddnHotels;
	}

	public WebElement getDdnRoomtype() {
		return ddnRoomtype;
	}

	public WebElement getDdnRoomnumber() {
		return ddnRoomnumber;
	}

	public WebElement getChckIndate() {
		return ChckIndate;
	}

	public WebElement getChckOutdate() {
		return ChckOutdate;
	}

	public WebElement getDdnAdultperroom() {
		return ddnAdultperroom;
	}

	public WebElement getDdnChildperroom() {
		return ddnChildperroom;
	}

	public WebElement getBtnSearch() {
		return BtnSearch;
	}

	public WebElement getChckIndateclear() {
		return ChckIndateclear;
	}

	public WebElement getChckOutdateclear() {
		return ChckOutdateclear;
	}
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
	public void searchhotel(String location, String hotels, String roomtype, String roomnumber, String checkindate,
			String checkoutdate, String adultperroom, String childperroom) {
		selectOptionsByText(getDdnLocation(), location);
		selectOptionsByText(getDdnHotels(), hotels);
		selectOptionsByText(getDdnRoomtype(), roomtype);
		selectOptionsByText(getDdnRoomnumber(), roomnumber);
		clear(getChckIndateclear());
		type(getChckIndate(), checkindate);
		clear(getChckOutdateclear());
		type(ChckOutdate, checkoutdate);
		selectOptionsByText(getDdnAdultperroom(), adultperroom);
		selectOptionsByText(getDdnChildperroom(), childperroom);
		click(getBtnSearch());
	}
	/**
	 * 
	 * @param location
	 * @param roomnumber
	 * @param checkindate
	 * @param checkoutdate
	 * @param adultperroom
	 */
	public void searchhotelMandatoryfields(String location, String roomnumber, String checkindate, String checkoutdate,
			String adultperroom) {
		selectOptionsByText(getDdnLocation(), location);
		selectOptionsByText(getDdnRoomnumber(), roomnumber);
		clear(getChckIndateclear());
		type(getChckIndate(), checkindate);
		clear(getChckOutdateclear());
		type(ChckOutdate, checkoutdate);
		selectOptionsByText(getDdnAdultperroom(), adultperroom);
		click(getBtnSearch());

	}

	public void clickwithoutenter() {

		click(getBtnSearch());
	}
}
