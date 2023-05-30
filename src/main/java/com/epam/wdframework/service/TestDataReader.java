package com.epam.wdframework.service;

import java.time.Duration;
import java.util.Optional;
import java.util.ResourceBundle;

public class TestDataReader {

	private static final String EMAIL_REFRESH_INTERVAL = "email.refresh.interval";
	private static final String EMAIL_REFRESH_TIMEOUT = "email.refresh.timeout";
	private static final ResourceBundle resourceBundle = ResourceBundle
			.getBundle(Optional.ofNullable(System.getProperty("env")).orElse("dev"));

	private TestDataReader() {
	}

	public static Duration getEmailRefreshInterval() {
		return Duration.ofSeconds((Integer.parseInt(getProperty(EMAIL_REFRESH_INTERVAL))));
	}

	public static Duration getEmailRefreshTimeout() {
		return Duration.ofSeconds((Integer.parseInt(getProperty(EMAIL_REFRESH_TIMEOUT))));
	}

	private static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}
