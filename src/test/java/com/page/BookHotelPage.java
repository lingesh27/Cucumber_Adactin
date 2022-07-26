package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

/**
 * 
 * @author Linges
 * @Descriptiom Generate POJO for Book Hotel Page
 * @Date 7-Jul-2020
 */

public class BookHotelPage extends BaseClass {

	public BookHotelPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[text()='Book A Hotel ']")
	private WebElement BookHotelMsg;

	@FindBy(xpath = "//label[@id='first_name_span']")
	private WebElement firstnameErrorMsg;

	@FindBy(xpath = "//label[@id='last_name_span']")
	private WebElement lastnameErrorMsg;

	@FindBy(xpath = "//label[@id='address_span']")
	private WebElement billingAddressErrorMsg;

	@FindBy(xpath = "//label[@id='cc_num_span']")
	private WebElement creditCardNumErrorMsg;

	@FindBy(xpath = "//label[@id='cc_type_span']")
	private WebElement creditCardTypeErrorMsg;

	@FindBy(xpath = "//label[@id='cc_expiry_span']")
	private WebElement creditCardExpiryErrorMsg;

	@FindBy(xpath = "//label[@id='cc_cvv_span']")
	private WebElement creditCardCvvErrorMsg;
	
	@FindBy(id = "first_name")
	private WebElement FirstName;

	@FindBy(id = "last_name")
	private WebElement LastName;

	@FindBy(id = "address")
	private WebElement BillingAddress;

	@FindBy(id = "cc_num")
	private WebElement CreditcardNumber;

	@FindBy(id = "cc_type")
	private WebElement Creditcardtype;

	@FindBy(id = "cc_exp_month")
	private WebElement Expirymonth;

	@FindBy(xpath = "//select[@id='cc_exp_year']")
	private WebElement cardexpiryYear;

	@FindBy(id = "cc_cvv")
	private WebElement CvvNumber;

	@FindBy(id = "book_now")
	private WebElement Booknow;

	public WebElement getBookHotelMsg() {
		return BookHotelMsg;
	}

	public WebElement getFirstnameErrorMsg() {
		return firstnameErrorMsg;
	}

	public WebElement getLastnameErrorMsg() {
		return lastnameErrorMsg;
	}

	public WebElement getBillingAddressErrorMsg() {
		return billingAddressErrorMsg;
	}

	public WebElement getCreditCardNumErrorMsg() {
		return creditCardNumErrorMsg;
	}

	public WebElement getCreditCardTypeErrorMsg() {
		return creditCardTypeErrorMsg;
	}

	public WebElement getCreditCardExpiryErrorMsg() {
		return creditCardExpiryErrorMsg;
	}

	public WebElement getCreditCardCvvErrorMsg() {
		return creditCardCvvErrorMsg;
	}

	
	public WebElement getFirstName() {
		return FirstName;
	}

	public WebElement getLastName() {
		return LastName;
	}

	public WebElement getBillingAddress() {
		return BillingAddress;
	}

	public WebElement getCreditcardNumber() {
		return CreditcardNumber;
	}

	public WebElement getCreditcardtype() {
		return Creditcardtype;
	}

	public WebElement getExpirymonth() {
		return Expirymonth;
	}

	public WebElement getCardexpiryYear() {
		return cardexpiryYear;
	}

	public WebElement getCvvNumber() {
		return CvvNumber;
	}

	public WebElement getBooknow() {
		return Booknow;
	}

	/**
	 * 
	 * @param firstname
	 * @param lastname
	 * @param billingaddress
	 * @param creditcardnumber
	 * @param creditcardtype
	 * @param expirymonth
	 * @param cardexpiryYear
	 * @param cvvnumber
	 * @throws Throwable
	 */
	
	public void bookhotel(String firstname, String lastname, String billingaddress, String creditcardnumber,
			String creditcardtype, String expirymonth, String cardexpiryYear, String cvvnumber) throws Throwable {
		type(getFirstName(), firstname);
		type(getLastName(), lastname);
		type(getBillingAddress(), billingaddress);
		type(getCreditcardNumber(), creditcardnumber);
		selectOptionsByText(getCreditcardtype(), creditcardtype);
		selectOptionsByText(getExpirymonth(), expirymonth);
		selectOptionsByText(getCardexpiryYear(), cardexpiryYear);
		type(getCvvNumber(), cvvnumber);
		click(getBooknow());
	}
	public void bookhotelnoarg() {
		click(getBooknow());

	}

}
