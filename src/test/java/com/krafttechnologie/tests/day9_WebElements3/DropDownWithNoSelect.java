package com.krafttechnologie.tests.day9_WebElements3;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownWithNoSelect {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");

        // Dev tools da ALt Grupta Event Listener içinde Blur altında bulunanlar remove edilirse
        // açılır seçeneklerde oluşan inspect engeli kalmaz.

        // dropdown kutusunu locate ediyoruz
        WebElement dropDownMenu= driver.findElement(By.xpath("( //div[@class=' css-1wa3eu0-placeholder'])[1]"));
        System.out.println("dropDownMenu.getText() = " + dropDownMenu.getText());

        // Kutudaki ilk elementi test edelim
        String expectedOption="Select Option";
        String actualOption=dropDownMenu.getText();

        Assert.assertEquals(actualOption,expectedOption, "FAIL");

        // dropdown içerisnde Group 2 Option 1 seceneğini çağıralım
        // Buradaki sorun inspect yapılmak istendiğinde menu gizleniyor
        // aşmak için event Listener (yukarıdaki açıklama)

        dropDownMenu.click();
        WebElement group2Option1=driver.findElement(By.cssSelector("#react-select-2-option-1-0"));

        group2Option1.click();

      /*  String expected="Group 2, option 1";
        String actual=group2Option1.getText();
        System.out.println("actual = " + actual);
        Assert.assertEquals(actual,expected,"FAIL");*/

        //Group 2 Option1 secildikten sonra verify etmek icin tekrar locate diyoruz.
        WebElement selectedOption=driver.findElement(By.xpath("//div[@class=' css-1uccc91-singleValue']"));

        System.out.println("selectedOption.getText() = " + selectedOption.getText());

        String expectedOption2="Group 2, option 1";
        String actualOption2= selectedOption.getText();

        Assert.assertEquals(actualOption2,expectedOption2);
    }


}
