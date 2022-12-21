package com.krafttechnologie.tests.day13_WebTables;

import com.krafttechnologie.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTables {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
//        driver.get("https://webdriveruniversity.com/Data-Table/index.html");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void printTable() {

        WebElement table = driver.findElement(By.xpath("//table[@class='table table-light traversal-table']"));
        System.out.println("table.getText() = " + table.getText());
    }

    @Test
    public void printAllHeaders() {

        WebElement headers = driver.findElement(By.xpath("//table[@class='table table-light traversal-table'] /thead"));
        System.out.println("headers= " + headers.getText());
    }

    @Test
    public void printTableSize() {

        //th tagindeki tum basliklarin sayisini almak

        List<WebElement> thSize = driver.findElements(By.xpath("//table[@class='table table-light traversal-table'] //th"));
        System.out.println("thSize= " + thSize.size());


        // satırların size ını bulalım
        List<WebElement> rowSize = driver.findElements(By.xpath("//table[@class='table table-light traversal-table'] //tr"));
        System.out.println("rowSize= " + rowSize.size());

        // Başlıklar hariç satırların size ını bulalım
        List<WebElement> allRowsWithoutHeaders = driver.findElements(By.xpath("//table[@class='table table-light traversal-table']//tbody //tr"));
        System.out.println("allRowsSize= " + allRowsWithoutHeaders.size());

    }

    @Test
    public void getRow() {

        WebElement row2 = driver.findElement(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr[2]"));
        System.out.println("row2.getText() = " + row2.getText());
    }

    @Test
    public void getAllRows() throws InterruptedException {

        List<WebElement> allRows = driver.findElements(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr"));
        Thread.sleep(2000);

        for (int i = 1; i < allRows.size(); i++) {
            WebElement row = driver.findElement(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr[" + i + "]"));

            System.out.println("row.getText() = " + row.getText());
        }
    }

    @Test
    public void getAllCellsOneRow() throws InterruptedException {

        // List<WebElement> allCells=driver.findElements(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr[2]/td"));
        WebElement jacob = driver.findElement(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr[2]td[1]"));
        System.out.println("jacob.getText() = " + jacob.getText());

//        WebElement scott = driver.findElement(By.xpath("//table[@class='table table-light traversal-table']//tbody//tr[3]td[1]"));
//        System.out.println("scott.getText() = " + scott.getText());


/*        for (WebElement element:allCells) {

            System.out.println("element.getText() = " + element.getText());
        }

    */

    }

    @Test
    public void testIframe() throws InterruptedException {
        driver.get("https://www.krafttechexlab.com/components/iframe");
        WebElement iframe= driver.findElement(By.tagName("iframe"));

        driver.switchTo().frame(iframe); // iFrame e geçiş
        Thread.sleep(2000);

        WebElement box=driver.findElement(By.xpath("(//button[@class='btn-close btn-close-white'])[1]"));
        box.click();

        driver.switchTo().defaultContent(); // ana contente dönüş

        WebElement title= driver.findElement(By.xpath("//h1[.='Iframe']"));

        System.out.println("title.getText() = " + title.getText());

        Thread.sleep(2000);
    }
}