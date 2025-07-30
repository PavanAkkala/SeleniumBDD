package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.Demo1Page;

public class Demo1Step {

    WebDriver driver = DriverFactory.getDriver();

    Demo1Page demo1Step = new Demo1Page(driver);

    @Given("User want to select the dropdwon from the seleclt {string}")
    public void user_want_to_select_the_dropdwon_from_the_seleclt(String string) {

        demo1Step.selectDrp(string);



    }
}
