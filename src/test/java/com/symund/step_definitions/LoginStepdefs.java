package com.symund.step_definitions;

import com.symund.pages.LoginPage;
import com.symund.utilities.BrowserUtils;
import com.symund.utilities.ConfigurationReader;
import com.symund.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class LoginStepdefs {

    LoginPage loginPage = new LoginPage();

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        // comes from @Before
    }

    @Then("{string} should be seen on Username inputbox")
    public void shouldBeSeenOnUsernameInputbox(String expectedPlaceholderText) {

        Assert.assertEquals(expectedPlaceholderText, loginPage.userName.getAttribute("placeholder"));
    }

    @Then("{string} should be seen on Password inputbox")
    public void shouldBeSeenOnPasswordInputbox(String expectedPlaceholderText) {

        Assert.assertEquals(expectedPlaceholderText, loginPage.passWord.getAttribute("placeholder"));
    }

    @Then("the user should be able to see link {string}")
    public void theUserShouldBeAbleToSeeLink(String expectedLinkName) {

        Assert.assertTrue(loginPage.forgotPasswordLink.isDisplayed());
    }

    @When("the user clicks on the Forgot password? link")
    public void theUserClicksOnTheForgotPasswordLink() {

        loginPage.forgotPasswordLink.click();
    }

    @Then("Reset password button should be seen on the next screen")
    public void ResetPasswordButtonShouldBeSeenOnTheNextScreen() {

        Assert.assertTrue(loginPage.resetPasswordButton.isDisplayed());
    }

    @When("the user logs in with user information")
    public void theUserLogsInWithUserInformation() {
       loginPage.login(ConfigurationReader.get("username"), ConfigurationReader.get("password"));
    }

    @And("the user clicks on the eye icon")
    public void theUserClicksOnTheEyeIcon() {
        loginPage.eyeIconOnThePasswordInputbox.click();
    }

    @Then("the user should be able to see the password in a form of dots by default")
    public void theUserShouldBeAbleToSeeThePasswordInAFormOfDotsByDefault() {

        Assert.assertEquals("password", loginPage.passWord.getAttribute("type"));

    }

    @When("the user enters following credentials")
    public void theUserEntersFollowingCredentials(Map<String,String> userInfo) {

        loginPage.login(userInfo.get("username"),userInfo.get("password"));
    }

    @Then("the user should not be able to login")
    public void theUserShouldNotBeAbleToLogin() {

      //  WebDriverWait wait = new WebDriverWait(Driver.get(),30);
      //  wait.until(ExpectedConditions.visibilityOfElementLocated((By) loginPage.wrongUserinfoWarning));

       // BrowserUtils.waitForVisibility(loginPage.wrongUserinfoWarning, 10);
      //  Assert.assertTrue(loginPage.wrongUserinfoWarning.isDisplayed());

        String loginPageUrl = "https://qa.symund.com/index.php/apps/dashboard/";

        Assert.assertNotEquals(loginPageUrl, Driver.get().getCurrentUrl());
    }

    @Then("the user should be able to login")
    public void theUserShouldBeAbleToLogin() {
        Assert.assertEquals("Dashboard - Symund - QA", Driver.get().getTitle());
    }

    @Then("the user should see {string} in username inputbox")
    public void theUserShouldSee(String expectedMessage) {

        String validationMessageUsername = loginPage.userName.getAttribute("validationMessage");

        Assert.assertEquals(expectedMessage, validationMessageUsername);

    }

    @When("the user logs in with {string} and {string}")
    public void theUserLogsInWithAnd(String username, String password) {

        loginPage.login(username, password);
    }

    @Then("the user should see {string} in username password")
    public void theUserShouldSeeInUsernamePassword(String expectedMessage) {

        String validationMessagePassword = loginPage.passWord.getAttribute("validationMessage");

        Assert.assertEquals(expectedMessage, validationMessagePassword);

    }

    @When("the user enters user information")
    public void theUserEntersUserInformation() {

        loginPage.userName.sendKeys(ConfigurationReader.get("username"));
        loginPage.passWord.sendKeys(ConfigurationReader.get("password"));

    }

    @Then("the user should be able to see the password {string} explicitly")
    public void theUserShouldBeAbleToSeeThePasswordExplicitly(String expectedPassword) {

        Assert.assertEquals(expectedPassword, loginPage.passWord.getAttribute("value"));

    }


    //*****************************************************************


    @And("the user clicks on user profile icon")
    public void theUserClicksOnUserProfileIcon() {
        loginPage.userProfileIcon.click();
    }


    @And("the user clicks on Log out option")
    public void theUserClicksOnLogOutOption() {

        loginPage.logoutOption.click();
    }

    @Then("Login page should be loaded again")
    public void loginPageShouldBeLoadedAgain() {

        String expectedUrl = "https://qa.symund.com/index.php/login?clear=1";

        Assert.assertEquals(expectedUrl, Driver.get().getCurrentUrl());

    }

    @When("the user clicks on the GO BACK button")
    public void theUserClicksOnTheGOBACKButton() {

        Driver.get().navigate().back();
    }

    @Then("the user should not be able to login again")
    public void theUserShouldNotBeAbleToLoginAgain() {

        String loginPageUrl = "https://qa.symund.com/index.php/apps/dashboard/";

        Assert.assertNotEquals(loginPageUrl, Driver.get().getCurrentUrl());
    }

    @And("the user presses Enter key")
    public void theUserPressesEnterKey() {
        loginPage.passWord.sendKeys(Keys.ENTER);
    }



    @And("Username {string} should be seen under Profile icon")
    public void usernameShouldBeSeenUnderProfileIcon(String expectedUsername) {

        Assert.assertEquals(expectedUsername,loginPage.username.getAttribute("title"));
    }
}
