package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.DemoPage;
import pages.DemoPageThree;
import pages.DemoPageTwo;

public class DemoStep {

    WebDriver driver = DriverFactory.getDriver();

    DemoPage demoPage = new DemoPage(driver);
    DemoPageTwo demoPageTwo = new DemoPageTwo(driver);
    DemoPageThree demoPageThree = new DemoPageThree(driver);

    @Given("User is on home page and user enters names {string} into field")
    public void user_is_on_home_page_and_user_enters_names_into_field(String string) throws InterruptedException {

        String blue = demoPage.enterTheFields(string);

        System.out.println(blue);

        Assert.assertEquals("red", "Don", blue);
    }

    @When("Get the text from gender and compare {string}")
    public void getTheTextFromGenderAndCompare(String exp) {

        String red = demoPage.getGenderText();

        System.out.println(red);

        Assert.assertEquals("not equal", red, exp);


    }


    @And("Verify the gui box is visible or not")
    public void verifyTheGuiBoxIsVisibleOrNot() {

        boolean green = demoPage.displayStatus();
        // Assert.assertTrue(green);
        Assert.assertTrue("Failure message if condition is false", green);
    }

    @Then("Click on the radio button")
    public void clickOnTheRadioButton() {

        demoPageTwo.clickRadioButton();

    }

    @When("Clicks on popup button new tab will apper")
    public void clicksOnPopupButtonNewTabWillApper() throws InterruptedException {

        demoPageThree.clickOnWindowElement();


    }

    @Then("get the text from element")
    public void getTheTextFromElement() {

       String demo = demoPageThree.getTheText();
        System.out.println(demo);
       Assert.assertEquals("asserted","Selenium WebDriver",demo);

    }

    @And("Back to Main wondow and click on checkbox")
    public void backToMainWondowAndClickOnCheckbox() {

        demoPageThree.backToMainWindow();
    }
}
