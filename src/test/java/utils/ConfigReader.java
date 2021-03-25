package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static final String CONFIG_FILEPATH = "./config.properties";
    private static final String LOCATORS = "src//test//java//Locator//locator.properties";

    static Properties properties = new Properties();

    public static String getConfigValue(String key) throws Exception {

        File file = new File(CONFIG_FILEPATH);
        FileInputStream fileInputStream = new FileInputStream(file);
        properties.load(fileInputStream);
        return properties.getProperty(key);
    }

    public Long getTimeout() throws Exception {
        String timeout = ConfigReader.getConfigValue("timeout");
        return Long.parseLong(timeout);
    }

    public static String locator_Values(String value) throws IOException {
        File file = new File(LOCATORS);
        FileInputStream in= new FileInputStream(file);
        properties.load(in);
        return properties.getProperty(value);

    }

}