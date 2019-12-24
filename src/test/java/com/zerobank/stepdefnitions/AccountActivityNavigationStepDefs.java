package com.zerobank.stepdefnitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.BasePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityNavigationStepDefs extends BasePage {
    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        /*
          *Login
                Only authorized users should be able to login to the application. When user logs in
                with valid credentials, Account summary page should be displayed.
                Users with wrong username or wrong password should not be able to login. Users
                with blank username or password should also not be able to login. When user tries
                to login with invalid information, error message Login and/or password are wrong.
                should be displayed.
         */
        try {
            Driver.get().get(ConfigurationReader.get("url"));
            Driver.driverMaximize();
            LoginPage loginPage = new LoginPage();
            loginPage.login(ConfigurationReader.get("username"), ConfigurationReader.get("password"));
            System.out.println(getPageTitle());
            Assert.assertTrue(getPageTitle().contains("Account Summary"));
            List<WebElement> accountType=Driver.findElements("//ul[@class='nav nav-tabs']/li/a");
            for (WebElement eachAccount : accountType) {
                System.out.println(eachAccount.getText());
                Assert.assertTrue(eachAccount.isDisplayed());
            }
            List<WebElement> creditAcntTable=Driver.findElements("//div[@class='board'][3]//table[@class='table']/thead//th");
            for (WebElement eachColumn : creditAcntTable) {
                System.out.println(eachColumn.getText());
                Assert.assertTrue(eachColumn.isDisplayed());
            }
        }catch (Exception e){
            Assert.assertTrue(getPageTitle().contains("Log in"));
            System.out.println("Login and/or password are wrong.");
        }

    }

    @When("the user clicks on Savings link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
        accountSummaryPage.clickSavings();

    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().contains("Account Activity"));
    }

    @Then("Account drop down should have Savings selected")
    public void account_drop_down_should_have_Savings_selected() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Select accountList= new Select(accountActivityPage.selectBox);
        String displayedAccount=accountList.getFirstSelectedOption().getText();
        System.out.println(displayedAccount);
        Assert.assertEquals(displayedAccount,"Savings");
    }

    @When("the user clicks on Brokerage link on the Account Summary page")
    public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
        accountSummaryPage.clickAccntSummary();
        accountSummaryPage.brokerage.click();

    }

    @Then("Account drop down should have Brokerage selected")
    public void account_drop_down_should_have_Brokerage_selected() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Select accountList= new Select(accountActivityPage.selectBox);
        String displayedAccount=accountList.getFirstSelectedOption().getText();
        System.out.println(displayedAccount);
        Assert.assertEquals(displayedAccount,"Brokerage");
    }

    @When("the user clicks on Checking link on the Account Summary page")
    public void the_user_clicks_on_Checking_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
        accountSummaryPage.checking.click();

    }

    @Then("Account drop down should have Checking selected")
    public void account_drop_down_should_have_Checking_selected() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Select accountList= new Select(accountActivityPage.selectBox);
        String displayedAccount=accountList.getFirstSelectedOption().getText();
        System.out.println(displayedAccount);
        Assert.assertEquals(displayedAccount,"Checking");

    }

    @When("the user clicks on Credit card link on the Account Summary page")
    public void the_user_clicks_on_Credit_card_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
        accountSummaryPage.creditCard.click();

    }

    @Then("Account drop down should have Credit Card selected")
    public void account_drop_down_should_have_Credit_Card_selected() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Select accountList= new Select(accountActivityPage.selectBox);
        String displayedAccount=accountList.getFirstSelectedOption().getText();
        System.out.println(displayedAccount);
        Assert.assertEquals(displayedAccount,"Credit Card");
    }

    @When("the user clicks on Loan link on the Account Summary page")
    public void the_user_clicks_on_Loan_link_on_the_Account_Summary_page() {
        AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
        accountSummaryPage.loan.click();
    }

    @Then("Account drop down should have Loan selected")
    public void account_drop_down_should_have_Loan_selected() {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Select accountList= new Select(accountActivityPage.selectBox);
        String displayedAccount=accountList.getFirstSelectedOption().getText();
        System.out.println(displayedAccount);
        Assert.assertEquals(displayedAccount,"Loan");
    }

}
