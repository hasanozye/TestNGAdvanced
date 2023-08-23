package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static demoqa.Locators.*;

public class DemoHomePage extends BaseClass {


    public DemoHomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public void login() {
        driver.get(url);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(lDelButtons, 1));
    }

    public void deleteTheTableDatas() {

        List<WebElement> dels = driver.findElements(lDelButtons);
        while (dels.size() > 0) {
            int initialSize = dels.size();
            click(dels.get(0));
            wait.until(ExpectedConditions.numberOfElementsToBeLessThan(lDelButtons, initialSize));
            dels = driver.findElements(lDelButtons);
        }


    }

}
