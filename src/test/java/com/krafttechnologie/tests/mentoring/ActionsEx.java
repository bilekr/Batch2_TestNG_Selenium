package com.krafttechnologie.tests.mentoring;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionsEx {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        // elementi locate edemezsen hemen no such element hatası verme 7 sn daha devam et sonra-->

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {

        driver.get("https://ebay.com");

        Actions actions = new Actions(driver); // driver içine yazılır.

        WebElement electronicBtn = driver.findElement(By.xpath("(//a[.='Electronics'])[2]"));
        actions.moveToElement(electronicBtn).perform(); // elecrtronicBtna git ve çalıştır
        Thread.sleep(5000);


        List<WebElement> elements = driver.findElements(By.xpath("//li[contains(@data-hover-track,'p2481888')]"));
        // ***bütün butonların ortak noktasıyla locate etme ve bir list içine alma
        // ***---findElements--- kullanılacak

        for (WebElement element : elements) {
            actions.moveToElement(element).perform(); // electronicten başlayarak bütün butonları dolaşır
            Thread.sleep(2000);
        }
    }

    @Test
    public void test2() throws InterruptedException {

        driver.get("https://www.krafttechexlab.com/javascript/droppable");

        WebElement element1 = driver.findElement(By.xpath("//p[.='Drag me to my target']")); // draggable
        WebElement element2 = driver.findElement(By.xpath("//p[text()='Drop here']")); // droppable

        Actions actions = new Actions(driver); // driver içine yazılır.
        actions.dragAndDrop(element1, element2).perform(); // element 1 i element 2 ye sürükle ve bırak

        WebElement element3 = driver.findElement(By.xpath("//p[text()='Dropped!']")); // Dropped!
        // actions.clickAndHold(element1).moveToElement(element2).pause(2000).perform(); //*** tıkla ve bekle

        Assert.assertTrue(element3.isDisplayed()); // element 3 görünür mü verify edebiliriz
        Thread.sleep(3000);

    }

}

