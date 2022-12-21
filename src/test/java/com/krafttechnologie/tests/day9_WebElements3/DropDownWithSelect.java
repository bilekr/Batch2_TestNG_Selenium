package com.krafttechnologie.tests.day9_WebElements3;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownWithSelect {
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

        // 1. drop downu diğer elementler gibi locate ediyoruz
        WebElement dropDownElement= driver.findElement(By.cssSelector("#oldSelectMenu"));

        // 2. elementi constructor gibi atayarak selenium classından bir object oluşturuyoruz
        // ***Select Tag***i olduğunda

        Select selectMenu=new Select(dropDownElement);

        // secilen ilk elementi test edelim
        String expectedOption="Red";

        String actualOption=selectMenu.getFirstSelectedOption().getText();
        System.out.println("actualOption = " + actualOption);

        Assert.assertEquals(actualOption,expectedOption, "FAIL");


// ---------------------------------------------------------------------------

        // DropDown dan diğer optionları nasıl getiririz?
        // 1. select visibleText kullanacağız

        selectMenu.selectByVisibleText("Black");

        expectedOption="Black";
        actualOption=selectMenu.getFirstSelectedOption().getText();

        System.out.println("actualOption = " + actualOption);

        Assert.assertEquals(actualOption,expectedOption,"FAIL");

        // 2. index kullanarak

        selectMenu.selectByIndex(6);

        expectedOption="White";
        actualOption=selectMenu.getFirstSelectedOption().getText();
        System.out.println("actualOption = " + actualOption);

        Assert.assertEquals(actualOption, expectedOption, "FAIL");
// ---------------------------------------------------------------------------
        Thread.sleep(2000);
        selectMenu.selectByValue("3");

        expectedOption="Yellow";
        actualOption=selectMenu.getFirstSelectedOption().getText();
        System.out.println("actualOption = " + actualOption);
        Assert.assertEquals(actualOption, expectedOption, "FAIL");

    }
}
