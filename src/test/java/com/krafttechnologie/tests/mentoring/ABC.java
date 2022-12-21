package com.krafttechnologie.tests.mentoring;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ABC {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("");


        Thread.sleep(2000);


     /*   String expected="";
        String actual= ;
        System.out.println("actual = " + actual);

        Assert.assertEquals(actual, expected);*/

    }



}
