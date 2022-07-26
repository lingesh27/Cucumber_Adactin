package com.pagemanager;

import com.page.BookHotelPage;
import com.page.BookingConfirmationPage;
import com.page.CancelBookingPage;
import com.page.LoginPage;
import com.page.SearchHotelPage;
import com.page.SelectHotelPage;
/**
 * 
 * @author Linges
 * @Descriptiom Perform singleton function
 * @Date 7-Jul-2020
 */
public class PageObjectManager {
	
	

	private LoginPage loginPage;
	private SearchHotelPage searchHotelPage;
	private SelectHotelPage selectHotelPage;
	private BookHotelPage bookHotelPage;
	private BookingConfirmationPage bookingConfirmationPage;
	private CancelBookingPage cancelBookingPage;
	
	/**
	 * 
	 * @return Object
	 */
	public LoginPage getLoginPage() {
		return (loginPage==null)?loginPage= new LoginPage():loginPage;
	}
	/**
	 * 
	 * @return Object
	 */
	public SearchHotelPage getSearchHotelPage() {
		return (searchHotelPage==null)?searchHotelPage=new SearchHotelPage():searchHotelPage;
	}
	
	/**
	 * 
	 * @return Object
	 */
	public SelectHotelPage getSelectHotelPage() {
		return (selectHotelPage==null)?selectHotelPage=new SelectHotelPage():selectHotelPage;
	}
	/**
	 * 
	 * @return Object
	 */
	public BookHotelPage getBookHotelPage() {
		return (bookHotelPage==null)?bookHotelPage= new BookHotelPage():bookHotelPage;
	}
	/**
	 * 
	 * @return Object
	 */
	public BookingConfirmationPage getBookingConfirmationPage() {
		return (bookingConfirmationPage==null)?bookingConfirmationPage=new BookingConfirmationPage():bookingConfirmationPage;
	}
	
	/**
	 * 
	 * @return Object
	 */
	public CancelBookingPage getCancelBookingPage() {
		return (cancelBookingPage==null)?cancelBookingPage=new CancelBookingPage():cancelBookingPage;
	}
	




}
