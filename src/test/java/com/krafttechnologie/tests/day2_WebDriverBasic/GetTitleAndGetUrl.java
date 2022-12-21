package com.krafttechnologie.tests.day2_WebDriverBasic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTitleAndGetUrl {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://www.krafttechnologie.com/");

        driver.manage().window().maximize();

        // getTitle - başlık alma
        String title=driver.getTitle();
        System.out.println("title = " + title);

        // get url from browser - browserdan url alma
        String currentUrl=driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        // get the source of page - sayfanın kaynak kodunu alma

        String pageSource= driver.getPageSource();
        System.out.println("pageSource = " + pageSource); // html kodları
    }
}
