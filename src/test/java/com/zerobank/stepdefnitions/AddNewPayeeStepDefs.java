package com.zerobank.stepdefnitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.PayBillPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class AddNewPayeeStepDefs {
    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.gotoPayBills();
        BrowserUtils.waitFor(1);
        PayBillPage payBillPage = new PayBillPage();
        payBillPage.gotoAddNewPayee();


    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> userData) {
        System.out.println();
        PayBillPage payBillPage = new PayBillPage();
        payBillPage.addNewPayee(userData.get("Payee Name"), userData.get("Payee Address"), userData.get("Account"), userData.get("Payee details"));
        payBillPage.clickAdd();
        BrowserUtils.waitFor(2);


    }

    @Then("message The new payee The Law Offices of Hyde, Price & Scharks was successfully created. should be displayed")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price_Scharks_was_successfully_created_should_be_displayed() {
      PayBillPage payBillPage=new PayBillPage();
      payBillPage.aslertMsg();
    }

}
