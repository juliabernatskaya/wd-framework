package com.epam.wdframework;

import com.epam.wdframework.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class WebDriverTest {
	protected WebDriver webDriver;

	@BeforeMethod
	protected void setUp() {
		webDriver = DriverSingleton.getDriver();
	}

	@AfterMethod
	protected void tearDown() {
		DriverSingleton.closeDriver();
	}
}
