package com.krafttechnologie.tests.day4_XPath;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XPathWithOr {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.hepsiburada.com/");

        WebElement searchBox=driver.findElement(By.xpath("//input[@type='xyztext' or @class='desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b']"));

        searchBox.sendKeys("JIRA");
        searchBox.click();
    }

}
