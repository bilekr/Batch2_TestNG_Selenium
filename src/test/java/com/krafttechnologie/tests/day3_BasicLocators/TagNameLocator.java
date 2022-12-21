package com.krafttechnologie.tests.day3_BasicLocators;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TagNameLocator {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

/*
        Thread.sleep(2000);

        WebElement emailInputBox=driver.findElement(By.name("email"));
        emailInputBox.sendKeys("mike@gmail.com");

        Thread.sleep(2000);


        WebElement passwordInputBox=driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("12345");


        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".btn.btn-primary.w-100")).click();

        Thread.sleep(2000);

        driver.close();

        */

        // verify that you are on the dashboard page

        System.out.println("driver.findElement(By.tagName(\"h1\")).getText() = " + driver.findElement(By.tagName("h1")).getText());
        // driver.findElement(By.tagName("h1")).getText() = Dashboard


        // By.tagName

        driver.get("https://the-internet.herokuapp.com/inputs");

        System.out.println(driver.findElement(By.tagName("h3")).getText());
        System.out.println(driver.findElement(By.tagName("p")).getText());

    }
}
