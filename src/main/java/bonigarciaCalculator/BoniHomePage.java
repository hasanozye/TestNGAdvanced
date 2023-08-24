package bonigarciaCalculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Driver;

import static bonigarciaCalculator.Locators.*;

import java.time.Duration;
import java.util.Random;

public class BoniHomePage extends BaseClass{

    public BoniHomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void login(){
        driver.get(url);
        wait.until(ExpectedConditions.titleContains("Selenium"));
    }

    public void calc(){
        int num = new Random().nextInt(10,20);
        WebDriverWait wait1 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(num + 1));



    }


}
