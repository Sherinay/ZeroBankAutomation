package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummaryPage {
    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//ul[@class='nav nav-tabs']/li/a")
    public List<WebElement> allAccountType;

    @FindBy(xpath = "//div[@class='board'][3]//table[@class='table']/thead//th")
    public List<WebElement> creditAcntTable;

    @FindBy(linkText = "Savings")
    public WebElement savingsAcnt;

    @FindBy(xpath = "//ul[@class='nav nav-tabs']/li[@id='account_summary_tab']")
    public WebElement accountSummary;

    @FindBy(linkText = "Brokerage")
    public  WebElement brokerage;

    @FindBy(linkText = "Checking")
    public WebElement checking;

    @FindBy(linkText = "Credit Card")
    public WebElement creditCard;

    @FindBy(linkText = "Loan")
    public WebElement loan;

    @FindBy(linkText = "Pay Bills")
    public WebElement payBills;

    @FindBy(xpath = "//ul[@class='nav nav-tabs']/li[@id='account_activity_tab']")
    public WebElement accntActivity;

    public void gotoPayBills(){
        payBills.click();
    }
    public void clickSavings(){
        savingsAcnt.click();
    }

    public void clickAccntSummary(){
        accountSummary.click();
    }

    public void clickAccntActivity(){
        accntActivity.click();
    }


}
