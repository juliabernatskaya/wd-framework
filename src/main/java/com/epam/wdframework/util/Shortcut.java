package com.epam.wdframework.util;

import org.openqa.selenium.Keys;

public class Shortcut {

	private Shortcut() {
	}

	public static String paste() {
		return Keys.chord(Keys.COMMAND, "v");
	}
}
