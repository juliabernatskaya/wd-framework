package com.epam.wdframework.util;

import com.epam.wdframework.driver.DriverSingleton;
import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

	private static final String DATE_TIME_FORMAT = "yyyy-MM-dd_HH-mm-ss";

	@Override
	public void onTestFailure(ITestResult result) {
		takeScreenshot();
	}

	private void takeScreenshot() {
		File screenshot = ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(".//target/screenshots/" + getCurrentTimeAsString() + ".png"));
		} catch (IOException ignored) {
		}
	}

	private String getCurrentTimeAsString() {
		return ZonedDateTime.now().format(DateTimeFormatter.ofPattern(DATE_TIME_FORMAT));
	}
}
