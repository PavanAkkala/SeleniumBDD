package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String screenshotName){
        try{
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMdd_HHmmss"));
            String filePath = "Screenshots/"+screenshotName+"_"+timestamp+".png";
            Path destination = Paths.get(filePath);
            Files.createDirectories(destination.getParent());
            Files.copy(source.toPath(), destination);
            return filePath;
        } catch (Exception e) {
            throw new RuntimeException("Failed to take screenshot: "+ e.getMessage());
        }
    }
}
