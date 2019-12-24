package com.zerobank.stepdefnitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.PayBillPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Array;
import java.util.*;

public class PurchaseForeignCurrencyStepDefs {
    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.gotoPayBills();
        BrowserUtils.waitFor(1);
        PayBillPage payBillPage = new PayBillPage();
        payBillPage.clickPurchaseForeignCurrency();

    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> listCountries) {
        PayBillPage payBillPage = new PayBillPage();
        BrowserUtils.waitFor(2);

        List<String> arrCountries = new ArrayList<>(listCountries);
        System.out.println("First " + arrCountries);


        System.out.println("-------------------");


        List<WebElement> countryList = payBillPage.selectOption().getOptions();
        List<String> stringArrCountry = new ArrayList<String>();
        System.out.println("Actual " + countryList.size());

//        countryList.forEach(each -> System.out.println(each.getText()));
//        System.out.println("From browser util "+BrowserUtils.getElementsText(countryList));

        for (WebElement e : countryList) {

            stringArrCountry.add(e.getAttribute("text"));

            System.out.println();

        }
        System.out.println("Actual countries " + stringArrCountry);

        System.out.println("Expected countries " + arrCountries);

        Assert.assertTrue(stringArrCountry.containsAll(arrCountries));

        System.out.println("Result");


        System.out.println("Verification Successful");

    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        PayBillPage payBillPage = new PayBillPage();
        BrowserUtils.waitFor(2);

        System.out.println(payBillPage.selectOption().getFirstSelectedOption().getText());
        if (payBillPage.selectOption().getFirstSelectedOption().getText().equals("Select One")) {
            payBillPage.clickCalculate();

        }

    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        PayBillPage payBillPage = new PayBillPage();
        BrowserUtils.waitFor(2);
        String alertMsg = Driver.HandlingAlert().getText();
        System.out.println(alertMsg);
        Assert.assertTrue(payBillPage.isAlertPresent());

        BrowserUtils.waitFor(2);
        Driver.HandlingAlert().accept();
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
       PayBillPage payBillPage = new PayBillPage();
       BrowserUtils.waitFor(2);

        System.out.println(payBillPage.amountBox.getAttribute("value"));
        if (payBillPage.amountBox.getAttribute("value").isEmpty()) {
            payBillPage.clickCalculate();
        }
    }


}

