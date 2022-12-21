package com.krafttechnologie.tests.mentoring;

import com.krafttechnologie.tests.TestBase;
import org.testng.annotations.Test;

public class Tasks extends TestBase{
   /* W 1:

    Go to https://demoqa.com/automation-practice-formLinks to an external site.
    Formu doldur
    Submit yap
    Acilan Thanks for submitting the form tablozundaki bilgileri yazdir.
    Thanks for submitting the form tablosundaki
    Gender
            Hobbies
    State and City
    Student Name elementlerinin assertion larine yap*/

    @Test
    public void test1(){
        driver.get("https://demoqa.com/automation-practice-formLinks");
    }

}
