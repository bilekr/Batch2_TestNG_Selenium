package com.krafttechnologie.tests.day4_XPath;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XPathWithText {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.krafttechexlab.com");

        // String text=driver.findElement(By.xpath("//li[text()='All Users Profile']")).getText();
        // String text=driver.findElement(By.xpath("//li[.='All Users Profile']")).getText();
        String text=driver.findElement(By.xpath("//*[text()='All Users Profile']")).getText();
        System.out.println("text = " + text);



    }


}
