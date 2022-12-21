package com.krafttechnologie.tests.day14_Properties_Singleton;

import com.krafttechnologie.utilities.ConfigurationReader;
import com.krafttechnologie.utilities.Driver;
import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SingletonTest {
//    @Test
//    public void test1(){
//        // Singleton singleton=new Singleton(); //private old. izin vermez
//        String driver=Singleton.getInstance(); // Singleton classından yeni bir object oluşturmadan birer örnek getirir
//        String driver2=Singleton.getInstance();
//
//        System.out.println(driver);
//        System.out.println(driver2);
//
//    }
//
//    @Test
//    public void test2(){
//        // WebDriver driver= WebDriverFactory.getDriver("chrome"); // 1.yol
//        WebDriver driver= Driver.get(); // ***2. ve yeni yol utilities den Driver metodunu çağırıyoruz..
//        driver.get(ConfigurationReader.get("url"));
//
//    }
    @Test
    public void test3() throws InterruptedException {
        // WebDriver driver= WebDriverFactory.getDriver("chrome");
        WebDriver driver= Driver.get();
        driver.get("https://www.krafttechexlab.com/login");
        Thread.sleep(2000);
        Driver.closeDriver();
    }

    @Test
    public void test4(){
        // WebDriver driver= WebDriverFactory.getDriver("chrome");
        WebDriver driver= Driver.get();
        driver.get("https://www.amazon.com");
    }
}
