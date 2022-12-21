package com.krafttechnologie.tests.day15_POM;

import com.krafttechnologie.pages.LoginPages;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTest extends TestBase {
    LoginPages loginPages=new LoginPages();
    // Loginpages sınıfından bir object oluşturarak tüm metodlara ulaşıyoruz
    // global erişim noktası oluşturulunca her bir testte ayrıca yazmaya gerek yok!!!

    @Test
    public void wrongPassword() {

        driver.get(ConfigurationReader.get("url"));

        loginPages.userEmailInput_loc.sendKeys(ConfigurationReader.get("username"));
        loginPages.passwordInput_loc.sendKeys("somepassword"); // yanlış giriş
        loginPages.submitButton_loc.click();


/*

    WebElement userNameInput= driver.findElement(By.name("email"));
    WebElement passwordNameInput= driver.findElement(By.name("password"));

    userNameInput.sendKeys(ConfigurationReader.get("username"));
    passwordNameInput.sendKeys("some password");

    driver.findElement(By.xpath("//button[@type='submit']")).click();

    WebElement warningMessage=driver.findElement
            (By.xpath("//*[contains(text(),'Email address or password is incorrect. Please check')]"));

        Assert.assertEquals(warningMessage.getText(),
                "Email address or password is incorrect. Please check",
                "verify that user is not login");
*/


    }


    @Test
    public void wrongUsername() {
        driver.get(ConfigurationReader.get("url"));

        loginPages.userEmailInput_loc.sendKeys("fakename"); // yanlış giriş
        loginPages.passwordInput_loc.sendKeys(ConfigurationReader.get("password"));
        loginPages.submitButton_loc.click();

        String actualMessage=loginPages.warningMessage_loc.getText();
        String expectedMessage="Email address or password is incorrect. Please check";

        Assert.assertEquals(actualMessage,expectedMessage);

    }
}