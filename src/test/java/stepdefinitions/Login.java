package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class Login {
    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage = new HomePage(driver);
    LoginPage loginPage = new LoginPage(driver);
    AccountPage accountPage = new AccountPage(driver);

    @Given("User navigated to the login page")
    public void userNavigatedToTheLoginPage(){
        homePage.clickOnMyAccount();
        homePage.clickOnLoginOption();

    }
    @When("User enters valid email address {string} into email field")
    public void userEntersValidEmailAddressIntoEmailField(String emailText) {

        loginPage.enterEmailAddress(emailText);
    }

    @And("User enters valid password {string} into password field")
    public void userEntersValidPasswordIntoPasswordField(String passwordText) {

        loginPage.enterPassword(passwordText);
    }
    @And ("User clicks on login button")
    public void userClicksOnLoginButton() {

        loginPage.clickOnLoginButton();
    }
    @Then ("User should get successfully logged in")
    public void userShouldGetSuccessfullyLoggedIn(){

        Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
    }
}
