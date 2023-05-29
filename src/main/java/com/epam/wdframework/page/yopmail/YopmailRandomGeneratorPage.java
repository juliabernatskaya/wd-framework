package com.epam.wdframework.page.yopmail;

import com.epam.wdframework.common.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopmailRandomGeneratorPage extends PageObject {

    protected YopmailRandomGeneratorPage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "cprnd")
    private WebElement copyToClipboardButton;

    @FindBy(xpath = "//button[@onclick='egengo();']")
    private WebElement checkInboxButton;

    public YopmailRandomGeneratorPage tapCopyToClipboardButton() {
        clickElement(copyToClipboardButton);
        return this;
    }

    public YopmailMailboxPage tapCheckInboxButton() {
        clickElement(checkInboxButton);
        return new YopmailMailboxPage(webDriver);
    }
}
