package com.krafttechnologie.tests.mentoring;

import com.krafttechnologie.pages.RadioButtonPage;
import com.krafttechnologie.tests.TestBase;
import com.krafttechnologie.utilities.BrowserUtils;
import com.krafttechnologie.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReviewTest_RadioButtonsCheckBoxes extends TestBase {

    RadioButtonPage radioButtonPage=new RadioButtonPage();

    @Test
    public void checkFirstRadioButton(){
    driver.get(ConfigurationReader.get("radioButtonUrl"));


        Assert.assertTrue(radioButtonPage.btn1.isDisplayed());
        Assert.assertTrue(radioButtonPage.btn1.isSelected());
        Assert.assertTrue(radioButtonPage.btn1.isEnabled());

        BrowserUtils.waitFor(3);

}




}
