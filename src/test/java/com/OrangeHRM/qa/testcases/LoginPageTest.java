package com.OrangeHRM.qa.testcases;

import com.OrangeHRM.qa.base.TestBase;
import com.OrangeHRM.qa.pages.DashboardPage;
import com.OrangeHRM.qa.pages.LoginPage;

import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	
    public LoginPageTest() {
		super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
		loginPage = new LoginPage();
    }
    
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "OrangeHRM", "Title matched");
	}
    
    @Test(priority=2)
    public void loginPageImageTest() {
    	boolean flag = loginPage.validateHRMImage();
    	Assert.assertTrue(flag);
    }

    @Test(priority=3)
    public void loginTest() {
    	dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    	String dashboardPageTitle = loginPage.validateLoginPageTitle();
    	Assert.assertEquals(dashboardPageTitle, "Failed_OrangeHRM");
    }

    
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
     
}
