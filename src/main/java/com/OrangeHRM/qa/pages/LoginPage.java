package com.OrangeHRM.qa.pages;

//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory - OR (Obj Repository):
	@FindBy(name="username")
	@CacheLookup
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(className="oxd-button")
	WebElement loginBtn;
	
	@FindBy(className="orangehrm-login-branding")
	WebElement orangeHRMLogo;
	
	@FindBy(className="orangehrm-login-footer")
	WebElement orangeHRMFooter;
	
	@FindBy(linkText="Forgot your password?")
	WebElement forgotPwdLink;
	
	//Logout link
	@FindBy(xpath="//p[@class='oxd-userdropdown-name']")
	WebElement userProfileDropdown;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logoutLink;
	
	// Constructor to initialize the page objects
	public LoginPage() {
	    PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateHRMImage() {
		return orangeHRMLogo.isDisplayed();
	}
	
	public boolean validateFooter() {
		return orangeHRMFooter.isDisplayed();
	}
	
	public boolean validateForgotPwdLink() {
		return forgotPwdLink.isDisplayed();
	}
	
	//Logout method
	public void logoutLink() {
		userProfileDropdown.click();
		logoutLink.click();
	}
	
	public DashboardPage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new DashboardPage();
	}
	
}
