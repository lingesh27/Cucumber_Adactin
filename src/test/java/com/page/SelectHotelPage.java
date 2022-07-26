package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;
/**
 * 
 * @author Linges
 * @Descriptiom Create POJO class for Select Hotel Page
 * @Date 7-Jul-2020
 */
public class SelectHotelPage extends BaseClass {

	public SelectHotelPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[text()='Please Select a Hotel']")
	private WebElement SelecthotelErrorMsg;

	@FindBy(xpath = "//td[text()='Select Hotel ']")
	private WebElement SelecthotelMsg;

	@FindBy(xpath = "//input[@id='radiobutton_0']")
	private WebElement Selecthotel;

	@FindBy(id = "continue")
	private WebElement btncontiue;

	public WebElement getSelecthotelErrorMsg() {
		return SelecthotelErrorMsg;
	}

	public WebElement getSelecthotelMsg() {
		return SelecthotelMsg;
	}

	public WebElement getSelecthotel() {
		return Selecthotel;
	}

	public WebElement getBtncontiue() {
		return btncontiue;
	}
	/**
	 * @Description Select Hotel
	 */
	public void selecthotel() {
		click(getSelecthotel());
		click(getBtncontiue());
	}

	public void selectwithouthotel() {
		click(getBtncontiue());
	}

}
