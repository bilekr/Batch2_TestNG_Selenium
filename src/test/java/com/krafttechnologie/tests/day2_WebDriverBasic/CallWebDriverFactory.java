package com.krafttechnologie.tests.day2_WebDriverBasic;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallWebDriverFactory {
    public static void main(String[] args) throws InterruptedException {

      WebDriver driver = WebDriverFactory.getDriver("chrome"); // baska classtan polymorphism
//    driver.get("https://www.krafttechnologie.com");
//
//    Thread.sleep(2000);

//    driver.close();

        /**
         * Task
         * go to http://www.krafttechexlab.com/  website
         * expected title = Dashboard- Kraft Techex Lab - aFm
         * get title and verify that expected title equal actual title
         */


        driver.get("https://www.krafttechexlab.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        String expectedTitle = "Dashboard- Kraft Techex Lab - aFm";
        System.out.println("expectedTitle = " + expectedTitle);


        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("dogrulama gecti");

        } else {
            System.out.println("dogrulama gecersiz");
        }

    }

}
