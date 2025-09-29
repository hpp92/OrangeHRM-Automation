package com.OrangeHRM.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.qa.base.TestBase;

public class PIMPage extends TestBase {
	
	//Page Factory - OR:
	@FindBy(xpath="//h6[text()='PIM']")
	WebElement pimLabel;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addEmployeeButton;
	
	//Configuration dropdown link
	@FindBy(xpath="//span[text()='Configuration ']")
	WebElement configurationLink;
	
	//Optional Fields link under Configuration dropdown
	@FindBy(xpath="//a[text()='Optional Fields']")
	WebElement optionalFieldsLink;

	//Custom Fields under Configuration dropdown
	@FindBy(xpath="//a[text()='Custom Fields']")
	WebElement customFieldsLink;
	
	//Custom Fields link under Configuration dropdown
	@FindBy(xpath="//a[@href='/web/index.php/pim/viewEmployeeIdSettings']")
	WebElement employeeIdSettingsLink;
	
	//Data Import link under Configuration dropdown
	@FindBy(xpath="//a[text()='Data Import']")
	WebElement dataImportLink;
	
	//Reporting Methods link under Configuration dropdown
	@FindBy(xpath="//a[text()='Reporting Methods']")
	WebElement reportingMethodsLink;

	//Termination Reasons link under Configuration dropdown
	@FindBy(xpath="//a[text()='Termination Reasons']")
	WebElement terminationReasonsLink;
	
	//initialize the page objects
	public PIMPage() {
		super();
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String verifyPIMPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyPIMLabel() {
		return pimLabel.isDisplayed();
	}
	
	public void clickOnConfigurationLink() {
		configurationLink.click();
	}
	
	public void clickOnAddEmployeeButton() {
		addEmployeeButton.click();
	}
	
	public void clickOnCustomFieldsLink() {
		customFieldsLink.click();
	}
	
	public void clickOnOptionalFieldsLink() {
		optionalFieldsLink.click();
	}
	
	public void clickOnEmployeeIdSettingsLink() {
		employeeIdSettingsLink.click();
	}
	
	public void clickOnDataImportLink() {
		dataImportLink.click();
	}
	
	public void clickOnReportingMethodsLink() {
		reportingMethodsLink.click();
	}
	
	public void clickOnTerminationReasonsLink() {
		terminationReasonsLink.click();
	}

	public String validateAdminPageTitle() {
		return driver.getTitle();
	}

	public String validatePIMPageTitle() {
		return driver.getTitle();
	}	
}
