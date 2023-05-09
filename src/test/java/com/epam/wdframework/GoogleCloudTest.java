package com.epam.wdframework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import com.epam.wdframework.google.cloud.home.GoogleCloudPage;
import org.testng.annotations.Test;

public class GoogleCloudTest extends WebDriverTest {

	private static final String GOOGLE_CLOUD_URL = "https://cloud.google.com";

	@Test
	void googleCloudPageTitleTest() {
		webDriver.get(GOOGLE_CLOUD_URL);
		assertEquals("Cloud Computing Services  |  Google Cloud", webDriver.getTitle());
	}

	@Test
	void pricingCalculatorSearchTest() {
		webDriver.get(GOOGLE_CLOUD_URL);
		var searchQuery = "Google Cloud Platform Pricing Calculator";
		assertTrue(new GoogleCloudPage(webDriver).search(searchQuery).containsLinkWithText(searchQuery));
	}
}
