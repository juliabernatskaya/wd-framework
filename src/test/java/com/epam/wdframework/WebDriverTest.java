package com.epam.wdframework;

import com.epam.wdframework.driver.DriverSingleton;
import com.epam.wdframework.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
public abstract class WebDriverTest {

	protected WebDriver webDriver;

	@BeforeMethod
	protected void setUp() {
		webDriver = DriverSingleton.getDriver();
	}

	@AfterMethod(alwaysRun = true)
	protected void tearDown() {
		DriverSingleton.closeDriver();
	}
}
