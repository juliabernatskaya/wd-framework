package com.epam.wdframework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public abstract class PageObject {

    protected static final int DEFAULT_WAIT_DURATION_SEC = 15;

    protected final WebDriver webDriver;
    protected final WebDriverWait wait;

    protected PageObject(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(DEFAULT_WAIT_DURATION_SEC));
        init(webDriver);
    }

    protected void clickElement(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    protected void clickElement(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    protected void fillForm(WebElement form, String text) {
        wait.until(ExpectedConditions.visibilityOf(form)).sendKeys(text);
    }

    protected void selectOption(WebElement select, By option) {
        clickElement(select);
        clickElement(option);
    }

    protected String getElementText(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement)).getText();
    }

    protected String getElementsText(List<WebElement> webElements) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(webElements))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.joining("\n"));
    }

    protected void waitForElement(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected void init(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
