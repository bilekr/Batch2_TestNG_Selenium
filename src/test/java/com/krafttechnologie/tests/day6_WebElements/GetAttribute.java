package com.krafttechnologie.tests.day6_WebElements;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetAttribute {
    public static void main(String[] args) throws InterruptedException {

        // two ways to get text from web elements
        // 1. get.text() ---> it will work %99 it will return string
        // 2. getAttribute(attribute name) ---> second way of getting text especially inputBox


        String email = "mike@gmail.com";

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        Thread.sleep(1000);

        WebElement emailInputBox = driver.findElement(By.id("email"));
//        emailInputBox.sendKeys("mike@gmail.com");

        Thread.sleep(2000);

        String value = emailInputBox.getAttribute("class"); // class represents attribute name of email
        System.out.println("value = " + value); // gettext gibi sonuc alınabilir

        Thread.sleep(2000);

        driver.close();


    }
}
