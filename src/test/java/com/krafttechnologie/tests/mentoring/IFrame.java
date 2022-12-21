package com.krafttechnologie.tests.mentoring;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrame {
    // html içinde html
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.krafttechexlab.com/components/iframe");

        // driver.switchTo().frame(0); // int: 0. index unique ise kullanılabilir

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Iframe Example']")));

        driver.findElement(By.xpath("(//button[@class='btn-close'])[1]")).click();
        Thread.sleep(1000);

    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("https://demoqa.com/nestedframes");
        driver.switchTo().frame("frame1");
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']")));
        System.out.println(driver.findElement(By.xpath("//p[.='Child Iframe']")).getText());

    }
}