package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.URI;
import java.net.URL;

public class DriverFactory {
//    private static ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();
//    static WebDriver driver=null;
//    public static void initializeBrowser(String browserName){
//        switch (browserName) {
//            case "chrome" -> {
//                WebDriverManager.chromedriver().setup();
//                ChromeOptions options = new ChromeOptions();
//                options.addArguments("--disable-notifications");
//                driver = new ChromeDriver(options);
//            }
//            case "firefox" -> driver = new FirefoxDriver();
//            case "edge" -> driver = new EdgeDriver();
//            case "safari" -> driver = new SafariDriver();
//        }
//
//        localDriver.set(driver);
//    }
//    public static WebDriver getDriver(){
//
//
//        return localDriver.get();
//    }


    private static final ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();

    // You can set this via a config file or pass from hooks
    public static void initializeBrowser(String browserName, boolean isRemote) {
        try {
            if (isRemote) {
                // Remote/Grid execution
                URL gridUrl = URI.create("http://localhost:4444/wd/hub").toURL(); // Update if needed

                switch (browserName.toLowerCase()) {
                    case "chrome" -> {
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--disable-notifications");
                        localDriver.set(new RemoteWebDriver(gridUrl, chromeOptions));
                    }
                    case "firefox" -> {
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        localDriver.set(new RemoteWebDriver(gridUrl, firefoxOptions));
                    }
                    case "edge" -> {
                        EdgeOptions edgeOptions = new EdgeOptions();
                        localDriver.set(new RemoteWebDriver(gridUrl, edgeOptions));
                    }
                    case "safari" -> {
                        SafariOptions safariOptions = new SafariOptions();
                        localDriver.set(new RemoteWebDriver(gridUrl, safariOptions));
                    }
                    default -> throw new IllegalArgumentException("Browser not supported: " + browserName);
                }

            } else {
                // Local execution
                switch (browserName.toLowerCase()) {
                    case "chrome" -> {
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("--disable-notifications");
                        localDriver.set(new ChromeDriver(chromeOptions));
                    }
                    case "firefox" -> {
                        WebDriverManager.firefoxdriver().setup();
                        localDriver.set(new FirefoxDriver());
                    }
                    case "edge" -> {
                        WebDriverManager.edgedriver().setup();
                        localDriver.set(new EdgeDriver());
                    }
                    case "safari" -> localDriver.set(new SafariDriver());
                    default -> throw new IllegalArgumentException("Browser not supported: " + browserName);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Driver initialization failed: " + e.getMessage(), e);
        }
    }

    public static WebDriver getDriver() {
        return localDriver.get();
    }


}
