package com.krafttechnologie.tests.mentoring;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSWork {

    // click
    // sendKeys
    // scrollUp - scrollDown

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
        driver.get("https://www.ebay.com/");
        WebElement element = driver.findElement(By.cssSelector("#gh-ug>a"));
        // element.click();

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click;",element); // js ın click metodu


        Thread.sleep(2000);


        String expected="Security Measure";
        String actual=driver.getTitle();
        System.out.println("actual = " + actual);

        Assert.assertEquals(actual,expected);

        Thread.sleep(5000);

/*

        WebElement checkBox=driver.findElement(By.cssSelector("#checkbox"));
        js.executeScript("arguments[0].click;",checkBox);
        checkBox.click();
*/

    }

    @Test
    public void scrollDown() throws InterruptedException {
        driver.get("https://www.ebay.com/");

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)"); // 1000 birim aşağıya js ın scrolldown metodu

        Thread.sleep(2000);

        js.executeScript("window.scrollBy(0,-500)"); // 500 birim yukarı js ın scrollup metodu

        Thread.sleep(2000);

        js.executeScript("window.scrollBy(300,0)"); // 300 birim sağa götür.

        Thread.sleep(2000);

        js.executeScript("window.scrollBy(0,-200)"); // 200 birim sola götür

        Thread.sleep(2000);

    }
}
