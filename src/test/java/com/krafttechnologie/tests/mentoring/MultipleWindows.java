package com.krafttechnologie.tests.mentoring;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class MultipleWindows {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.krafttechexlab.com/javascript/opennew");
        WebElement openNewTab = driver.findElement(By.xpath("//a[text()='Open New Tab']"));

        Thread.sleep(1000);
        String firstPage = driver.getWindowHandle(); // gidilen sayfanın id sini verir
        // selenium nosuchelement exc. verdiğinde
        // getwindowhandle(s) metodlarıyla açılan sayfalara geçiş yapılabiliyor

        openNewTab.click();

        Set<String> windowHandles=driver.getWindowHandles();

        for (String windowHandle : windowHandles) {        //*** kısayol: windowHandles.iter ile
            if (!windowHandle.equals(firstPage)){
                driver.switchTo().window(windowHandle); // driverı 2. sayfaya geçirir
                break;
            }
       }


        Thread.sleep(1000);

        String actual=driver.findElement(By.xpath("//h1[.='Alerts']")).getText();
        String expected="Alerts";

       Assert.assertEquals(actual,expected);





    }
}
