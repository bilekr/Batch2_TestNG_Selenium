package com.krafttechnologie.tests.mentoring;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDown {
    WebDriver driver;
    @Test
    public void test1() throws InterruptedException {

        driver.get("https://www.krafttechexlab.com/forms/select");
        WebElement drpMenu= driver.findElement(By.xpath("(//select[@class='form-select'])[1]"));
        Select select=new Select(drpMenu);

        select.selectByIndex(3);
        // select.selectByValue("");
        // select.selectByVisibleText("");

        System.out.println(select.getOptions().size());
        Thread.sleep(3000);

        }
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
