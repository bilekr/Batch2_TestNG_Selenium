package com.krafttechnologie.tests.day3_BasicLocators;

import com.github.javafaker.Faker;
import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdLocatorTest {
    public static void main(String[] args) throws InterruptedException {

        // gercek olmayan (isim-mail-adres vb.) verileri rastgele üreten bir class
        Faker faker=new Faker();

        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();


        // Selenium By Classından gelen By.id/name/className/Css...
        WebElement inputUserName=driver.findElement(By.id("userName"));
        inputUserName.sendKeys(faker.name().firstName());

        Thread.sleep(2000);

        WebElement inputEmail=driver.findElement(By.id("userEmail"));
        inputEmail.sendKeys(faker.internet().emailAddress());

        Thread.sleep(2000);
    }

}
