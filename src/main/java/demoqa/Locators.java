package demoqa;

import org.openqa.selenium.By;

public interface Locators {
    String url = "https://demoqa.com/webtables";
    By lFirstDelete = By.xpath("//span[@id='delete-record-1']");
    By lSecondDelete = By.xpath("//span[@id='delete-record-2']");
    By lThirdDelete = By.xpath("//span[@id='delete-record-3']");
    By lAddButton = By.xpath("//button[@id='addNewRecordButton']");
    By lFirstName = By.cssSelector("#firstName");
    By lLastName = By.cssSelector("#lastName");
    By lEmail = By.cssSelector("#userEmail");
    By lAge = By.cssSelector("#age");
    By lSalary = By.cssSelector("#salary");
    By lDepartment = By.cssSelector("#department");
    By lSubmitButton = By.id("submit");
}
