package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//button[@id='signin_button']")
    public WebElement signIn;

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement userNameInput;

    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement passWordInput;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement alertMsg;



    public void login(String username,String password){
        BrowserUtils.waitForVisibility(signIn,2);
        signIn.click();
        BrowserUtils.waitFor(1);
        userNameInput.sendKeys(username);
        passWordInput.sendKeys(password);
        loginButton.click();
    }

    public String alertMsg(){
        return alertMsg.getText();
    }



}
