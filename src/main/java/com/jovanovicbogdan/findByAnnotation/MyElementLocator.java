package com.jovanovicbogdan.findByAnnotation;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ElementLocator;

import java.lang.reflect.Field;
import java.util.List;

public class MyElementLocator implements ElementLocator {
    private SearchContext searchContext;
    private By by;

    public MyElementLocator(SearchContext searchContext, Field field) {
        this.searchContext = searchContext;

        FindByDataTestId annotation = field.getAnnotation(FindByDataTestId.class);
        String dataTestId = annotation.value();
        String css = String.format("[data-testid='%s']", dataTestId);

        this.by = By.cssSelector(css);
    }

    @Override
    public WebElement findElement() {
        return searchContext.findElement(by);
    }

    @Override
    public List<WebElement> findElements() {
        return searchContext.findElements(by);
    }
}
