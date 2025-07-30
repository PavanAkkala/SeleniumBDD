package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.ElementUtils;

public class Demo1Page extends  BasePage{

    ElementUtils elementUtils;
    public Demo1Page(WebDriver driver) {

        super(driver);

        elementUtils = new ElementUtils(driver);
    }

    @FindBy(xpath = "//select[@id='country']")
    private WebElement drp;

    public void selectDrp(String cntry) {
        elementUtils.clickOnElement(drp,10);
        //elementUtils.selectOptionInTheDropdown(drp,cntry,10);
        elementUtils.selectOptionsByName(drp,cntry);
    }
}
