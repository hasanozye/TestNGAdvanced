package orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage extends BaseClass {

    public static final By lUsername = By.xpath("//input[@name='username']");
    public static final By lPassword = By.xpath("//input[@name='password']");
    public static final By lLoginBtn = By.xpath("//button[@type='submit']");
    public static final By lSearchBtn = By.xpath("//input[@placeholder='Search']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void openURL() {
        driver.get(getPropertyValue("orangehrm.url"));
    }

    public void loginCredentials() {
        sendKeys(lUsername, getPropertyValue("orangehrm.username"));
        sendKeys(lPassword, getPropertyValue("orangehrm.password"));
        click(lLoginBtn);
    }

    public void assertLogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lSearchBtn));
    }

}
