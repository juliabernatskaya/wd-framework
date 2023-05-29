package com.epam.wdframework.yopmail;

import com.epam.wdframework.common.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class YopmailMailboxPage extends PageObject {

    private static final String MAIL_FRAME = "ifmail";

    @FindBy(id = "nbmail")
    private WebElement emailCountTag;
    @FindBy(id = "refresh")
    private WebElement refreshButton;
    @FindBy(id = "mail")
    private WebElement emailBody;

    protected YopmailMailboxPage(WebDriver webDriver) {
        super(webDriver);
    }

    public YopmailMailboxPage tapRefreshButton() {
        clickElement(refreshButton);
        return this;
    }

    public int getEmailCount() {
        return Integer.parseInt(getElementText(emailCountTag).replaceAll("\\D*", ""));
    }

    public String getEmailText() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(MAIL_FRAME));
        String emailText = getElementText(emailBody);
        webDriver.switchTo().defaultContent();
        return emailText;
    }

    public YopmailMailboxPage waitForNewEmail(Duration polling, Duration timeout) {
        var initialEmailCount = getEmailCount();
        wait
                .withTimeout(timeout)
                .pollingEvery(polling)
                .until(webDriver -> {
                    clickElement(refreshButton);
                    return getEmailCount() > initialEmailCount;
                });
        return this;
    }
}
