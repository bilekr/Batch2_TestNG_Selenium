package com.krafttechnologie.tests.day10_WebElements4;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopUpAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void PopUp() throws InterruptedException {
        driver.get("http://primefaces.org/showcase/ui/overlay/confirmDialog.xhtml?jfwid=73437");

        //click the confirm button
        driver.findElement(By.xpath("(//span[text()='Confirm'])[1]")).click();
        //click 'Yes'
        driver.findElement(By.xpath("(//span[text()='Yes'])[2]")).click();

        Thread.sleep(2000);

        //verify that confirm is accepted
        String expectedMessage="You have accepted";
        WebElement actualMessage = driver.findElement(By.xpath("//p[text()='You have accepted']"));

        Assert.assertEquals(actualMessage.getText(),expectedMessage);
        // ***actual Webelement old. get text ile stringe cevrilir.

    }

    @Test
    public void jsAlerts() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        Thread.sleep(2000);

        // click-click for JS Alert Button
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        //e.g..: 1switch to Js alert pop up
        Alert alert=driver.switchTo().alert(); // driver alerte gecti
        Thread.sleep(2000);

        // click Ok
        alert.accept();

        // e.g.: 2 click for JS Confirm
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);

        // click Cancel
        alert.dismiss();

        // e.g.: 3 click for JS Prompt
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);

        // sendKeys to Js Prompt
        alert.sendKeys("KraftTech Batch 2 was here");
        Thread.sleep(4000);
        System.out.println("alert.getText() = " + alert.getText());
        alert.accept();

        // Task verify all result above Js Alerts
    }


}
