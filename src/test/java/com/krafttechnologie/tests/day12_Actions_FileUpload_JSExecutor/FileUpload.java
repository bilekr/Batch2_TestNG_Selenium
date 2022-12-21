package com.krafttechnologie.tests.day12_Actions_FileUpload_JSExecutor;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUpload {
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
    public void test() throws InterruptedException {

        // choose file elementini locate diyoruz
        // sonrasında sendKeys içine (file path)
        // file path: shift+right click-copy as path

        driver.get("https://demoqa.com/upload-download");
        WebElement chooseFile = driver.findElement(By.id("uploadFile"));
        chooseFile.sendKeys("C:\\Users\\Win10\\Desktop\\UZMAN ÖĞRETMENLİK.pdf");

        WebElement testmsj = driver.findElement(By.cssSelector("#uploadedFilePath"));
        System.out.println("testmsj = " + testmsj.getText());

        String actual= testmsj.getText();
        String expected="UZMAN ÖĞRETMENLİK.pdf";

        Assert.assertTrue(actual.contains(expected));



    }

    @Test
    public void uploadFile2(){

        /*
        test folder uzerinde sag click Directory sec+ resources sec
        file copy et resources uzerine uzantisi .txt olacak sekilde paste yap
        Sonra projenin sistemdeki path ini aliyoruz:
        String projectPath= System.getProperty("user.dir");

        String FilePath= "src/test/resources/Deneme Text.txt"
         */

        driver.get("https://demoqa.com/upload-download");

        WebElement chooseFile= driver.findElement(By.id("uploadFile"));

        String projectPath= System.getProperty("user.dir");
        String FilePath= "src/test/resources/Deneme.txt";

        String fullPath= projectPath+"/"+FilePath;

        chooseFile.sendKeys(fullPath);

        WebElement testmsj= driver.findElement(By.cssSelector("#uploadedFilePath"));

        System.out.println("testmsj = " + testmsj.getText());

        String actual= testmsj.getText();
        String expected="Deneme.txt";

        Assert.assertTrue(actual.contains(expected));

    }

}
