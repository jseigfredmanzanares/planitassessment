package org.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.Arrays;
import java.util.List;

public class WebListener implements WebDriverListener {

    public void beforeFindElement(WebDriver driver, By locator) {
        System.out.println("Attempting to locate element using " + locator.toString());
    }

    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        System.out.println("Element located using " + locator.toString());
    }

    public void beforeFindElements(WebDriver driver, By locator) {
        System.out.println("Attempting to locate element using " + locator.toString());
    }

    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        System.out.println("Element located using " + locator.toString());
    }

    public void beforeClick(WebElement element) {
        System.out.println("Attempting to click element " + element.toString());
    }

    public void afterClick(WebElement element) {
        System.out.println("Element was clicked " + element.toString());
    }

    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
        System.out.println("Attempting to send keys to element '" + element.toString() + "' with value of '" + Arrays.toString(keysToSend) + "'");
    }

    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        System.out.println("Sendkeys was performed to element '" + element.toString() + "' with value of '" +  Arrays.toString(keysToSend) + "'");
    }

    public void beforeClear(WebElement element) {
        System.out.println("Attempting to clear the element " + element.toString());
    }

    public void afterClear(WebElement element) {
        System.out.println("Element was cleared" + element.toString());
    }

    public void beforeIsDisplayed(WebElement element) {
        System.out.println("Attempting to get if element is displayed " + element.toString());
    }

    public void afterIsDisplayed(WebElement element, boolean result) {
        System.out.println("Element isDisplayed = '" + result + "'");
    }
}
