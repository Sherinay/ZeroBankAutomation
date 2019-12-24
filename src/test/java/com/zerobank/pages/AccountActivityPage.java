package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityPage {
    public AccountActivityPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//select[@id='aa_accountId']")
    public WebElement selectBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement findbutton;

    @FindBy(linkText = "Find Transactions")
    public WebElement findTransaction;

    @FindBy(xpath = "//input[@id='aa_fromDate']")
    public WebElement startDate;

    @FindBy(xpath = "//input[@id='aa_toDate']")
    public WebElement endDate;

    @FindBy(xpath = "//input[@id='aa_description']")
    public WebElement description;

    @FindBy(xpath = "//select[@id='aa_type']")
    public WebElement typeSelect;

    public void enterDescription(String descrip){
        description.sendKeys(descrip);
    }

    public void enterDates(String startingDate, String endingDate){
        startDate.sendKeys(startingDate);
        endDate.sendKeys(endingDate);
    }

    public void selecFromtheDropdown(String value){
        Select select=new Select(typeSelect);
        select.selectByVisibleText(value);
    }
    public String selectedOption(){
        Select select=new Select((typeSelect));
        return select.getFirstSelectedOption().getText();
    }

    public void clickFind(){
        findbutton.click();
    }


    public void clickFindTrans(){
        findTransaction.click();
    }














}


