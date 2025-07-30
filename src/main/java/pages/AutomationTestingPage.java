package pages;

import org.openqa.selenium.WebDriver;
import utils.ElementUtils;

public class AutomationTestingPage extends BasePage {

    ElementUtils elementUtils;

    public AutomationTestingPage(WebDriver driver) {

        super(driver);

        elementUtils = new ElementUtils(driver);

    }

    public String verifyTitle() {

        return driver.getTitle();
    }
}
