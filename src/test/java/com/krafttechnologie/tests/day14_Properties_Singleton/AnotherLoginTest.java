package com.krafttechnologie.tests.day14_Properties_Singleton;

import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ConfigurationReader;
import com.krafttechnologie.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AnotherLoginTest extends TestBase {
             // Class TestBase'e extend olunca onun metodlarını direkt olarak kullanabilir.

    // Class task: go to url-enter username-enter password-click login button

    @Test
    public void task (){

        driver.get(ConfigurationReader.get("url"));
        driver.findElement(By.name("email")).sendKeys(ConfigurationReader.get("username"));
        driver.findElement(By.name("password")).sendKeys(ConfigurationReader.get("password") + Keys.ENTER);

      }
}
