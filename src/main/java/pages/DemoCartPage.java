package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ElementUtils;

import java.util.List;

public class DemoCartPage extends BasePage {
    ElementUtils elementUtils;

    public DemoCartPage(WebDriver driver) {

        super(driver);

        elementUtils = new ElementUtils(driver);


    }

    @FindBy(xpath = "//ul[@class='top-menu']//a[contains(text(),'Books')]")
    private WebElement btnBooks;

    @FindBy(xpath = "//div[@class='product-grid']/div//div[@class='buttons']/input")
    private List<WebElement> btnListOfBooks;

    @FindBy(xpath = "//div[@class='product-grid']/div/child::div/descendant::div/following-sibling::div/h2/a")
    private List<WebElement> getText;

    @FindBy(xpath = "//span[normalize-space()='Shopping cart']")
    private WebElement btnShoppingCart;

    @FindBy(xpath = "//table[@class='cart']/tbody/tr/td[3]/a")
    private List<WebElement> getTheCartedProductText;


    public void clickOnBooks() {

        elementUtils.clickOnElement(btnBooks, 10);

    }

    public String getText() {

        return getText.getFirst().getText();

    }

    public void clickOnAddToCart() throws InterruptedException {

        btnListOfBooks.getFirst().click();

        Thread.sleep(10000);
        elementUtils.scrollByVisibilityOfElement(btnShoppingCart);
        elementUtils.clickOnElement(btnShoppingCart, 10);
    }

    public String getCartedText() {

        return getTheCartedProductText.getFirst().getText();

    }
}
