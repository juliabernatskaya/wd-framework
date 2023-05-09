package com.epam.wdframework.service;

import java.time.Duration;
import java.util.ResourceBundle;

public class TestDataReader {

	private static final ResourceBundle resourceBundle =
		System.getProperty("env") == null ? ResourceBundle.getBundle("dev") :
			ResourceBundle.getBundle(System.getProperty("env"));

	public static Duration getEmailRefreshInterval() {
		return Duration.ofSeconds((Integer.parseInt(getProperty("email.refresh.interval"))));
	}

	public static Duration getEmailRefreshTimeout() {
		return Duration.ofSeconds((Integer.parseInt(getProperty("email.refresh.timeout"))));

	}

	private static String getProperty(String key) {
		return resourceBundle.getString(key);
	}
}
