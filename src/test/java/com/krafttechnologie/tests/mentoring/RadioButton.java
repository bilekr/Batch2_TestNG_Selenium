package com.krafttechnologie.tests.mentoring;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButton {

    WebDriver driver;

    @Test
    public void test1() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/forms/radio");
        WebElement clickedButton = driver.findElement(By.cssSelector("#gridRadios1"));
        System.out.println("clickedButton.isSelected() = " + clickedButton.isSelected());
        clickedButton.click();
        driver.quit();
    }


    @Test
    public void test2() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/forms/radio");
        WebElement clickedButton3 = driver.findElement(By.xpath("(//span[.='Alerts'])[1]/../i"));
        Assert.assertFalse(clickedButton3.isDisplayed());
        driver.quit();

    }
}