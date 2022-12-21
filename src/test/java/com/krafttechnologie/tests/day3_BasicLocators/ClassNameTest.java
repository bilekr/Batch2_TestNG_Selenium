package com.krafttechnologie.tests.day3_BasicLocators;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClassNameTest {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com/login");

        driver.manage().window().maximize();


        Thread.sleep(2000);

        WebElement emailInputBox=driver.findElement(By.name("email"));
        emailInputBox.sendKeys("mike@gmail.com");
        // ***sendKeys() değeri yazdırmak için kullanılır!!

        Thread.sleep(2000);


        WebElement passwordInputBox=driver.findElement(By.name("password"));
        passwordInputBox.sendKeys("12345");



        Thread.sleep(2000);

        driver.findElement(By.cssSelector(".btn.btn-primary.w-100")).click();

        Thread.sleep(2000);


        // By.clasName
        System.out.println(driver.findElement(By.className("col-md-4")).getText());

        Thread.sleep(2000);

        driver.close();
    }
}
