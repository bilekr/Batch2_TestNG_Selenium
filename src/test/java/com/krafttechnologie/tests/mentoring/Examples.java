package com.krafttechnologie.tests.mentoring;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Examples {

    @Test
    public void test1() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        Thread.sleep(1000);

        searchBox.sendKeys("Selenium");

        WebElement clickButton = driver.findElement(By.xpath("//div[@class='nav-search-submit nav-sprite']"));

        Thread.sleep(1000);


        clickButton.click();

        WebElement result = driver.findElement(By.xpath("//span[text()='1-48 of 416 results for']"));
        System.out.println("result.getText() = " + result.getText());

        Thread.sleep(1000);

    }
}


