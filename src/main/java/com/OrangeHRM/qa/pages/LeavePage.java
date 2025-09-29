package com.OrangeHRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.qa.base.TestBase;

public class LeavePage extends TestBase {
	
	//Page Factory - OR:
	@FindBy(xpath="//h6[text()='Leave']")
	WebElement leaveLabel;
	
	//Click on Apply link from menu
	@FindBy(xpath="//span[text()='Apply']")
	WebElement applyLink;

	//Click on My Leave link from menu
	@FindBy(xpath="//a[text()='My Leave']")
	WebElement myLeaveLink;
	
	//Click on My Entitlements link from menu
	@FindBy(xpath="//a[text()='Entitlements']")
	WebElement entitlementsLink;
	
	//Click on Reports link from menu
	@FindBy(xpath="//a[text()='Reports']")
	WebElement reportsLink;
	
	//Click on Configure link from menu
	@FindBy(xpath="//span[text()='Configure ']")
	WebElement configureLink;
	
	//Click on Leave Types link under Configure
	@FindBy(xpath="//a[text()='Leave Types']")
	WebElement leaveTypesLink;
	
	//Click on Work Week link under Configure
	@FindBy(xpath="//a[text()='Work Week']")
	WebElement workWeekLink;
	
	//Click on Holidays link under Configure
	@FindBy(xpath="//a[text()='Holidays']")
	WebElement holidaysLink;
	
	//Click on Leave Periods link under Configure
	@FindBy(xpath="//a[text()='Leave Periods']")
	WebElement leavePeriodsLink;
	
	//Click on Leave List link from menu
	@FindBy(xpath="//a[text()='Leave List']")
	WebElement leaveListLink;
	
	//Click on Assign Leave link from menu
	@FindBy(xpath="//a[text()='Assign Leave']")
	WebElement assignLeaveLink;
	
	//initialize the page objects
	public LeavePage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String verifyLeavePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyLeaveLabel() {
		return leaveLabel.isDisplayed();
	}
	
	public void clickOnApplyLink() {
		applyLink.click();
	}
	
	public void clickOnMyLeaveLink() {
		myLeaveLink.click();
	}

	public void clickOnEntitlementsLink() {
		entitlementsLink.click();
	}
	public void clickOnReportsLink() {
		reportsLink.click();
	}
	public void clickOnConfigureLink() {
		configureLink.click();
	}
	public void clickOnLeaveTypesLink() {
		leaveTypesLink.click();
	}
	public void clickOnWorkWeekLink() {
		workWeekLink.click();
	}
	public void clickOnHolidaysLink() {
		holidaysLink.click();
	}
	
}
