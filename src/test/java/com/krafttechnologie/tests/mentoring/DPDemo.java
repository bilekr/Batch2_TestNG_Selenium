package com.krafttechnologie.tests.mentoring;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DPDemo {

    // önce  DataProvider'dan gelen methodumuzu oluşturuyoruz
    // Bu method testimize data sağlayacak

    @DataProvider
    public Object[][] testData() { // 2d array oluşturuyoruz

        String [][]data={{"Person Of Interest","100"}, {"Fringe","90"},{"Truman","70"}};

        return data;
    }

    @Test(dataProvider ="testData") // testte data providerın ismi ile çağırıyoruz
    public void test(String tvshow,String rating){

        System.out.println("Tv Show: " + tvshow + " has rating " + rating);
    }

}
