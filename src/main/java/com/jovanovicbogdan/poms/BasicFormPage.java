package com.jovanovicbogdan.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicFormPage {

    @FindBy(id = "first-name")
    WebElement firstName;

    public BasicFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
    }

    public void inputFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

}
