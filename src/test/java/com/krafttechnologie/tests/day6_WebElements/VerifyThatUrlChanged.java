package com.krafttechnologie.tests.day6_WebElements;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyThatUrlChanged {
    /**
     *         open chrome browser
     *          go to https://www.krafttechexlab.com/login
     *         enter email as mike@gmail.com
     *         enter password as 12345
     *         click login btn
     *         verify that Url has changed
     */

    public static void main(String[] args) throws InterruptedException {
        // variable oluşturmak için üst satırlar kullanılmalı!!
        String email="mike@gmail.com";
        String password="12345";

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");


        String expectedURL=driver.getCurrentUrl();
        System.out.println("expectedURL = " + expectedURL);
        Thread.sleep(1000);

        WebElement emailInputBox=driver.findElement(By.id("email"));
        emailInputBox.sendKeys("mike@gmail.com");

//        WebElement passwordInputBox= driver.findElement(By.id("yourPassword")); **** id önceliklidir.
        WebElement passwordInputBox= driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("12345");

        WebElement loginBtn=driver.findElement(By.xpath("//button[.='Login']"));
        loginBtn.click();

        String actualURL=driver.getCurrentUrl();
        System.out.println("actualURL = " + actualURL);
        Thread.sleep(1000);

        if(expectedURL.equals(actualURL)){
            System.out.println("NOT CHANGED");
        }else{
            System.out.println("CHANGED");
        }

        driver.close();
    }
}
