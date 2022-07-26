package com.page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class LoginPage extends BaseClass {
/**
 * @author Linges
 * @Descriptiom Create POJO class for Cancel Booking Page
 * @Date 7-Jul-2020	
 */
public LoginPage() {
		
		PageFactory.initElements(driver,this);
	}

	@FindBy(id = "username")
	private WebElement txtUserName;

	@FindBy(id = "password")
	private WebElement txtPassword;

	@FindBy(id = "login")
	private WebElement Btnlogin;

	@FindBy(xpath="//b[contains(text(),'Invalid Login details')]")
	private WebElement txtErrorMsg;
	
	

	public WebElement getTxtErrorMsg() {
		return txtErrorMsg;
	}

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnlogin() {
		return Btnlogin;
	}
	/**
	 * 
	 * @param username
	 * @param password
	 */
	public void login(String username, String password) {

		type(getTxtUserName(), username);
		type(getTxtPassword(), password);
		click(getBtnlogin());
	}
	/**
	 * 
	 * @param username
	 * @param password
	 * @throws AWTException
	 */
	public void loginwithEnter(String username, String password) throws AWTException {

		type(getTxtUserName(), username);
		type(getTxtPassword(), password);
		
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	

}
