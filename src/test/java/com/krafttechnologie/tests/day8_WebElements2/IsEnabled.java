package com.krafttechnologie.tests.day8_WebElements2;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IsEnabled {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test(){
        driver.get("https://www.krafttechexlab.com/forms/checkbox");
        // WebElement checkBox= driver.findElement(By.cssSelector("#gridCheck3"));
        WebElement checkBox= driver.findElement(By.cssSelector("#gridCheck2"));

        // checkBox.isEnabled() = false
        // Assert.assertFalse(checkBox.isEnabled(),"failed"); // disabled ise bu sekilde olur

        System.out.println("checkBox.isEnabled() = " + checkBox.isEnabled());
        Assert.assertTrue(checkBox.isEnabled(),"passed");


    }

}
