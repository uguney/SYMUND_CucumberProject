package com.symund.pages;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id="user")
    public WebElement userName;

    @FindBy(id="password")
    public WebElement passWord;

    @FindBy(id = "submit-form")
    public WebElement submit;

    @FindBy(css = ".warning.wrongPasswordMsg")
    public WebElement wrongUserinfoWarning;

    @FindBy(xpath = "//img[@alt=\"Toggle password visibility\"]")
    public WebElement eyeIconOnThePasswordInputbox;

    @FindBy(id = "lost-password")
    public WebElement forgotPasswordLink;

    @FindBy(id = "reset-password-submit")
    public WebElement resetPasswordButton;




    public void login(String username, String password) {
        userName.sendKeys(username);
        passWord.sendKeys(password);
        submit.click();
    }
}
