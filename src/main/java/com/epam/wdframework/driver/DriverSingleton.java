package com.epam.wdframework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.util.Optional;

public class DriverSingleton {

    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";
    private static final String SAFARI = "safari";
    private static WebDriver webDriver;

    public static WebDriver getDriver() {
        if (webDriver == null) {
            String browser = Optional.ofNullable(System.getProperty("browser")).orElse("chrome");
            switch (browser) {
                case CHROME: {
                    webDriver = WebDriverManager.chromedriver().create();
                    break;
                }
                case FIREFOX: {
                    webDriver = WebDriverManager.firefoxdriver().create();
                    break;
                }
                case SAFARI: {
                    webDriver = WebDriverManager.safaridriver().create();
                    break;
                }
                default: {
                    throw new IllegalArgumentException("'" + browser + "' is not supported browser");
                }
            }
        }
        webDriver.manage().window().maximize();
        return webDriver;
    }

    public static void closeDriver() {
        webDriver.quit();
        webDriver = null;
    }
}
