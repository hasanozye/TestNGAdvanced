package utils;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import io.github.bonigarcia.wdm.managers.SafariDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    public static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
//    private static WebDriver driver;

    public static WebDriver getDriver() {
        return getDriver(Browsers.CHROME);
    }

    public static WebDriver getDriver(Browsers browser) {
        if (drivers.get() == null) {
            switch (browser) {
                case FIREFOX -> {
                    FirefoxDriverManager.firefoxdriver().setup();
                    drivers.set(new FirefoxDriver());
                }
                case EDGE -> {
                    EdgeDriverManager.edgedriver().setup();
                    drivers.set(new EdgeDriver());
                }
                case SAFARI -> {
                    SafariDriverManager.safaridriver().setup();
                    drivers.set(new SafariDriver());
                }
                default -> {
                    ChromeDriverManager.chromedriver().setup();
                    drivers.set(new ChromeDriver());
                }
            }
        }
        return drivers.get();
    }

    public static void tearDown() {
        if (drivers.get() != null) {
            getDriver().quit();
            drivers.set(null);
        }
    }
}
