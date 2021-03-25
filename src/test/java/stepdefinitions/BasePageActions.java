package stepdefinitions;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.DriverUtils;

import java.io.IOException;

import static utils.DriverUtils.setUp;

public class BasePageActions extends DriverUtils {

    private static WebElement element;
    private static WebDriver driver;

   static {
       try {
           driver = setUp();
       } catch (Exception e) {
           e.printStackTrace();
       }
   }

    private static JavascriptExecutor js = (JavascriptExecutor)driver;
    private static WebDriverWait wait = new WebDriverWait(driver,10);

    public static void gotoUrl(String url) throws Exception {
        driver.get(url);
    }


    public static void clickElementByXPath(String locator) throws IOException, InterruptedException  {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(ConfigReader.locator_Values(locator)))));
        driver.findElement(By.xpath(ConfigReader.locator_Values(locator))).click();
    }


    public static void selectElementByXpath(String val, String locator) throws Exception {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(ConfigReader.locator_Values(locator)))));
        Select ele=new Select(driver.findElement(By.xpath(ConfigReader.locator_Values(locator))));
        ele.selectByValue(val);
    }


    public static  void shouldSeeElement(String locator) throws IOException, InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(ConfigReader.locator_Values(locator)))));
        element=driver.findElement(By.xpath(ConfigReader.locator_Values(locator)));
        Assert.assertTrue(element.isDisplayed());
    }


    public static  void shouldNotSeeElement(String locator) throws IOException {

        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(ConfigReader.locator_Values(locator)))));
            element=driver.findElement(By.xpath(ConfigReader.locator_Values(locator)));
            Assert.assertFalse(element.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.assertFalse(false);
        }

    }

    public static void enterTextByLocator(String val, String locator) throws Exception {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(ConfigReader.locator_Values(locator)))));
        driver.findElement(By.xpath(ConfigReader.locator_Values(locator))).sendKeys(val);
    }


    public static void shouldVerify(String expectedText, String locator) throws IOException {
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
        String actualText=driver.findElement(By.xpath(ConfigReader.locator_Values(locator))).getText();
        Assert.assertEquals(actualText,String.valueOf(expectedText));
    }


    public static void chooseCategoryByLocator(String category, String locator) throws Exception {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(ConfigReader.locator_Values(locator)))));
        driver.findElement(By.xpath(ConfigReader.locator_Values(locator))).sendKeys(category);
        Actions action= new Actions(driver);
        driver.findElement(By.xpath(ConfigReader.locator_Values(locator))).click();
        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 2000);");
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

    }

}
