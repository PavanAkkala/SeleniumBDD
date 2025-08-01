package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    public static Properties initializeProperties(){
        Properties prop = new Properties();
        File propFile = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties");
        try {
            //String env = System.getProperty("env", "local");
            FileInputStream fis = new FileInputStream(propFile);
            prop.load(fis);
        }catch (Throwable e){
            e.printStackTrace();
        }
        return prop;
    }
}
