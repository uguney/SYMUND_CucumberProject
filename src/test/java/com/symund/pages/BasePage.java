package com.symund.pages;

import com.symund.utilities.BrowserUtils;
import com.symund.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public abstract class  BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }



    @FindBy(id = "expand")
    public WebElement userProfileIcon;

    // li[data-id='help']

    @FindBy(css = "nav[id='expanddiv']>ul>li")
    public List<WebElement> userProfileSettingsMenu;

    @FindBy(css = "li[data-id='logout']")
    public WebElement logoutOption;

    @FindBy(xpath = "//div[@class='user-status-menu-item']/span")
    public WebElement username;





}
