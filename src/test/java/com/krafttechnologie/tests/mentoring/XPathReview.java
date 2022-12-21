package com.krafttechnologie.tests.mentoring;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class XPathReview {
    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://www.amazon.com");

        driver.manage().window().maximize();

    // *** en sık kullanılan xpath kısayolları
        // attribute-value ve text i kullanabilir
    /*
    //test[@test='test'] ------------- 1*
    //test[.='text']        ---------- 2**
    //test[text()='test']   ---------- 3***
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
