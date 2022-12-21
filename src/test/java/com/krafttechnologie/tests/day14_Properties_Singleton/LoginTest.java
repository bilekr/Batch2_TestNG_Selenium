package com.krafttechnologie.tests.day14_Properties_Singleton;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.LoginPages;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ConfigurationReader;
import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    LoginPages loginPages=new LoginPages();
    DashboardPage dashboardPage=new DashboardPage();


    @Test
    public void openBrowserUsingConfigurationReader (){

        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.name("email"))
                .sendKeys(ConfigurationReader.get("username"));
        driver.findElement(By.name("password"))
                .sendKeys(ConfigurationReader.get("password")
                        + Keys.ENTER);
                        // ***Selenium-->Keys Classı Enter: click yapar

        // actions.
        // wait.until(ExpectedConditions.visibilityOf(locator))

    }
    @Test
    public void loginWithMethod(){

        loginPages.loginUser();
        // sadece bir method ile login için gerekli username-password ve submit buttonuna direkt olarak erişim sağlanır.

        String actualTitle= dashboardPage.DashboardPageTitle("Dashboard");
        String expectedTitle="Dashboard";
        System.out.println(actualTitle);

        Assert.assertEquals(actualTitle,expectedTitle);

    }


}
