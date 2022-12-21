package com.krafttechnologie.tests.day10_WebElements4;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        // driver.close();
        driver.quit();
    }

    @Test
    public void twoWindows() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");

        String titleBeforeClick=driver.getTitle();
        System.out.println("titleBeforeClick = " + titleBeforeClick);

        WebElement click_here=driver.findElement(By.linkText("Click Here"));
        click_here.click();

        Thread.sleep(2000);

//        String titleAfterClick=driver.getTitle();
//        System.out.println("titleAfterClick = " + titleAfterClick);

        String currentTab = driver.getWindowHandle(); // geçerli tab(window)ın ıd si = title the ınternet and has ID---> CDwindow-578BC014887876CB4C81B58425BAE85A
        System.out.println("currentTab = " + currentTab);

        Set<String> windowHandles=driver.getWindowHandles(); // browserda açık olan tüm pencereler / unique old. set kullanılır

        for (String tab : windowHandles) { // go and check one by one
            if (!tab.equals(currentTab)){  // eger tab current taba eşit değilse
                driver.switchTo().window(tab); // diğer windowa gec
            }
        }
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }

    @Test
    public void multipleWindow() {
        driver.get("https://the-internet.herokuapp.com/windows");
        System.out.println("driver.getTitle() = " + driver.getTitle());

        System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle()); // mevcut current tab

        WebElement click_here=driver.findElement(By.linkText("Click Here"));
        click_here.click();
        click_here.click();
        click_here.click();
        click_here.click();

        Set<String> windowHandles = driver.getWindowHandles(); // diğer tab/gidilecek windowlar
        for (String tab : windowHandles) {
            driver.switchTo().window(tab); // windowlar arası geçiş
            if (driver.getTitle().equals("New Windows")){ // condition sağlanırsa çıkış yap-->
                // stop on this now
                break;
            }
        }
        System.out.println("driver.getTitle() = " + driver.getTitle());
    }
}

