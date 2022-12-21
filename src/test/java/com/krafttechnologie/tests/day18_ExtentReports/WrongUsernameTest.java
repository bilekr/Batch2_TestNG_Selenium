package com.krafttechnologie.tests.day18_ExtentReports;

import com.krafttechnologie.pages.LoginPages;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WrongUsernameTest extends TestBase {

    @Test
    public void wrongUsername(){

        LoginPages loginPages=new LoginPages();

        extentLogger= report.createTest("Wrong Username Test");

        BrowserUtils.waitFor(1);

        extentLogger.info("Enter Wrong Username");
        loginPages.userEmailInput_loc.sendKeys("michael@gmail.com"); // yanlış giriş olacak

        extentLogger.info("Enter Correct Password");
        loginPages.passwordInput_loc.sendKeys(ConfigurationReader.get("password"));

        extentLogger.info("Click Login Button");
        loginPages.submitButton_loc.click();

        String actualMessage=loginPages.warningMessage_loc.getText();

        extentLogger.info("Verify that NOT Login");
        Assert.assertEquals(actualMessage, "Email address or password is incorrect. Please check");

        extentLogger.pass("PASSED");
    }

    @Test
    public void wrongUserPassword(){

        LoginPages loginPages=new LoginPages();

        extentLogger= report.createTest("Wrong Password Test");

        BrowserUtils.waitFor(1);

        extentLogger.info("Enter Correct Username");
        loginPages.userEmailInput_loc.sendKeys(ConfigurationReader.get("userEmail"));

        extentLogger.info("Enter Wrong Password");
        loginPages.passwordInput_loc.sendKeys("abcde");

        extentLogger.info("Click Login Button");
        loginPages.submitButton_loc.click();

        String actualMessage=loginPages.warningMessage_loc.getText();

        extentLogger.info("Verify that NOT Login");
        Assert.assertEquals(actualMessage, "QQQEmail address or password is incorrect. Please check");

        extentLogger.pass("PASSED");
    }

}
