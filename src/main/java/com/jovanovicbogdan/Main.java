package com.jovanovicbogdan;

import com.jovanovicbogdan.poms.BasicFormPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://jovanovicbogdan.github.io/toolbelt-qa/#/elements/basic-form");

        BasicFormPage basicFormPage = new BasicFormPage(driver);
        basicFormPage.inputFirstName("Bogdan");

        driver.quit();
    }
}