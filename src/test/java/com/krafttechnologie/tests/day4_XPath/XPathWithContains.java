package com.krafttechnologie.tests.day4_XPath;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XPathWithContains {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com");
        String text=driver.findElement(By.xpath("//li[contains(text(),'Users')]")).getText();
        System.out.println("text = " + text);


    }
}
