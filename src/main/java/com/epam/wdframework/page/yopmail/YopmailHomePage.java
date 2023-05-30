package com.epam.wdframework.page.yopmail;

import com.epam.wdframework.page.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YopmailHomePage extends PageObject {

    @FindBy(xpath = "//div[@id='listeliens']/a[@href='email-generator']")
    private WebElement randomEmailLink;

    public YopmailHomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public YopmailRandomGeneratorPage tapRandomEmailLink() {
        clickElement(randomEmailLink);
        return new YopmailRandomGeneratorPage(webDriver);
    }
}
