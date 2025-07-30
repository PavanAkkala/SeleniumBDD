package hooks;

import factory.DriverFactory;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.ScreenshotUtil;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;

public class MyHooks {
    WebDriver driver;

    @Before
    public void setup(){
        Properties prop = ConfigReader.initializeProperties();
        //DriverFactory.initializeBrowser(prop.getProperty("browser")); this is previous one must be used
        String browser = prop.getProperty("browser");
        boolean isRemote = Boolean.parseBoolean(prop.getProperty("remote")); // e.g., "true" or "false"
        DriverFactory.initializeBrowser(browser, isRemote);
        driver=DriverFactory.getDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(prop.getProperty("url"));
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            String screenshotPath = ScreenshotUtil.takeScreenshot(driver, scenario.getName());
            System.out.println("Screenshot saved at: "+ screenshotPath);
            try{
                byte[] screenshot = Files.readAllBytes(Paths.get(screenshotPath));
                scenario.attach(screenshot, "image/png", scenario.getName());
            } catch (Exception e) {
                throw new RuntimeException("Failed to attach screenshot: "+ e.getMessage());
            }
        }
       // driver.quit();
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Browser Closed");
    }

}
