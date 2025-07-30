package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.DemoCartPage;

public class DemoCartStep {

    WebDriver driver = DriverFactory.getDriver();
    DemoCartPage demoCartPage = new DemoCartPage(driver);
    String demo;

    @Given("user is on demo cart page and clicks on books")
    public void user_is_on_demo_cart_page_and_clicks_on_books() {

        demoCartPage.clickOnBooks();


    }


    @When("the user cliks on selected books")
    public void the_user_cliks_on_selected_books() throws InterruptedException {
        String demo =  demoCartPage.getText();
        System.out.println(demo);
        demoCartPage.clickOnAddToCart();
      String demo2 =  demoCartPage.getCartedText();
        System.out.println(demo2);
        Assert.assertEquals("red",demo, demo2);
    }


}
