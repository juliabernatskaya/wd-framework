package com.epam.wdframework.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {

	private static WebDriver webDriver;

	public static WebDriver getDriver() {
		if (webDriver == null) {
			webDriver = WebDriverInitializer.getByBrowserTitle(System.getProperty("browser")).initWebDriver();
		}
		webDriver.manage().window().maximize();
		return webDriver;
	}

	public static void closeDriver() {
		webDriver.quit();
		webDriver = null;
	}

	private enum WebDriverInitializer {
		CHROME_INITIALIZER("chrome", () -> WebDriverManager.chromedriver().setup(), ChromeDriver::new),
		FIREFOX_INITIALIZER("firefox", () -> WebDriverManager.chromedriver().setup(), FirefoxDriver::new);

		private static final Map<String, WebDriverInitializer> titleMap = Arrays.stream(values())
			.collect(Collectors.toUnmodifiableMap(webDriverInitializer -> webDriverInitializer.title,
				webDriverInitializer -> webDriverInitializer));

		private final String title;
		private final Runnable driverSetup;
		private final Supplier<WebDriver> driverSupplier;

		WebDriverInitializer(String title, Runnable driverSetup, Supplier<WebDriver> driverSupplier) {
			this.title = title;
			this.driverSetup = driverSetup;
			this.driverSupplier = driverSupplier;
		}

		public static WebDriverInitializer getByBrowserTitle(String title) {
			if (title == null) {
				return CHROME_INITIALIZER;
			}
			return Optional.ofNullable(titleMap.get(title)).orElse(CHROME_INITIALIZER);
		}

		public WebDriver initWebDriver() {
			driverSetup();
			return getDriverInstance();
		}

		private void driverSetup() {
			driverSetup.run();
		}

		private WebDriver getDriverInstance() {
			return driverSupplier.get();
		}
	}
}
