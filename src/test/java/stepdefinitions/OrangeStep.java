package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.OrangePage;

public class OrangeStep {

    WebDriver driver = DriverFactory.getDriver();

    OrangePage orangePage = new OrangePage(driver);

    @Given("User is on the loginPage")
    public void user_is_on_the_login_page() {

        String title = orangePage.verifyLoginPageTitle();

        Assert.assertEquals("Title is not same", "OrangeHRM", title);
    }

    @When("user enters valid credentials user name as {string} and password as {string}")
    public void user_enters_valid_credentials_user_name_as_and_password_as(String string, String string2) {

        orangePage.enterusername(string);
        orangePage.enterPassword(string2);
    }

    @When("clicks on login")
    public void clicks_on_login() {

        orangePage.clickLoginBtn();
    }

    @Then("user should be on the homepage and verify the homepage")
    public void user_should_be_on_the_homepage_and_verify_the_homepage() {

        boolean title = orangePage.verifyTheDashBoardPage();
        System.out.println(title);
    }


    @When("user clicks on {string} employee information should be displayed")
    public void userClicksOnEmployeeInformationShouldBeDisplayed(String arg0) throws InterruptedException {

        orangePage.clickOnPimModule(arg0);
    }

    @When("User clicks on {string} module then admin page should be displayed")
    public void userClicksOnModuleThenAdminPageShouldBeDisplayed(String arg0) {

            orangePage.admin(arg0);
    }
}
