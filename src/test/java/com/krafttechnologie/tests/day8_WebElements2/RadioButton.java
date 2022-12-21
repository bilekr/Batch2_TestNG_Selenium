package com.krafttechnologie.tests.day8_WebElements2;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButton {
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
        driver.get("https://www.krafttechexlab.com/forms/radio");

        WebElement RadioButton1= driver.findElement(By.cssSelector("#gridRadios1"));
        WebElement RadioButton2= driver.findElement(By.cssSelector("#gridRadios2"));

        System.out.println("RadioButton1.isSelected() = " + RadioButton1.isSelected());
        System.out.println("RadioButton2.isSelected() = " + RadioButton2.isSelected());

        // RadioButton1.isSelected() = true
        // RadioButton2.isSelected() = false

//        Thread.sleep(2000);
//        RadioButton2.click(); Buuton 2 ye tıklamak için click yapıyoruz
//          Radio buttonda bir click yapıldığında diğerindeki click ortadan kalkar tek click yapılabilir.

        // Assertion lar beklenen sonuca göre yazılır
        Assert.assertTrue(RadioButton1.isSelected(),"FAIL");
        Assert.assertFalse(RadioButton2.isSelected(),"PASS");

    }


}



