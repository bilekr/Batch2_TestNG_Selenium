package com.krafttechnologie.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

public class WebDriverFactory {

    // ***utilities package altında ortak kullanılan metodlar oluşturulacak!!

        // Task write a static method that takes a string parameter name:browserType
        // it will see set up the browser and the method will return chromedriver or firefox driver object
        // name of method: getDriver

    public static WebDriver getDriver(String browserType) {
        WebDriver driver = null;

        switch (browserType.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }

        return driver;
    }


}
