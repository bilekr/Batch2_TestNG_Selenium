package com.krafttechnologie.tests.day4_XPath;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XPathWithStartsAndContainsWith {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.hepsiburada.com/");

//        String searchBox=driver.findElement(By.xpath("//input[starts-with(@class,'desktopOld')]")).getText();
        WebElement searchBox = driver.findElement(By.xpath("//div[contains(@class,'SearchBoxOld-cH')]"));

        System.out.println("searchBox = " + searchBox);

        searchBox.sendKeys("Selenium");

        searchBox.click();




    }
}
