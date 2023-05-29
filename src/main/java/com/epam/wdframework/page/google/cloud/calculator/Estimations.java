package com.epam.wdframework.page.google.cloud.calculator;

import com.epam.wdframework.common.Locatable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Estimations extends GoogleCloudCalculatorFrame implements Locatable {

    private static final By LOCATOR = By.id("resultBlock");
    private static final String TOTAL_COST_REGEX = "(?<=Total Estimated Cost:\\s)(.*?)(?=\\sper 1 month)";
    @FindBy(xpath = "//div[@class='cpc-cart-total']/descendant::b")
    private WebElement totalCostRow;
    @FindBy(xpath = "//button[@title='Email Estimate']")
    private WebElement emailEstimationButton;

    private final ComputeEngineEstimation computeEngineEstimation;

    protected Estimations(WebDriver webDriver) {
        super(webDriver);
        computeEngineEstimation = new ComputeEngineEstimation(webDriver);
    }

    public ComputeEngineEstimation toComputeEngineEstimation() {
        waitForElement(computeEngineEstimation.getLocator());
        return computeEngineEstimation;
    }

    public String getTotalCost() {
        var totalCostRowValue = getElementText(totalCostRow);
        return Pattern.compile(TOTAL_COST_REGEX).matcher(totalCostRowValue)
                .results()
                .map(MatchResult::group)
                .findFirst()
                .orElse(totalCostRowValue);
    }

    public EmailEstimationForm emailEstimation() {
        clickElement(emailEstimationButton);
        var emailEstimateForm = new EmailEstimationForm(webDriver);
        waitForElement(emailEstimateForm.getLocator());
        return emailEstimateForm;
    }

    @Override
    public By getLocator() {
        return LOCATOR;
    }
}
