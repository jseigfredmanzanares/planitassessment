package org.driver.manager;

import org.openqa.selenium.WebDriver;

public class BaseDriver {

    private static WebDriver driver;
    private static DriverManager driverManager;

    public static void initialize(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome" :
                driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
                break;
            default: throw new UnsupportedOperationException(String.format("Browser '%s' is not yet supported!", browser));
        }

        driver = driverManager.getDriver();
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void stop() {
        driverManager.quitDriver();
    }
}
