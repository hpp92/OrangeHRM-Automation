package com.OrangeHRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.qa.base.TestBase;

public class AdminPage extends TestBase {
	
	//Page Factory - OR (Obj Repository):
	@FindBy(xpath="//span[text()='Admin']")
	WebElement adminLink;
	
	// Add more elements specific to the Admin page as needed
	@FindBy(xpath="//h6[text()='Admin']")
	WebElement adminPageLabel;
	
	//Usermanagement menu
	@FindBy(className="oxd-topbar-body-nav-tab-item")
	WebElement userManagementMenu;
	
	//Sub-menu items under User Management
	@FindBy(xpath="//a[text()='Users']")
	WebElement usersMenuItem;
	
	//Job menu
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]")
	WebElement jobMenuItem;
	
	//Sub-menu items under Job
	@FindBy(xpath="//a[text()='Job Titles']")
	WebElement jobTitlesMenuItem;
	
	//Label on Job Titles page
	@FindBy(xpath="//h6[text()='Job Titles']")
	WebElement jobTitlesPageLabel;
	
	@FindBy(xpath="//a[text()='Pay Grades']")
	WebElement payGradesMenuItem;
	
	//Label on Pay Grades page
	@FindBy(xpath="//h6[text()='Pay Grades']")
	WebElement payGradesPageLabel;
	
	@FindBy(xpath="//a[text()='Employment Status']")
	WebElement employmentStatusMenuItem;
	
	//Label on Employment Status page
	@FindBy(xpath="//h6[text()='Employment Status']")
	WebElement employmentStatusPageLabel;
	
	@FindBy(xpath="//a[text()='Job Categories']")
	WebElement jobCategoriesMenuItem;

	//Label on Job Categories page
	@FindBy(xpath="//h6[text()='Job Categories']")
	WebElement jobCategoriesPageLabel;
	
	@FindBy(xpath="//a[text()='Work Shifts']")
	WebElement workShiftsMenuItem;
	
	//Label on Work Shifts page
	@FindBy(xpath="//h6[text()='Work Shifts']")
	WebElement workShiftsPageLabel;
	
	//Organization menu
	@FindBy(xpath="//a[text()='Organization']")
	WebElement organizationMenuItem;
	
	//Sub-menu items under Organization
	@FindBy(xpath="//a[text()='General Information']")
	WebElement generalInformationMenuItem;
	
	@FindBy(xpath="//a[text()='Locations']")
	WebElement locationsMenuItem;
	
	@FindBy(xpath="//a[text()='Structure']")
	WebElement structureMenuItem;
	
	//Qualifications menu
	@FindBy(xpath="//a[text()='Qualifications']")
	WebElement qualificationsMenuItem;
	
	//Sub-menu items under Qualifications
	@FindBy(xpath="//a[text()='Skills']")
	WebElement skillsMenuItem;
	
	@FindBy(xpath="//a[text()='Education']")
	WebElement educationMenuItem;
	
	@FindBy(xpath="//a[text()='Licenses']")
	WebElement licensesMenuItem;
	
	@FindBy(xpath="//a[text()='Languages']")
	WebElement languagesMenuItem;
	
	@FindBy(xpath="//a[text()='Memberships']")
	WebElement membershipsMenuItem;
	
	//Nationalities menu
	@FindBy(xpath="//a[text()='Nationalities']")
	//a[text()='Nationalities']
	WebElement nationalitiesMenuItem;
	
	//Corporate Branding menu
	@FindBy(xpath="//a[text()='Corporate Branding']")
	WebElement corporateBrandingMenuItem;
	
	//Configuration menu
	@FindBy(xpath="//a[text()='Configuration']")
	WebElement configurationMenuItem;
	
	//Sub-menu items under Configuration
	@FindBy(xpath="//a[text()='Email Configuration']")
	WebElement emailConfigurationMenuItem;
	
	@FindBy(xpath="//a[text()='Email Subscriptions']")
	WebElement emailSubscriptionsMenuItem;
	
	@FindBy(xpath="//a[text()='Localization']")
	WebElement localizationMenuItem;
	
	@FindBy(xpath="//a[text()='Language Packages']")
	WebElement languagePackagesMenuItem;
	
	@FindBy(xpath="//a[text()='Modules']")
	WebElement modulesMenuItem;
	
	@FindBy(xpath="//a[text()='Social Media Authentication']")
	WebElement socialMediaAuthenticationMenuItem;

	@FindBy(xpath="//a[text()='Register OAuth Client']")
	WebElement registerOAuthClientMenuItem;
	
	@FindBy(xpath="//a[text()='LDAP Import']")
	WebElement ldapImportMenuItem;
	
	@FindBy(xpath="//span[text()='PIM']")
	WebElement pimLink;
	
	//Constructor to initialize the page objects
	public AdminPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public AdminPage clickOnAdminLink() {
		adminLink.click();
		return new AdminPage();
	}
		
	public String validateAdminPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyAdminPageLabel() {
		return adminPageLabel.isDisplayed();
	}
	
	public void clickOnUserManagementMenu() {
		userManagementMenu.click();
	}
	
	public void clickOnUsersMenuItem() {
		usersMenuItem.click();
	}
	
	public void clickOnJobMenuItem() {
		jobMenuItem.click();
	}
	
	public void clickOnJobTitlesMenuItem() {
		jobTitlesMenuItem.click();
	}
	
	public void clickOnJobTitlesPageLabel() {
		jobTitlesPageLabel.isDisplayed();
	}
	
	public void clickOnPayGradesMenuItem() {
		payGradesMenuItem.click();
	}
	
	public void clickOnPayGradesPageLabel() {
		payGradesPageLabel.isDisplayed();
	}
	
	public void clickOnEmploymentStatusMenuItem() {
		employmentStatusMenuItem.click();
	}
	
	public void clickOnEmploymentStatusPageLabel() {
		employmentStatusPageLabel.isDisplayed();
	}
	
	public void clickOnJobCategoriesMenuItem() {
		jobCategoriesMenuItem.click();
	}
	
	public void clickOnJobCategoriesPageLabel() {
		jobCategoriesPageLabel.isDisplayed();
	}
	
	public void clickOnWorkShiftsMenuItem() {
		workShiftsMenuItem.click();
	}
	
	public void clickOnWorkShiftsPageLabel() {
		workShiftsPageLabel.isDisplayed();
	}
	
	public void clickOnOrganizationMenuItem() {
		organizationMenuItem.click();
	}
	public void clickOnGeneralInformationMenuItem() {
		generalInformationMenuItem.click();
	}
	public void clickOnLocationsMenuItem() {
		locationsMenuItem.click();
	}
	public void clickOnStructureMenuItem() {
		structureMenuItem.click();
	}
	public void clickOnQualificationsMenuItem() {
		qualificationsMenuItem.click();
	}
	public void clickOnSkillsMenuItem() {
		skillsMenuItem.click();
	}
	public void clickOnEducationMenuItem() {
		educationMenuItem.click();
	}
	public void clickOnLicensesMenuItem() {
		licensesMenuItem.click();
	}

	public void verifyAdminPageElements() {
		
	}

	public PIMPage clickOnPIMLink() {
		pimLink.click();
		return new PIMPage();
	}
}
