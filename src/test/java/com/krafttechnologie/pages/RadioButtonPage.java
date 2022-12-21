package com.krafttechnologie.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RadioButtonPage extends BasePage{

    @FindBy (css="#gridRadios1")
    public WebElement btn1;


    @FindBy (css="#gridRadios2")
    public WebElement btn2;


    @FindBy (css="#gridRadios")
    public WebElement btn3;
}
