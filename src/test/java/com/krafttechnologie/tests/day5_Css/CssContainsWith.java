package com.krafttechnologie.tests.day5_Css;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssContainsWith {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com/");

        WebElement searchBox = driver.findElement(By.cssSelector("input[id*='searchtex']"));

        searchBox.sendKeys("Postman");

        WebElement searchButton = driver.findElement(By.cssSelector("input[type*='mit']"));

        searchButton.click();

        Thread.sleep(2000);

        driver.close();


    }
}
