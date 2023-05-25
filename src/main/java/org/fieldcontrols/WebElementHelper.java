package org.fieldcontrols;

import org.driver.manager.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class WebElementHelper {

    public static boolean isElementPresent(By by) {
        try {
            BaseDriver.getDriver().findElement(by);
            return true;
        }
        catch (NoSuchElementException ex) { return false; }

    }

}
