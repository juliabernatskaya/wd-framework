package com.epam.wdframework;

import com.epam.wdframework.page.google.cloud.home.GoogleCloudPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GoogleCloudTest extends WebDriverTest {

    private static final String GOOGLE_CLOUD_URL = "https://cloud.google.com";

    @Test
    void googleCloudPageTitleTest() {
        webDriver.get(GOOGLE_CLOUD_URL);
        assertEquals("Cloud Computing Services  |  Google Cloud", webDriver.getTitle(),
                "page title doesn't match with expected one");
    }

    @Test
    void pricingCalculatorSearchTest() {
        webDriver.get(GOOGLE_CLOUD_URL);
        var searchQuery = "Google Cloud Platform Pricing Calculator";
        assertTrue(new GoogleCloudPage(webDriver).search(searchQuery).containsLinkWithText(searchQuery),
                "no pricing calculator on search result page");
    }

    @Test
    void thisTestShouldFail() {
        webDriver.get(GOOGLE_CLOUD_URL);
        assertEquals("foo", webDriver.getTitle(), "this fail is expected");
    }
}
