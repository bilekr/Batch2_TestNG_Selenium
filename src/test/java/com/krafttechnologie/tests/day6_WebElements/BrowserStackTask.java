package com.krafttechnologie.tests.day6_WebElements;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrowserStackTask {
    public static void main(String[] args) {
        /** Class Task
         *  go to the url -  "https://www.browserstack.com/users/sign_up"
         *  maximize the window
         *  accept cookies if any ,
         *  fill in the blanks with the faker class
         *  click "Term of service" checkbox
         *  and close the window
         *
         *  hint: u can use any locator you want
         *
         */



        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.browserstack.com/users/sign_up");
        driver.manage().window().maximize();
        WebElement clickCookies = driver.findElement(By.cssSelector("#accept-cookie-notification"));
        clickCookies.click();


        Faker faker=new Faker();






    }


}
