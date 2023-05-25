package org.fieldcontrols;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.wait.WaitHandler;

import java.util.ArrayList;
import java.util.List;

public class Navigation {

    private static List<WebElement> pages;

    public static void Navigate(String page) {
        init();
        for (WebElement p : pages) {
            if (p.getText().trim().contains(page)) {
                p.click();
                return;
            }
        }
        throw new IllegalArgumentException(String.format("Page '%s' is not displayed in the Navigation bar", page));
    }

    private static void init() {
        pages = new ArrayList<>();
        pages = WaitHandler.Wait().until(driver -> driver.findElements(By.xpath("//div[contains(@class,'navbar')]//ul//li//a")));
    }
}
