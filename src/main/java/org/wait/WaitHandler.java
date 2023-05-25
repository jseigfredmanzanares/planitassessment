package org.wait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class WaitHandler {

    private static WaitHandler waitHandler = new WaitHandler();

    private static CustomWait customWait;

    private static Wait<WebDriver> wait;

    private WaitHandler() {

    }

    public static WaitHandler getInstance() {
        return waitHandler;
    }

    public static Wait<WebDriver> Wait() {
        if (customWait == null) customWait = new CustomWait();

        return customWait.wait;
    }
}
