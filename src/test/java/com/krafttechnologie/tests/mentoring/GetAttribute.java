package com.krafttechnologie.tests.mentoring;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class GetAttribute {

    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/");
        WebElement element = driver.findElement(By.cssSelector("ul#components-nav"));
        System.out.println(element.getAttribute("class"));
        System.out.println(element.getAttribute("outerHTML"));
        driver.quit();
    }

}
