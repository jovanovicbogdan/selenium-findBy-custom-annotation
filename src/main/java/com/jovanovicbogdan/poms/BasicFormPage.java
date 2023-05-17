package com.jovanovicbogdan.poms;

import com.jovanovicbogdan.findByAnnotation.FindByDataTestId;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicFormPage {

    @FindByDataTestId(value = "first-name")
    public WebElement firstName;

    @FindByDataTestId(value = "last-name")
    public WebElement lastName;

    public BasicFormPage(WebDriver driver) {
         PageFactory.initElements(driver, this);
         driver.manage().window().maximize();
    }

//    public void inputFirstName(String firstName) {
//        this.firstName.sendKeys(firstName);
//    }

//    public void inputLastName(String lastName) {
//        this.lastName.sendKeys(lastName);
//    }
}
