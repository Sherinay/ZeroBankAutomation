package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
    Select select;

    /*
    returns page title
     */
    public String getPageTitle(){

        return Driver.get().getTitle();

    }



}
