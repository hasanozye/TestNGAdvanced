package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    }

    public void deleteTheTableDatas() {
        click(lFirstDelete);
        click(lSecondDelete);
        click(lThirdDelete);
    }

}
