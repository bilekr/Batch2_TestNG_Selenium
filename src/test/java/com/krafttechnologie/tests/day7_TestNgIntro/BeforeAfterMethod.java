package com.krafttechnologie.tests.day7_TestNgIntro;

import org.testng.annotations.*;

public class BeforeAfterMethod {

    @BeforeClass
    public void setUpClass(){
        System.out.println("---Before Class---");
    }

    @Test @Ignore // ignore ile yok sayılır
    public void logOut(){
        System.out.println("First Test LogOut");
    }

    @Test
    public void logIn(){
        System.out.println("Second Test LogIn");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Before Method");
    }
    // @Test
    public void comment(){
        System.out.println("Test Case Comment");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("After Method");
    }

    @Test
    public void register(){
        System.out.println("Third Test Register");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("---After Class---");
    }

    // *** Her testin öncesinde ve sonrasında before ve after test çalışır.
    // Console="Before Method-First Test Case-After Method-Before Method-Second Test Case-After Method"
    // methodlar arasında alfabetik sıraya göre çalışır.
    // @Test yanına @Ignore ile testi durdurabiliriz/test çalışmaz (Before ve After Methodu Hariç--->bunlar çalışmaya devam eder)
    // "// @Test" commente alındığında test pasife alınmış olur testi gerçekleştirmez. (Before ve After Methodu Dahil--->çalışmazlar)
    // bir Class çalıştırıldığında Before Class en önce bir defa çalışır, After Class en son bir defa çalışır
    // (---Before Class/Before Method/Second/Test LogIn/After Method/Before Method/Third Test Register/After Method/After Class---)

}
