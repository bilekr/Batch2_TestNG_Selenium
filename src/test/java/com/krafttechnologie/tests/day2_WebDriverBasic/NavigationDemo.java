package com.krafttechnologie.tests.day2_WebDriverBasic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {

        // go to google
        // go to facebook
        // back to google

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.google.com");

        // wait 3 seconds here then move on-senkronizasyon problemini aşmak için thread.sleep kullanılır
        Thread.sleep(3000);

        // navigate().to web sitelerine erişim için kullandığımız bir selenium metodudur.
        // driver.get() ile aynı işlemi yürütür!!!
        driver.navigate().to("https://www.facebook.com");

        driver.navigate().back(); // bir önceki siteye geri getirir

        driver.navigate().forward(); // bir sonraki siteye götürür

        driver.navigate().refresh(); // sayfayı yeniler
    }

}
