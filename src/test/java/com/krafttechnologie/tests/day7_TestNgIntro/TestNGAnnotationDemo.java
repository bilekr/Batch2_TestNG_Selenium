package com.krafttechnologie.tests.day7_TestNgIntro;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGAnnotationDemo {

    @BeforeMethod
    public void setUp(){
        System.out.println("Open Browser");
    }

    @Test
    public void test1(){
        System.out.println("First Test First Assertion");
        Assert.assertEquals("title","title");
        // ***Assert classı ile if/else kullanımına gerek kalmıyor!!!
        // ***assertEquals ve asserTrue en cok kullanılan metodlar

        System.out.println("First Test Second Assertion");
        Assert.assertEquals("url","url");

        // test 1 in içindeki ilk testte hata varsa test içinde ikinci teste geçmez ancak test 2 ye gecerek kodu tamamlar.
        // Her bir test methodu altındaki kod bağımsız çalışır (başarılı yada başarısız) birbirini etkilemez.
    }


    @Test
    public void test2(){
        System.out.println("Second Test Assertion");
        Assert.assertEquals("test2","test2");

    }


    @Test
    public void test3(){
       String actualTitle="Kraft";
       String expectedTitle="Krafttech";
        Assert.assertTrue(actualTitle.contains(expectedTitle),"verify that title start Kraft");
    }

    @Test
    public void test4(){
        String email="kraftTech@gmail.com";
        if (email.contains("@")){
            System.out.println("Pass");
        }else{
            System.out.println("Failed");
        }
        Assert.assertTrue(email.contains("@"));


    }

    @Test
    public void test5(){

        Assert.assertFalse(0>1);

    }

    @Test
    public void test6(){

        Assert.assertNotEquals("two","one");

    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Close Browser");
    }
}
