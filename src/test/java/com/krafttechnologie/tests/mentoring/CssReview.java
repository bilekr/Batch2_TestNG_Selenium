package com.krafttechnologie.tests.mentoring;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssReview {
    public static void main(String[] args) {


     WebDriverManager.chromedriver().setup();
     WebDriver driver=new ChromeDriver();
     driver.get("https://www.amazon.com");

     WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
     searchBox.sendKeys("Selenium");

     WebElement clickBtn=driver.findElement(By.xpath("//input[@id=nav-search-submit-button]"));
     clickBtn.click();

     WebElement text = driver.findElement(By.cssSelector(".a-color-state.a-text-bold"));
     System.out.println("text.getText() = " + text.getText());


        // *** en sık kullanılan css kısayolları
        // attribute-value kullanabilir text i kullanamaz
        // .class ile class içindeki boşluklara . konularak kolaylıkla locate edilebilir.
        // syntaxi xpath den daha yalındır. -----> parent to child

        /*CSS:
        (tagName)#id
                (tagName).class
        (tagName)[attribute='value']
        (tagName)[attribute^='tes']
        (tagName)[attribute$='est']
        (tagName)[attribute*='test-contains']
                <css>:nth-of-type(index)
                --> parent to child
        ' ' --> parent to the any son of child
        */



    }
}
