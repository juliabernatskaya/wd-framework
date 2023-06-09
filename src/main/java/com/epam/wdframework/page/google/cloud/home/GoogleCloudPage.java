package com.epam.wdframework.page.google.cloud.home;

import com.epam.wdframework.page.PageObject;
import com.epam.wdframework.page.google.cloud.search.result.GoogleCloudSearchResultsPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudPage extends PageObject {

    @FindBy(xpath = "//input[@aria-label = 'Search']")
    private WebElement searchInput;

    public GoogleCloudPage(WebDriver webDriver) {
        super(webDriver);
    }

    public GoogleCloudSearchResultsPage search(String searchQuery) {
        fillForm(searchInput, searchQuery + Keys.ENTER);
        return new GoogleCloudSearchResultsPage(webDriver);
    }
}
