package com.jovanovicbogdan;

import com.jovanovicbogdan.findByAnnotation.CustomAnnotationHandler;
import com.jovanovicbogdan.poms.BasicFormPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://jovanovicbogdan.github.io/toolbelt-qa/#/elements/basic-form");

        BasicFormPage basicFormPage = CustomAnnotationHandler.initElements(driver, new BasicFormPage(driver));
        basicFormPage.firstName.sendKeys("Bogdan");
        basicFormPage.lastName.sendKeys("Jovanovic");

        driver.quit();
    }
}
