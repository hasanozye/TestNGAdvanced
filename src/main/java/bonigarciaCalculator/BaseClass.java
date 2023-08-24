package bonigarciaCalculator;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.DriverStatic;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class BaseClass {


    protected WebDriver driver;
    protected WebDriverWait wait;
    static String filePath = "src/main/resources/config.properties";

    @BeforeTest
    public void setupDriver() {
        driver = DriverStatic.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterTest
    public void tearDown() {
//        DriverStatic.tearDown();
    }

    public static String getPropertyValue(String value) {
        Properties properties = new Properties();
        try {
            FileReader fileReader = new FileReader(filePath);
            properties.load(fileReader);
            fileReader.close();
            return properties.getProperty(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Clicks on a WebElement after ensuring it is visible.
     *
     * @param element The WebElement to be clicked.
     */
    public void click(WebElement element) {
        waitUntilVisible(element).click();
    }

    public void click(By locator) {
        waitUntilVisible(locator);
        WebElement element1 = driver.findElement(locator);
        click(element1);
    }

    /**
     * Enters text into a WebElement after ensuring it is clickable and clearing its contents.
     *
     * @param element The WebElement to which text will be entered.
     * @param text    The text to be entered into the element.
     */
    public void sendKeys(WebElement element, CharSequence... text) {
        WebElement element1 = waitUntilClickable(element);
        element1.clear();
        element1.sendKeys(text);
    }

    public void sendKeys(By locator, CharSequence... text) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        sendKeys(element, text);
    }

    public void sendKeys(By locator, String text) {
        waitUntilVisible(locator);
        WebElement element = driver.findElement(locator);
        sendKeys(element, text);
    }

    /**
     * Waits until a WebElement is visible on the page.
     *
     * @param element The WebElement to wait for.
     * @return The WebElement that became visible.
     */
    public WebElement waitUntilVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitUntilVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Waits until a WebElement is clickable on the page.
     *
     * @param element The WebElement to wait for.
     * @return The WebElement that became clickable.
     */
    public WebElement waitUntilClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void tScreenShot(String name) {
        String fileDest = "screenshots/" + name + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".png";
        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File target = new File(fileDest);
        try {
            FileUtils.copyFile(source, target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
