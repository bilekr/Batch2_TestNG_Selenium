package com.krafttechnologie.tests.day4_XPath;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XPathWithAnd {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.hepsiburada.com/");

        WebElement searchBox=driver.findElement(By.xpath("//input[@type='text' and @class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']"));
        searchBox.sendKeys("JAVA");

/*
    //test[@test='test']
    //test[.='text']
    //test[text()='test']
    //test[contains(text(),'test')]
    //test[contains(@test,'test')]
    //test[starts-with(text(),'test')]
    //test[starts-with(@test,'test')]
    //test[ends-with(text(),'test')] .. not work with Chrome
    //test[ends-with(@test,'test')] .. not work with Chrome
    /..
    []
    ()[]
     */

    }


}
