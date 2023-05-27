package org.driver.manager;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    WebDriver driver;

    abstract void startService();
    abstract void createService();
    abstract WebDriver getDriver();

    public void quitDriver() {
        if (this.driver != null)
            this.driver.quit();
    }


}
