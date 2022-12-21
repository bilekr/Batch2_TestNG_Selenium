package com.krafttechnologie.tests.day4_XPath;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class AbsoluteXPath {
    public static void main(String[] args) {


        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://www.krafttechexlab.com");
        driver.manage().window().maximize();

        String actualText=driver.findElement(By.xpath("/html/body/main/div/h1")).getText();
        System.out.println("actualText = " + actualText);

    }

}
