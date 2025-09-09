package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ElementUtils;

public class DemoPageThree extends BasePage {

    ElementUtils elementUtils;
    public DemoPageThree(WebDriver driver) {

        super(driver);

        elementUtils = new ElementUtils(driver);
    }

    @FindBy(xpath = "//button[text()='Popup Windows']")
    private WebElement window;

    @FindBy(xpath = "//h4[normalize-space()='Selenium WebDriver']")
    private WebElement getTheText;

    @FindBy(xpath = "//input[@id='sunday']")
    private WebElement checkBox;

    public void clickOnWindowElement() throws InterruptedException {

        elementUtils.clickOnElement(window,10);
        elementUtils.switchToNewWindow(2);
        driver.manage().window().maximize();
        Thread.sleep(5000);


    }

    public String getTheText() {

      return elementUtils.getTextFromElement(getTheText,10);
    }

    public void backToMainWindow() {

        elementUtils.switchToNewWindow(0);
        elementUtils.clickOnElement(checkBox,10);
    }
}
