package com.krafttechnologie.tests.day1_AutomationIntro_FrameworkSetup;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowser {
    public static void main(String[] args) {
    /*
        1. pom.xml e yüklediğimiz webDriver manager kütüphanesinden chrome u hazır hale getirmesini isteyeceğiz.
        2. Webriver classından driveri hazır hale getirmesini isteyeceğiz.
        3. driver atestini yapacağımız web sayfasına bizi götürmesini isteyeceğiz.

    */

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://www.krafttechnologie.com/");

        driver.manage().window().maximize();

        System.out.println("driver.getTitle() = " + driver.getTitle());

        String expectedTitle="Kraft Technologie | Yazılım ve Bilişim Eğitimleri – Uzaktan Canlı Eğitim";

        String actualTitle= driver.getTitle();

        if (actualTitle.equals(expectedTitle)){
            System.out.println("Baslik beklendigi gibi geldi dogrulama gecti");

        }else {
            System.out.println("Baslik beklendigi gibi gelmedi dogrulama gecmedi");
        }

    }

}
