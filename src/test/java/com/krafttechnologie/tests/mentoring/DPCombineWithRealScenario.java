package com.krafttechnologie.tests.mentoring;

import com.krafttechnologie.pages.DashboardPage;
import com.krafttechnologie.pages.LoginPages;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DPCombineWithRealScenario extends TestBase {

    ExcelUtil excelUtil=new ExcelUtil("src/test/resources/LoginList.xlsx","QaTeam3");

    @DataProvider
    public Object[][] userData(){ // String..vb object hepsini kapsadığından
        String [][]dataArray= excelUtil.getDataArrayWithoutFirstRow();
        return  dataArray;

    }

    @Test (dataProvider = "userData")
    public void successLoginTest(String email, String password, String yourName){


        //give a name to the current test
        extentLogger=report.createTest("Positive Login Test");
        LoginPages loginPages=new LoginPages();
        DashboardPage dashboardPage=new DashboardPage();

        loginPages.loginWithParameters(email,password);
        String actualName=dashboardPage.getUserName();
        String expectedName=yourName;

        Assert.assertEquals(actualName,expectedName,"Verify Your Name");
    }

}
