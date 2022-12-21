package com.krafttechnologie.tests.day12_Actions_FileUpload_JSExecutor;

import com.krafttechnologie.tests.day11_Waits.ThreadSleep;
import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class JavaScriptExecutor {

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
    public void clickWithJS() throws InterruptedException {

      /*
        Selenium ile çözemediğimiz bazı sorunlarda javascript executor kullanarak çözebiliriz
        clicking, sendKeys, scroll down or scroll up gibi sorunlar

        Javascriptexecutor bir interface old. new keywordu ile yeni bir object oluşturamıyoruz
        bu nedenle driverı casting yaparak kullanıyoruz

       */
        driver.get("https://the-internet.herokuapp.com/floating_menu");

        WebElement button = driver.findElement(By.linkText("Elemental Selenium"));


        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);"
                + "arguments[0].click()", button);
        Thread.sleep(2000);

        System.out.println("Title :" + js.executeScript("return document.title;").toString());
        System.out.println("Url :" + js.executeScript("return document.URL;").toString());

        String CurrentWindowHandle = driver.getWindowHandle();
        Set<String> windowhandles = driver.getWindowHandles();

        for (String handle : windowhandles) {

            if (!handle.equals(CurrentWindowHandle)) {
                driver.switchTo().window(handle);
            }
        }
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        String expectedUrl = "http://elementalselenium.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);

    }


    @Test
    public void testTask() throws InterruptedException {
    /*
    go to  https://selectorshub.com/xpath-practice-page/
    Enter Last name kutusuna soyisim yazdir
    */
        driver.get("https://selectorshub.com/xpath-practice-page/");
        WebElement firstname = driver.findElement(By.xpath("//input[@placeholder='First Enter name']"));
        WebElement lastname = driver.findElement(By.xpath("//input[@placeholder='Enter Last name']"));


        JavascriptExecutor js = (JavascriptExecutor) driver;

        String name = "Ali";
        String surname = "Veli";

        js.executeScript("arguments[0].setAttribute('value', '" + name + "')", firstname);
        js.executeScript("arguments[0].setAttribute('value', '" + surname + "')", lastname);

        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        String expectedUrl="http://elementalselenium.com/";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(actualUrl,expectedUrl);

    }


    @Test
    public void scrollDownAndUp() throws InterruptedException {
    /*
   gexecuteScript("window.scrollBy(0,3000)");

     */
        driver.get("https://www.krafttechnologie.com/");

        JavascriptExecutor js= (JavascriptExecutor) driver;

        Thread.sleep(2000);

        js.executeScript("window.scrollBy(0,1200)"); // scroll sayfanın altına (aşağıya) gitmek için

        Thread.sleep(2000);

        js.executeScript("window.scrollBy(0,-1200)"); // scroll sayfanın başına (yukarıya) gitmek için

        Thread.sleep(2000);

    }
}