package com.OrangeHRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.qa.base.TestBase;

public class DashboardPage extends TestBase {

	// Dashboard label/header
	@FindBy(xpath = "//h6[text()='Dashboard']")
	WebElement dashboardLabel;

	// Admin menu link
	@FindBy(xpath = "//span[text()='Admin']")
	WebElement adminLink;

	// PIM menu link
	@FindBy(xpath = "//span[text()='PIM']")
	WebElement pimLink;

	// Leave menu link
	@FindBy(xpath = "//span[text()='Leave']")
	WebElement leaveLink;

	// Recruitment menu link
	@FindBy(xpath = "//span[text()='Recruitment']")
	WebElement recruitmentLink;

	// My Info menu link
	@FindBy(xpath = "//span[text()='My Info']")
	WebElement myInfoLink;

	// Performance menu link
	@FindBy(xpath = "//span[text()='Performance']")
	WebElement performanceLink;

	// Dashboard menu link (side menu)
	@FindBy(xpath = "//span[text()='Dashboard']")
	WebElement dashboardMenuLink;

	// Directory menu link
	@FindBy(xpath = "//span[text()='Directory']")
	WebElement directoryLink;

	// Maintenance menu link
	@FindBy(xpath = "//span[text()='Maintenance']")
	WebElement maintenanceLink;

	// Claim menu link
	@FindBy(xpath = "//span[text()='Claim']")
	WebElement claimLink;

	// Buzz menu link
	@FindBy(xpath = "//span[text()='Buzz']")
	WebElement buzzLink;

	// Time at Work widget
	@FindBy(xpath = "//p[text()='Time at Work']")
	WebElement timeAtWorkWidget;

	// Employee Distribution by Sub Unit widget
	@FindBy(xpath = "//p[text()='Employee Distribution by Sub Unit']")
	WebElement employeeDistributionWidget;

	// Quick Launch panel
	@FindBy(xpath = "//p[text()='Quick Launch']")
	WebElement quickLaunchPanel;

	// My Actions widget
	@FindBy(xpath = "//p[text()='My Actions']")
	WebElement myActionsWidget;

	// Quick Launch widget
	@FindBy(xpath = "//p[text()='Quick Launch']")
	WebElement quickLaunchWidget;

	// Buzz Latest Posts widget
	@FindBy(xpath = "//p[text()='Buzz Latest Posts']")
	WebElement buzzLatestPostsWidget;

	// Employees on Leave Today widget
	@FindBy(xpath = "//p[text()='Employees on Leave Today']")
	WebElement employeesOnLeaveTodayWidget;

	// Employee Distribution by Sub Unit widget
	@FindBy(xpath = "//p[text()='Employee Distribution by Sub Unit']")
	WebElement employeeDistributionBySubUnitWidget;

	// Employee Distribution by Location widget
	@FindBy(xpath = "//p[text()='Employee Distribution by Location']")
	WebElement employeeDistributionByLocationWidget;

	//Logout link
	@FindBy(xpath="//p[@class='oxd-userdropdown-name']")
	WebElement userProfileDropdown;
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logoutLink;
	
	// Constructor to initialize the page objects
	public DashboardPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public boolean verifyDashboardLabel() {
		return dashboardLabel.isDisplayed();
	}

	// Methods to click on each menu link
	public String getDashboardPageTitle() {
		return driver.getTitle();
	}
	
	//Verify page title
	public String verifyDashboardPageTitle() {
		return getDashboardPageTitle();
	}
	
	// Verify every links presence totally 11 links
	public boolean verifyAllMenuLinks() {
		return adminLink.isDisplayed() && pimLink.isDisplayed() && leaveLink.isDisplayed()
				&& recruitmentLink.isDisplayed() && myInfoLink.isDisplayed() && performanceLink.isDisplayed()
				&& dashboardMenuLink.isDisplayed() && directoryLink.isDisplayed() && maintenanceLink.isDisplayed()
				&& claimLink.isDisplayed() && buzzLink.isDisplayed();
	}

	// Verify Time at Work widget presence
	public boolean verifyTimeAtWorkWidget() {
		return timeAtWorkWidget.isDisplayed();
	}

	// Verify My Actions widget presence
	public boolean verifyMyActionsWidget() {
		return myActionsWidget.isDisplayed();
	}

	// Verify Quick Launch widget presence
	public boolean verifyQuickLaunchWidget() {
		return quickLaunchWidget.isDisplayed();
	}

	// Verify Buzz Latest Posts widget presence
	public boolean verifyBuzzLatestPostsWidget() {
		return buzzLatestPostsWidget.isDisplayed();
	}

	// Verify Employees on Leave Today widget presence
	public boolean verifyEmployeesOnLeaveTodayWidget() {
		return employeesOnLeaveTodayWidget.isDisplayed();
	}

	// Verify Employee Distribution by Sub Unit widget presence
	public boolean verifyEmployeeDistributionWidget() {
		return employeeDistributionWidget.isDisplayed();
	}

	// Verify Quick Launch panel presence
	public boolean verifyQuickLaunchPanel() {
		return quickLaunchPanel.isDisplayed();
	}

	public AdminPage clickOnAdminLink() {
		adminLink.click();		
		return new AdminPage();
	}
	
	public PIMPage clickOnPIMLink() {
		pimLink.click();		
		return new PIMPage();
	}

	public void clickOnUserProfileDropdown() {
		userProfileDropdown.click();		
	}

	public void logoutLink() {
		// TODO Auto-generated method stub
		logoutLink.click();
		
	}
}
