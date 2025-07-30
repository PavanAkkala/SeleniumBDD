package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class DemoPage {

    WebDriver driver;
    ElementUtils elementUtils;
    public DemoPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver,this);

        elementUtils = new ElementUtils(driver);


    }

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameField;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//label[@for='gender']")
    private WebElement gen;

    @FindBy(xpath = "//a[normalize-space()='GUI Elements']")
    private  WebElement guiElement;

    public String enterTheFields(String name) throws InterruptedException {

        elementUtils.typeTextIntoElement(nameField,name,10);
        return nameField.getDomProperty("value");
    }

    public String getGenderText() {

        return elementUtils.getTextFromElement(gen,10);
    }

    public boolean displayStatus() {

        return guiElement.isDisplayed();
    }





}
