package com.epam.wdframework.util;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class TextExtractor {
	private static final String TOTAL_COST_EMAIL_REGEX = "(?<=Total Estimated Monthly Cost\\s)(.*?)(?=\\n)";

	private TextExtractor() {
	}

	public static String extractTotalCostFromEmail(String emailBody) {
		return Pattern.compile(TOTAL_COST_EMAIL_REGEX).matcher(emailBody)
			.results()
			.map(MatchResult::group)
			.findFirst()
			.orElse(emailBody);
	}
}
