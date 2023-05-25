package org.driver.manager;

public class DriverManagerFactory {

    public static DriverManager getManager(DriverType type) {
        DriverManager driverManager;

        switch (type) {
            case CHROME :
                driverManager = new ChromeDriverManager();
                break;
            default: throw new UnsupportedOperationException(String.format("Type '%s' is not yet supported!", type));
        }

        return driverManager;
    }
}
