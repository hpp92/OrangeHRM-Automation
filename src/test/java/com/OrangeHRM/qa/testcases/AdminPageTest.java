package com.OrangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.OrangeHRM.qa.base.TestBase;
import com.OrangeHRM.qa.pages.AdminPage;
import com.OrangeHRM.qa.pages.DashboardPage;
import com.OrangeHRM.qa.pages.LoginPage;

public class AdminPageTest extends TestBase {
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	AdminPage adminPage;
	
	//Constructor of the class
	public AdminPageTest() {
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

	// Add test methods here
	@Test(priority=1)
	public void verifyAdminPageTitleTest() {
		adminPage = dashboardPage.clickOnAdminLink();
		String adminPageTitle = adminPage.validateAdminPageTitle();
		Assert.assertEquals(adminPageTitle, "OrangeHRM");
	}
	
	@Test(priority=2)
	public void verifyAdminPageLabelTest() {
		adminPage = dashboardPage.clickOnAdminLink();
		boolean flag = adminPage.verifyAdminPageLabel();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void verifyUserManagementMenuTest() {
		adminPage = dashboardPage.clickOnAdminLink();
		adminPage.clickOnUserManagementMenu();
		adminPage.clickOnUsersMenuItem();
	}
	
	@Test(priority=4)
	public void verifyJobMenuTest() {
		adminPage = dashboardPage.clickOnAdminLink();
		adminPage.clickOnUserManagementMenu();
		adminPage.clickOnUsersMenuItem();
		adminPage.clickOnJobMenuItem();
		adminPage.clickOnJobTitlesMenuItem();
		adminPage.clickOnJobMenuItem();
		adminPage.clickOnPayGradesMenuItem();
		adminPage.clickOnJobMenuItem();
		adminPage.clickOnEmploymentStatusMenuItem();
		adminPage.clickOnJobMenuItem();
		adminPage.clickOnJobCategoriesMenuItem();
		adminPage.clickOnJobMenuItem();
		adminPage.clickOnWorkShiftsMenuItem();
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
