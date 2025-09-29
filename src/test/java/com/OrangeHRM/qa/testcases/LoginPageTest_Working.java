package com.OrangeHRM.qa.testcases;

import com.OrangeHRM.qa.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageTest_Working extends TestBase {

    public LoginPageTest_Working() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
    }

    @Test
    public void loginFailTest() {
        // Intentionally failing: element not present
        driver.findElement(By.id("wrongElementId")).click();
        Assert.assertTrue(false, "Forcing failure to check screenshot in report");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
