package com.epam.wdframework.page.google.cloud.calculator.select.option;

import org.openqa.selenium.By;

public enum ProvisioningModel {
    REGULAR("Regular");

    private final String value;

    ProvisioningModel(String value) {
        this.value = value;
    }

    public By by() {
        return By.xpath("//div[@aria-hidden='false']//md-option/div[contains(text(), '" + value + "')]");
    }

    public String value() {
        return value;
    }
}
