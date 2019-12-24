package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PayBillPage {
    public PayBillPage() {
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(linkText = "Add New Payee")
    public WebElement addNewPayee;

    @FindBy(xpath = "//input[@id='np_new_payee_name']")
    public WebElement payeeNameInput;

    @FindBy(xpath = "//textarea[@id='np_new_payee_address']")
    public WebElement payeeAddressInput;

    @FindBy(xpath = "//input[@id='np_new_payee_account']")
    public WebElement accountInput;

    @FindBy(xpath = "//input[@id='np_new_payee_details']")
    public WebElement payeeDetailsInput;

    @FindBy(xpath = "//input[@id='add_new_payee']")
    public WebElement addButton;

    @FindBy(xpath = "//div[@id='alert_content']")
    public WebElement alertContent;

    @FindBy(linkText = "Purchase Foreign Currency")
    public WebElement purchaseForeignCurrency;

    @FindBy(xpath = "//select[@name='currency']")
    public WebElement currencyDropdown;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCostButton;

    @FindBy(xpath = "//input[@id='pc_amount']")
    public WebElement amountBox;

    public boolean isAlertPresent(){
        try{
            Driver.HandlingAlert();
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Select selectOption(){
        Select select = new Select(currencyDropdown);
        return select;
    }

    public void clickCalculate(){
        calculateCostButton.click();
    }


    public void clickPurchaseForeignCurrency(){
        purchaseForeignCurrency.click();
    }

    public String aslertMsg(){
        return alertContent.getText();
    }

    public void clickAdd(){
        addButton.click();
    }

    public void addNewPayee(String name,String address,String account,String details){
        payeeNameInput.sendKeys(name);
        payeeAddressInput.sendKeys(address);
        accountInput.sendKeys(account);
        payeeDetailsInput.sendKeys(details);
    }

    public void gotoAddNewPayee(){
        addNewPayee.click();
    }











}