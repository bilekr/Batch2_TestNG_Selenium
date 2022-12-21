package com.krafttechnologie.tests.day2_WebDriverBasic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseAndQuit {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.krafttechnologie.com/");

        Thread.sleep(2000);

        driver.close(); // close current tab (geçerli sekmeyi kapatır)

        // go to facebook.com

        driver=new ChromeDriver(); // eğer yeniden tanımlanmazsa close metodundan sonra driver kapatılmış old. yeni sayfa açmaz!!
        // giving new browser tab - eğer açılmazsa "Exception-->NoSuchSessionException: invalid session id" verir.
        driver.get("https://www.facebook.com/");

        Thread.sleep(2000);

        driver.quit(); // close all tabs

    }
}
