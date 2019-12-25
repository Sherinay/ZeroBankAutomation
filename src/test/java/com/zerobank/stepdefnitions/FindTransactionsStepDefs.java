package com.zerobank.stepdefnitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class FindTransactionsStepDefs {
    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        accountSummaryPage.clickAccntActivity();
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Assert.assertTrue(accountActivityPage.findTransaction.isEnabled());
        accountActivityPage.clickFindTrans();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String startDate, String endDate) {

        AccountActivityPage accountActivityPage = new AccountActivityPage();
        BrowserUtils.waitFor(1);
        accountActivityPage.enterDates(startDate, endDate);

    }

    @When("clicks search")
    public void clicks_search() throws InterruptedException {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Thread.sleep(2000);
        accountActivityPage.clickFind();
        Thread.sleep(5000);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String startDate, String endDate) {
        String startdate1 = startDate.replace("-", "");
        int startdate = Integer.parseInt(startdate1);
        System.out.println(startdate);

        String enddate2 = endDate.replace("-", "");
        int enddate = Integer.parseInt(enddate2);
        System.out.println(enddate);

        List<WebElement> dates = Driver.findElements("//div[@id='ui-tabs-2']//div/table/tbody/tr/td[1]");
        for (WebElement eachDate : dates) {
            System.out.println(eachDate.getText());

            String textDate = eachDate.getText().replace("-", "");
            System.out.println(textDate);
            int resultDates = Integer.parseInt(textDate);
            if (resultDates >= startdate && resultDates <= enddate) {
                System.out.println(true);
            }
        }
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        List<WebElement> dates = Driver.findElements("//div[@id='ui-tabs-2']//div/table/tbody/tr/td[1]");
        List<String> originalDates = new ArrayList<>();
        for (WebElement date : dates) {
            originalDates.add(date.getText().replace("-", ""));
        }
            List<String> tempDates = originalDates;
            Collections.reverse(tempDates);
            Assert.assertEquals(tempDates, originalDates);


            System.out.println("Original Dates " + originalDates);

            System.out.println("Temperary sorted Dates " + tempDates);



    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String startDate) {
        List<WebElement> dates = Driver.findElements("//div[@id='ui-tabs-2']//div/table/tbody/tr/td[1]");
        for (WebElement date : dates) {
            if (!(date.getText().contains(startDate))) {
                System.out.println(true);
            }
        }


    }

    @When("the user enters description {string}")
    public void the_user_enters_description_ONLINE(String desctiption) throws InterruptedException {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        Thread.sleep(2000);
        accountActivityPage.enterDescription(desctiption);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing_ONLINE(String description) {
        List<WebElement> descList = Driver.findElements("//div[@id='ui-tabs-2']//div/table/tbody/tr/td[2]");
        for (WebElement eachDesc : descList) {
            Assert.assertTrue(eachDesc.getText().contains(description));
        }
    }

    @But("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing_OFFICE(String description) {
        List<WebElement> descList = Driver.findElements("//div[@id='ui-tabs-2']//div/table/tbody/tr/td[2]");
        for (WebElement eachDesc : descList) {
            Assert.assertFalse(eachDesc.getText().contains(description));
        }
    }


    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        List<WebElement> allDeposits = Driver.findElements("//div[@id='ui-tabs-2']//div/table/tbody/tr/td[3]");
        System.out.println("Size " + allDeposits.size());
        Assert.assertFalse(allDeposits.isEmpty());
        Assert.assertTrue(allDeposits.size() >= 1);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        List<WebElement> allWithdrawal = Driver.findElements("//div[@id='ui-tabs-2']//div/table/tbody/tr/td[4]");
        System.out.println("Size " + allWithdrawal.size());
        Assert.assertFalse(allWithdrawal.isEmpty());
        Assert.assertTrue(allWithdrawal.size() >= 1);
    }

    @When("user selects type {string}")
    public void user_selects_type_Deposit(String type) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        accountActivityPage.selecFromtheDropdown(type);
        System.out.println("Selected option "+accountActivityPage.selectedOption());
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        BrowserUtils.waitFor(2);
        List<WebElement> withDrawalList = Driver.findElements("//div[@id='ui-tabs-2']//div/table/tbody/tr/td[4]");
        System.out.println("Withdrawal List " + withDrawalList.size());
        for (WebElement eachElement : withDrawalList) {
            Assert.assertTrue(eachElement.getText().isEmpty());
        }

    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        List<WebElement> depositColumn=Driver.findElements("//div[@id='ui-tabs-2']//div/table/tbody/tr/td[3]");
        for (WebElement deposit : depositColumn) {
            Assert.assertTrue(deposit.getText().isEmpty());
        }
    }

}
