package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ElementUtils;

public class HomePage {
    //First write WebDriver driver
    WebDriver driver;
    //Create an object for ElementUtils
    private ElementUtils elementUtils;
    //Create a constructor and assign the driver and initialize the webelements
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        elementUtils = new ElementUtils(driver);
    }
    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement myAccountDropMenu;

    @FindBy(linkText = "Login")
    private WebElement loginOption;

    public void clickOnMyAccount(){
        elementUtils.clickOnElement(myAccountDropMenu,2);
    }

    public void clickOnLoginOption(){
        elementUtils.clickOnElement(loginOption,2);
    }

}
