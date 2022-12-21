package com.krafttechnologie.tests.day4_XPath;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RelativeXPath {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.hepsiburada.com");

          WebElement text=driver.findElement(By.xpath("(//a[@href='https://www.hepsiburada.com/cozummerkezi'])[1]"));


    }


}
