package com.epam.wdframework;

import static org.testng.Assert.assertEquals;

import com.epam.wdframework.google.cloud.home.GoogleCloudPage;
import com.epam.wdframework.model.InstancesModelFactory;
import com.epam.wdframework.util.Shortcut;
import com.epam.wdframework.util.TextExtractor;
import com.epam.wdframework.yopmail.YopmailHomePage;
import java.time.Duration;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

public class PricingCalculatorTest extends WebDriverTest {

	private static final String GOOGLE_CLOUD_URL = "https://cloud.google.com";
	private static final String YOPMAIL_URL = "https://yopmail.com";

	@Test
	public void run() {
		var searchQuery = "Google Cloud Platform Pricing Calculator";

		webDriver.get(GOOGLE_CLOUD_URL);
		var googleTab = webDriver.getWindowHandle();

		var calculatorPage = new GoogleCloudPage(webDriver)
			.search(searchQuery)
			.tapGoogleCloudPlatformPricingCalculatorLink();

		calculatorPage.switchToComputeEngineConfigurator()
			.addInstancesConfiguration(InstancesModelFactory.buildDefaultInstancesModel())
			.addToEstimate();

		var totalCost = calculatorPage.toEstimations().getTotalCost();
		var emailEstimateForm = calculatorPage.toEstimations().emailEstimation();

		webDriver.switchTo().newWindow(WindowType.TAB);
		webDriver.get(YOPMAIL_URL);
		var yopmailTab = webDriver.getWindowHandle();

		var yopmail = new YopmailHomePage(webDriver)
			.tapRandomEmailLink()
			.tapCopyToClipboardButton()
			.tapCheckInboxButton();

		webDriver.switchTo().window(googleTab);

		emailEstimateForm
			.enterEmailAddress(Shortcut.paste())
			.sendEmail();

		webDriver.switchTo().window(yopmailTab);

		var emailBody = yopmail
			.waitForNewEmail(Duration.ofSeconds(1000))
			.getEmailText();

		assertEquals(totalCost, TextExtractor.extractTotalCostFromEmail(emailBody));
	}
}
