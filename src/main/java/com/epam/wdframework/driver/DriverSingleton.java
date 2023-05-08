package com.epam.wdframework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
	private static WebDriver webDriver;

	public static WebDriver getDriver() {
		if (webDriver == null) {
			switch (System.getProperty("browser")) {
				case "firefox": {
					WebDriverManager.firefoxdriver().setup();
					webDriver = new FirefoxDriver();
					break;
				}
				default: {
					WebDriverManager.chromedriver().setup();
					webDriver = new ChromeDriver();
				}
			}
			webDriver.manage().window().maximize();
		}
		return webDriver;
	}

	public static void closeDriver() {
		webDriver.quit();
		webDriver = null;
	}
}
