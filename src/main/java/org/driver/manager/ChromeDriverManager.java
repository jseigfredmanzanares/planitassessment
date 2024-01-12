package org.driver.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.util.WebListener;

import java.io.File;

public class ChromeDriverManager extends DriverManager{

    ChromeDriverService chromeDriverService;

    @Override
    void startService() {
        if (chromeDriverService == null) {
            chromeDriverService = new ChromeDriverService.Builder()
                    .usingDriverExecutable(new File(System.getProperty("user.dir") + "/resources/driver/chromedriver.exe"))
                    .usingAnyFreePort()
                    .build();
        }
    }

    @Override
    void createService() {
        ChromeOptions options = new ChromeOptions();
        WebDriver webDriver = new ChromeDriver(chromeDriverService, options);
        WebDriverListener listener = new WebListener();
        driver = new EventFiringDecorator<WebDriver>(listener).decorate(webDriver);
        //test comment
    }

    @Override
    public WebDriver getDriver() {
        if (this.driver == null) {
            startService();
            createService();
        }

        return this.driver;
    }

}
