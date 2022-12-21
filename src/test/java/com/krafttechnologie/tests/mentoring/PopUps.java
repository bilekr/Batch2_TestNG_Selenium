package com.krafttechnologie.tests.mentoring;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class PopUps {

    WebDriver driver;
    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.krafttechexlab.com/javascript/alerts");
        WebElement clickBtn = driver.findElement(By.cssSelector("#myBtnClick"));
        Thread.sleep(1000);
        clickBtn.click();
        Thread.sleep(3000);
        Alert alert=driver.switchTo().alert();
        alert.accept();

        // accept(), dismiss() ve sendKeys() -->alert methods
        // "ok"  -  "ok/cancel" - "enter text"



    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://www.krafttechexlab.com/javascript/alerts");
        // 1 .yol
        List<WebElement> elements=driver.findElements(By.xpath("//button[text()='Click Me']"));
        elements.get(2).click();
        // 2. yol
        // driver.findElement(By.xpath("(//button[text()='Click Me'])[2]")).click();

        Thread.sleep(2000);
        Alert alert=driver.switchTo().alert();
        alert.dismiss();


    }

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
