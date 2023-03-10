package com.krafttechnologie.tests.day11_Waits;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitlyWaitExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // *** implicitlywait 20 sn olmasına rağmen gerektiği kadar bekler sürenin tamamını beklemez
        // *** (kac adet olursa olsun) her bir findElement metodu ile birlikte çalışır.
        // driver.manage().window().maximize();
    }


    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void test1() {

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.cssSelector("#checkbox-example>button")).click();
        // driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        // ***implicitlyWait burada sadece yukarıdaki metodla birlikte çalışır.

        WebElement message=  driver.findElement(By.id("message"));
        Assert.assertEquals(message.getText(),"It's gone!");

    }
}
