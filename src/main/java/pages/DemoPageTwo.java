package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ElementUtils;

public class DemoPageTwo extends BasePage {

    ElementUtils elementUtils;

    public DemoPageTwo(WebDriver driver) {

        super(driver);

        elementUtils = new ElementUtils(driver);
    }

    @FindBy(xpath = "//input[@id='male']")
    private WebElement radioBtn;


    public void clickRadioButton() {

        elementUtils.clickOnElement(radioBtn, 10);


    }
}
