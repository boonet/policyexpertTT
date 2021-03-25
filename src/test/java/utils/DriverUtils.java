package utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static utils.ConfigReader.getConfigValue;

public class DriverUtils {

    private static WebDriver driver;
    @BeforeClass
    public static WebDriver setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", getConfigValue("mac.chrome.path")); //todo: change "mac.chrome.path" to "win.chrome.path" if running on windows

        ConfigReader configReader = new ConfigReader();

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(configReader.getTimeout(), TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(configReader.getTimeout(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
    @AfterClass
    public static void tearDown() throws Exception{
        driver.quit();
    }
    }
