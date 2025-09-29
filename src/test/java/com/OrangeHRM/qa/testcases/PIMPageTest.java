package com.OrangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.qa.base.TestBase;
import com.OrangeHRM.qa.pages.DashboardPage;
import com.OrangeHRM.qa.pages.LoginPage;
import com.OrangeHRM.qa.pages.PIMPage;

public class PIMPageTest extends TestBase {
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	PIMPage adminPage;
	PIMPage pimPage;
	
	//Constructor of the class
	public PIMPageTest() {
		super();
	}

	//initialize objects and variables
	@BeforeMethod
	public void setUp() {
		//initialize the browser and open the application
		initialization();
		loginPage = new LoginPage();
		dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyPIMPageTitleTest() {
		pimPage = dashboardPage.clickOnPIMLink();
		String pimPageTitle = pimPage.validatePIMPageTitle();
		Assert.assertEquals(pimPageTitle, "OrangeHRM");	
	}

	//Verify PIM label/header
	@Test(priority=2)
	public void verifyPIMLabelTest() {
		pimPage = dashboardPage.clickOnPIMLink();
		boolean flag = pimPage.verifyPIMLabel();
		Assert.assertTrue(flag);
	}
	
	//Click on Configuration dropdown and verify the links
	@Test(priority=3)
	public void verifyConfigurationDropdownLinksTest() throws InterruptedException {
		pimPage = dashboardPage.clickOnPIMLink();
		pimPage.clickOnConfigurationLink();
		pimPage.clickOnOptionalFieldsLink();
		pimPage.clickOnConfigurationLink();
		pimPage.clickOnCustomFieldsLink();
		pimPage.clickOnConfigurationLink();
		pimPage.clickOnDataImportLink();
		pimPage.clickOnConfigurationLink();
		pimPage.clickOnReportingMethodsLink();
		pimPage.clickOnConfigurationLink();
		pimPage.clickOnTerminationReasonsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		//Logout and close the browser
		dashboardPage.clickOnUserProfileDropdown();
		dashboardPage.logoutLink();
		driver.close();
		driver.quit();
	}

}
