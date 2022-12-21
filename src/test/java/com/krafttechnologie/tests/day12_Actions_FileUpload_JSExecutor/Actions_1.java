package com.krafttechnologie.tests.day12_Actions_FileUpload_JSExecutor;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;




public class Actions_1 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void doubleClick() throws InterruptedException {
        // Action class ileri düzey etkileşimler sunar.
        //*** (mouse hareketleri) doubleClick, dragAndDrop, hover, rightClick vb.
        // Action class seleniumdan gelir. Webdriver constructor gibi parametre olarak atanır.
        // Çünkü driverı browserla etkileşime geçebilmesi için
        // perform()---> actionı tamamalamak için kullanılır.


        driver.get("https://webdriveruniversity.com/Actions/index.html");
        WebElement ciftclick = driver.findElement(By.id("double-click"));
        Actions actions = new Actions(driver); // Action sınıjfından object oluşturuldu
        Thread.sleep(2000);
        actions.doubleClick(ciftclick).perform(); // doubleclick metodunun içine web element atıldı
        // perform ile kod çalıştırıldı.
        Thread.sleep(2000);


    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        // tut-sürükle--->bırak-taşı

        driver.get("https://webdriveruniversity.com/Actions/index.html");
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver); // Action sınıjfından object oluşturuldu
        Thread.sleep(2000);

        actions.dragAndDrop(draggable, droppable).perform(); //tut-sürükle-->source(draggable) - bırak-taşı--->target(droppable)

        Thread.sleep(2000);


    }

    /*
     go to  https://www.krafttechexlab.com/javascript/droppable
     Drag Me to my target elementini Drop here elementinin uzerine surukle birak

     */
    @Test
    public void test() throws InterruptedException {

        driver.get("https://www.krafttechexlab.com/javascript/droppable");
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);

        Thread.sleep(2000);

        actions.dragAndDrop(source, target).perform();

        String expected = "Dropped!";
        String actual = target.getText();
        System.out.println("actual = " + actual);

        Assert.assertEquals(actual, expected);

        Thread.sleep(2000);
    }

    @Test
    public void hover() throws InterruptedException {

        driver.get("https://webdriveruniversity.com/Actions/index.html");

        WebElement hoverMe = driver.findElement(By.xpath(" (//button[@class='dropbtn'])[1]"));
        WebElement link1 = driver.findElement(By.xpath(" (//a[.='Link 1'])[1]"));
        Thread.sleep(2000);
        Actions actions = new Actions(driver);

        actions.moveToElement(hoverMe).perform(); // movetoelement metodu ile kullanılır. mouse a webelemente doğru git komutu verir

        Thread.sleep(2000);

        Assert.assertTrue(link1.isDisplayed());

        link1.click();

        Alert alert = driver.switchTo().alert();
        System.out.println("alert.getText() = " + alert.getText());

        String actualText = alert.getText();
        String expectedText = "Well done you clicked on the link!";

        Assert.assertEquals(actualText, expectedText);

        Thread.sleep(2000);

        alert.accept();

        Thread.sleep(2000);
    }


    @Test
    public void test2() throws InterruptedException {

        /*
        go to  https://www.krafttechexlab.com/components/tooltips
        Tooltip on top elementine hover yap
        sonrasinda diger elementleri de tek tek hover yap
         */

        driver.get("https://www.krafttechexlab.com/components/tooltips%22");

        WebElement hovertool= driver.findElement(By.xpath("(//button[@class='btn btn-secondary'])[1]"));

        WebElement ontop= driver.findElement(By.xpath("//button[@data-bs-placement='top']"));

        Actions actions=new Actions(driver);
        actions.moveToElement(hovertool).perform();
        Thread.sleep(2000);

        String expected="top";

        String actual=ontop.getAttribute("data-bs-placement");

        Assert.assertEquals(actual,expected);

        List<WebElement> hovers= driver.findElements(By.xpath("//button[@class='btn btn-secondary']"));

        for(WebElement hover: hovers){
            actions.moveToElement(hover).pause(2000).perform();
        }


    }
        @Test
        public void rightClick() throws InterruptedException {

        /*
        go to https://demoqa.com/buttons
        Right Click Me elementine sag click yap ve
        Assert et
        */

            WebElement right=driver.findElement(By.id("rightClickBtn"));

            Actions actions= new Actions(driver);

            actions.contextClick(right).perform();

            Thread.sleep(2000);

            WebElement msj= driver.findElement(By.id("rightClickMessage"));

            String expected= "You have done a right click";
            String actual= msj.getText();

            Assert.assertEquals(actual,expected,"FAIL");

        }
    }
