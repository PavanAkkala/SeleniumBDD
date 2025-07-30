package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.Set;

public class ElementUtils {
    WebDriver driver;
    public ElementUtils(WebDriver driver){

        this.driver=driver;
    }
    public void clickOnElement(WebElement element,long durationInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
        webElement.click();
    }
    public void typeTextIntoElement(WebElement element, String textToBeTyped, long durationInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
        WebElement webElement = waitForElement(element,durationInSeconds);
        webElement.click();
        webElement.clear();
        webElement.sendKeys(textToBeTyped);
    }
    public WebElement waitForElement(WebElement element,long durationInSeconds) {
        WebElement webElement=null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            webElement= wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (Throwable e){
            e.printStackTrace();
        }return webElement;
    }
    public void selectOptionInTheDropdown(WebElement element, String dropDownOption, long durationInSeconds){
        WebElement webElement = waitForElement(element,durationInSeconds);
        Select select = new Select(element);
       // select.selectByVisibleText(dropDownOption);
        select.selectByValue(dropDownOption);
    }

    public void selectOptionsByName(WebElement element, String visibleText) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    public void selectOptionsByIndex(WebElement element, int position) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Select select = new Select(element);
        select.selectByIndex(position);
    }

    public Alert waitForAlert(long durationInSeconds){
        Alert alert = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(0));
            alert = wait.until(ExpectedConditions.alertIsPresent());
        }catch (Throwable e){
            e.printStackTrace();
        }
        return alert;
    }
    public void mouseHoverAndClick(WebElement element, long durationInSeconds){

        WebElement webElement=waitForVisibilityOfElement(element,durationInSeconds);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().build().perform();
    }
    public WebElement waitForVisibilityOfElement(WebElement element, long durationInSeconds){
        WebElement webElement=null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            webElement = wait.until(ExpectedConditions.visibilityOf(element));
        }catch (Throwable e){
            e.printStackTrace();
        }
        return webElement;
    }
    public void  javaScriptClick(WebElement element, long durationInSeconds){
        WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
        JavascriptExecutor jse=((JavascriptExecutor)driver);
        jse.executeScript("arguments[0].click();", webElement);
    }
    public void javaScriptType(WebElement element, String textToBeTyped,long durationInSeconds){
        WebElement webElement = waitForVisibilityOfElement(element,durationInSeconds);
        JavascriptExecutor jse=((JavascriptExecutor)driver);
        jse.executeScript("arguments[0].value='"+textToBeTyped+"'", webElement);
    }
    public String  getTextFromElement(WebElement element, long durationInSeconds){
        WebElement webElement = waitForElement(element,durationInSeconds);
        return webElement.getText();
    }

    public WebElement waitForPresenceOfElement(WebElement accessNotesTextbox, long durationInSeconds) {

        WebElement webElement = null;

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
            webElement = wait.until(ExpectedConditions.presenceOfElementLocated((By) accessNotesTextbox));
        } catch (Throwable e) {
            e.printStackTrace();
        }

        return webElement;

    }

    // Method to get the spinner status and wait until it disappears
    public static boolean waitForInvisibilityOfElement(WebDriver driver, WebElement spinnerLocator,
                                                       int timeoutInSeconds) throws InterruptedException {
        int totalTimeWaited = 0; // Track the total wait time
        int waitIntervalInMillis = 1000; // 1 second interval between checks
        // Loop until the timeout is reached
        while (totalTimeWaited < timeoutInSeconds * 1000) {
            try {
                // Get the spinner element
                WebElement spinner = driver.findElement((By) spinnerLocator);

                // Check if the spinner is displayed
                if (spinner.isDisplayed()) {
                    System.out.println("Spinner is still visible. Waiting for 1 second...");

                    // Wait for 1 second before checking again
                    Thread.sleep(waitIntervalInMillis);

                    // Accumulate total wait time
                    totalTimeWaited += waitIntervalInMillis;
                } else {
                    // Spinner has disappeared, exit the loop
                    System.out.println("Spinner has disappeared.");
                    return true;
                }
            } catch (Exception e) {
                // If the spinner is not found, assume it has disappeared
                System.out.println("Spinner not found. Assuming it has disappeared.");
                return true;
            }
        }

        // If the loop ends without the spinner disappearing, return false
        System.out.println("Spinner did not disappear within the timeout.");
        return false;
    }

    public void scrollByVisibilityOfElement(WebElement element) {
        JavascriptExecutor jse = ((JavascriptExecutor) driver);
        jse.executeScript("arguments[0].scrollIntoView();", element);

    }

    public void switchToFrameByName(String nameValue) {
        boolean flag = false;
        if (nameValue.equals("default")) {
            driver.switchTo().defaultContent();
            System.out.println("Default frame is selected");
        } else {
            try {
                driver.switchTo().frame(nameValue);
                flag = true;
            } catch (Exception e) {
            } finally {
                if (flag) {
                    System.out.println("Frame with Name " + nameValue + " is selected");
                } else if (!flag) {
                    System.out.println("Frame with Name " + nameValue + " is not selected");
                }
            }
        }
    }

    public void pressEnterWithActions() {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();

    }

    public void acceptAlert(long durationInSeconds) {

        Alert alert = waitForAlert(durationInSeconds);
        alert.accept();

    }

    public void switchToNewWindow(int windowSize) {
        Set<String> s = driver.getWindowHandles();
        Object popup[] = s.toArray();
        try {
            driver.switchTo().window(popup[windowSize].toString());
        }catch(ArrayIndexOutOfBoundsException e) {

            e.printStackTrace();
        }
    }

    public boolean switchToFrameById(WebDriver driver, String idValue) {
        boolean flag = false;
        try {
            driver.switchTo().frame(idValue);
            flag = true;
            return true;
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        } finally {
            if (flag) {
                System.out.println("Frame with Id \"" + idValue + "\" is selected");
            } else {
                System.out.println("Frame with Id \"" + idValue + "\" is not selected");
            }
        }
    }

    // Method to switch back to the default content
    public void switchToDefaultContent(WebDriver driver) {
        try {
            driver.switchTo().defaultContent();
            System.out.println("Switched to default content successfully.");
        } catch (Exception e) {
            System.out.println("Failed to switch to default content: " + e.getMessage());
        }
    }





}
