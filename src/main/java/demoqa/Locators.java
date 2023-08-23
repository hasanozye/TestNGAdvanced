package demoqa;

import org.openqa.selenium.By;

public interface Locators {
    String url = "https://demoqa.com/webtables";
    By lDelButtons = By.xpath("//span[starts-with(@id,'delete')]");
    By lAddButton = By.xpath("//button[@id='addNewRecordButton']");
    By lFirstName = By.cssSelector("#firstName");
    By lLastName = By.cssSelector("#lastName");
    By lEmail = By.cssSelector("#userEmail");
    By lAge = By.cssSelector("#age");
    By lSalary = By.cssSelector("#salary");
    By lDepartment = By.cssSelector("#department");
    By lSubmitButton = By.id("submit");
    By lSortByFirstName = By.xpath("//div[text()='First Name']");
}
