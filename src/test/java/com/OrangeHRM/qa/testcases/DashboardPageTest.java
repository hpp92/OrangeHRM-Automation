package com.OrangeHRM.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.*;

import com.OrangeHRM.qa.base.TestBase;
import com.OrangeHRM.qa.pages.DashboardPage;
import com.OrangeHRM.qa.pages.LoginPage;

public class DashboardPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	//Constructor of the class
	public DashboardPageTest() {
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
	public void verifyDashboardPageTitleTest() {
		String dashboardPageTitle = dashboardPage.verifyDashboardPageTitle();
		Assert.assertEquals(dashboardPageTitle, "OrangeHRM", "Dashboard Page Title Matched");
	}

	//Verify Dashboard label/header
	@Test(priority=2)
	public void verifyDashboardLabelTest() {
		boolean flag = dashboardPage.verifyDashboardLabel();
		Assert.assertTrue(flag);
	}
	
	//Verify Admin menu link
	@Test(priority=3)
	public void verifyAllMenuLinks() {
		boolean flag = dashboardPage.verifyAllMenuLinks();
		Assert.assertTrue(flag);
	}
	
	//Verify Time at Work widget
	@Test(priority=4)
	public void verifyTimeAtWorkWidgetTest() {
		boolean flag = dashboardPage.verifyTimeAtWorkWidget();
		Assert.assertTrue(flag);
	}
	
	//Verify My Actions widget
	@Test(priority=5)
	public void verifyMyActionsWidgetTest() {
		boolean flag = dashboardPage.verifyMyActionsWidget();
		Assert.assertTrue(flag);
	}
	
	//Verify Quick Launch widget
	@Test(priority=6)
	public void verifyQuickLaunchWidgetTest() {
		boolean flag = dashboardPage.verifyQuickLaunchWidget();
		Assert.assertTrue(flag);
	}
	
	//Verify Buzz Latest Posts widget
	@Test(priority=7)
	public void verifyBuzzLatestPostsWidgetTest() {
		boolean flag = dashboardPage.verifyBuzzLatestPostsWidget();
		Assert.assertTrue(flag);
	}
	
	//Verify Employees on Leave Today widget
	@Test(priority=8)
	public void verifyEmployeesOnLeaveTodayWidgetTest() {
		boolean flag = dashboardPage.verifyEmployeesOnLeaveTodayWidget();
		Assert.assertTrue(flag);
	}
	
	//Verify Employee Distribution by Sub Unit widget
	@Test(priority=9)
	public void verifyEmployeeDistributionWidgetTest() {
		boolean flag = dashboardPage.verifyEmployeeDistributionWidget();
		Assert.assertTrue(flag);
	}
	
	//Verify Quick Launch panel
	@Test(priority=10)
	public void verifyQuickLaunchPanelTest() {
		boolean flag = dashboardPage.verifyQuickLaunchPanel();
		Assert.assertTrue(flag);
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		//Logout and close the browser
		dashboardPage.clickOnUserProfileDropdown();
		dashboardPage.logoutLink();
		driver.close();
		driver.quit();
	}
}
