package com.krafttechnologie.tests.mentoring;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FileUploadEx {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {

        driver.get("https://demoqa.com/upload-download");
        WebElement element = driver.findElement(By.cssSelector("#uploadFile"));

        element.sendKeys("C:\\Users\\Win10\\Desktop\\UZMAN ÖĞRETMENLİK.pdf");

        Thread.sleep(2000);
        WebElement element2 = driver.findElement(By.cssSelector("#uploadedFilePath"));

        String expected="C:\\fakepath\\UZMAN ÖĞRETMENLİK.pdf";
        String actual=element2.getText();

        Assert.assertEquals(actual,expected);

    }


}
