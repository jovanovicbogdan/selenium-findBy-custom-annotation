package com.jovanovicbogdan.findByAnnotation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler;
import org.openqa.selenium.support.pagefactory.internal.LocatingElementListHandler;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;

public class CustomAnnotationHandler {

    public static <T> T initElements(WebDriver driver, T pageObject) {
        Field[] fields = pageObject.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FindByDataTestId.class)) {
                FindByDataTestId findByDataTestId = field.getAnnotation(FindByDataTestId.class);
                String selector = String.format("[data-testid='%s']", findByDataTestId.value());

                WebElement element = driver.findElement(By.cssSelector(selector));

                field.setAccessible(true);
                try {
                    field.set(pageObject, element);
                } catch(IllegalAccessException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return pageObject;
    }

    /**
     * Method for processing of Page Object for implementing functionality of @FindByDataTestId.
     * Require Page Object class which use annotation and returning same Page Object class with
     * functional WebElement variables.
     *
     * @param pomEntity annotated Page Object
     * @return pomEntity functional Page Object
     */
//    public static <T> T initElements(T pomEntity) {
//        Class<?> pomClass = pomEntity.getClass();
//
//        try {
//            Field driverField = pomClass.getField("driver");
//            RemoteWebDriver driver = (RemoteWebDriver) driverField.get(pomEntity);
//            for (Field field : pomClass.getDeclaredFields()) {
//                FindByDataTestId annotation = field.getAnnotation(FindByDataTestId.class);
//                if (annotation != null) {
//                    field.setAccessible(true);
//
//                    ClassLoader loader = pomClass.getClassLoader();
//                    MyElementLocator locator = new MyElementLocator(driver, field);
//
//                    if (List.class.isAssignableFrom(field.getType())) {
//                        InvocationHandler handler = new LocatingElementListHandler(locator);
//                        List<WebElement> proxy;
//                        proxy = (List<WebElement>) Proxy
//                                .newProxyInstance(loader, new Class[]{List.class}, handler);
//                        field.set(pomEntity, proxy);
//                    } else {
//                        InvocationHandler handler = new LocatingElementHandler(locator);
//                        WebElement proxy;
//                        proxy = (WebElement) Proxy.newProxyInstance(
//                                loader, new Class[]{WebElement.class, WrapsElement.class, Locatable.class},
//                                handler);
//                        field.set(pomEntity, proxy);
//                    }
//                }
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//        return pomEntity;
//    }

}
