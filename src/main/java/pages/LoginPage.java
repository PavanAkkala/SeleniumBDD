package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class LoginPage {
    WebDriver driver;
    private ElementUtils elementUtils;
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        elementUtils = new ElementUtils(driver);
    }
    @FindBy(id = "input-email")
    private WebElement emailField;
    @FindBy(id="input-password")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    public void enterEmailAddress(String emailText){

        elementUtils.typeTextIntoElement(emailField,emailText,2);
    }
    public void enterPassword(String enterPassword){

        elementUtils.typeTextIntoElement(passwordField,enterPassword,2);
    }
    public void clickOnLoginButton() {
        elementUtils.clickOnElement(loginButton,1);



    }
}
