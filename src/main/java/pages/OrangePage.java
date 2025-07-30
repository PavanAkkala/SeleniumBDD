package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ElementUtils;

public class OrangePage extends BasePage {
    ElementUtils elementUtils;
    public OrangePage(WebDriver driver) {

        super(driver);

        elementUtils = new ElementUtils(driver);
    }

    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameFiled;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnLogin;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardPage;

    private String buttonPim = "//span[text()='%s']";

    private String adminMd = "//span[text()='%s']";


    public String verifyLoginPageTitle() {

        return driver.getTitle();
    }

    public void enterusername(String uname) {

        elementUtils.typeTextIntoElement(usernameFiled,uname,10);
    }

    public void enterPassword(String password) {

        elementUtils.typeTextIntoElement(passwordField,password,10);
    }

    public void clickLoginBtn() {

        elementUtils.clickOnElement(btnLogin,10);

    }

    public boolean verifyTheDashBoardPage() {

        return dashboardPage.isDisplayed();
    }


    public WebElement clickOnPimModule(String label) {
        try {
            Thread.sleep(5000); // Not recommended; use WebDriverWait instead
            String name = String.format(buttonPim, label);
            WebElement element = driver.findElement(By.xpath(name));
            element.click();
            return element;
        } catch (NullPointerException e) {
            System.out.println("NullPointerException occurred: " + e.getMessage());
            return null; // or throw e;
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return null;
        }

    }

    public WebElement admin(String ad) {

        String name = String.format(adminMd,ad);
        WebElement element = driver.findElement(By.xpath(name));
        element.click();
        return element;
    }



}
