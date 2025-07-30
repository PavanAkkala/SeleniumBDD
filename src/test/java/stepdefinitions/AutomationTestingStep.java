package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AutomationTestingPage;

public class AutomationTestingStep {

    WebDriver driver = DriverFactory.getDriver();
    AutomationTestingPage automationTestingPage = new AutomationTestingPage(driver);

    @Given("Verify the titile of the page")
    public void verify_the_titile_of_the_page() {

        String actual = automationTestingPage.verifyTitle();
        System.out.println(actual);
        Assert.assertEquals("titlle is not matched","Automation Testing Practice",actual);
    }

}
