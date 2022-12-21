package com.krafttechnologie.tests.day8_WebElements2;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.krafttechexlab.com/javascript/clicks");

        List<WebElement> buttons=driver.findElements(By.xpath("//button[@class='btn btn-primary']"));
        // hepsinin ortak noktası class olduğundan xpath te class tercih edildi.
        // çok sayıda element old. liste atılır.
        System.out.println("buttons.size() = " + buttons.size());
        // buttons.size() = 4 -->kaç element old. gösterir

        Assert.assertEquals(buttons.size(),4);

        // hepsini getirip yzdırmak için
        for (WebElement button:buttons) {
            System.out.println(button.getText());
            System.out.println("button.isDisplayed() = " + button.isDisplayed());
        }
        Thread.sleep(2000);
        buttons.get(2).click();

      /*  Right Click Me
        button.isDisplayed() = true
        Double Click Me
        button.isDisplayed() = true
        Click Me
        button.isDisplayed() = true
        Mouse Down / Up
        button.isDisplayed() = true*/


    }


}


