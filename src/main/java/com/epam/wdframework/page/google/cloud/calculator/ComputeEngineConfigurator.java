package com.epam.wdframework.page.google.cloud.calculator;

import com.epam.wdframework.common.Locatable;
import com.epam.wdframework.model.InstancesModel;
import com.epam.wdframework.page.google.cloud.calculator.select.option.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComputeEngineConfigurator extends GoogleCloudCalculatorFrame implements Locatable {

    private static final By LOCATOR = By.xpath("//div[@class='compute-engine-block']");

    @FindBy(xpath = "//label[contains(text(), 'Number of instances')]//following-sibling::input")
    private WebElement numberOfInstancesInput;
    @FindBy(xpath = "//label[contains(text(), 'Operating System / Software')]//following-sibling::md-select")
    private WebElement operatingSystemSelect;
    @FindBy(xpath = "//label[contains(text(), 'Provisioning model')]//following-sibling::md-select")
    private WebElement provisioningModelSelect;
    @FindBy(xpath = "//label[contains(text(), 'Series')]//following-sibling::md-select")
    private WebElement seriesSelect;
    @FindBy(xpath = "//label[contains(text(), 'Machine type')]//following-sibling::md-select")
    private WebElement machineTypeSelect;
    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGPUsCheckbox;
    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement graphicsTypeSelect;
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUsSelect;
    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement localSSDSelect;
    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
    private WebElement datacenterLocationSelect;
    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement commitedUsageSelect;
    @FindBy(xpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addToEstimateButton;

    protected ComputeEngineConfigurator(WebDriver webDriver) {
        super(webDriver);
    }

    public ComputeEngineConfigurator addInstancesConfiguration(InstancesModel instancesModel) {
        inputNumberOfInstances(instancesModel.getNumberOfInstances());
        selectOperatingSystem(instancesModel.getOperatingSystem());
        selectProvisioningModel(instancesModel.getProvisioningModel());
        selectSeries(instancesModel.getSeries());
        selectMachineType(instancesModel.getMachineType());
        addGraphics(instancesModel.getGraphicsType(), instancesModel.getGraphicsCount());
        selectLocalSSD(instancesModel.getLocalSSD());
        selectDatacenterLocation(instancesModel.getRegion());
        selectCommitedUsage(instancesModel.getCommitedUsage());
        return this;
    }

    public ComputeEngineConfigurator inputNumberOfInstances(int instances) {
        fillForm(numberOfInstancesInput, String.valueOf(instances));
        return this;
    }

    public ComputeEngineConfigurator selectOperatingSystem(OperatingSystem operatingSystem) {
        selectOption(operatingSystemSelect, operatingSystem.by());
        return this;
    }

    public ComputeEngineConfigurator selectProvisioningModel(ProvisioningModel provisioningModel) {
        selectOption(provisioningModelSelect, provisioningModel.by());
        return this;
    }

    public ComputeEngineConfigurator selectSeries(Series series) {
        selectOption(seriesSelect, series.by());
        return this;
    }

    public ComputeEngineConfigurator selectMachineType(MachineType machineType) {
        selectOption(machineTypeSelect, machineType.by());
        return this;
    }

    public ComputeEngineConfigurator addGraphics(GraphicsType type, GraphicsCount count) {
        clickElement(addGPUsCheckbox);
        selectOption(graphicsTypeSelect, type.by());
        selectOption(numberOfGPUsSelect, count.by());
        return this;
    }

    public ComputeEngineConfigurator selectLocalSSD(LocalSSD localSSD) {
        selectOption(localSSDSelect, localSSD.by());
        return this;
    }

    public ComputeEngineConfigurator selectDatacenterLocation(Region region) {
        selectOption(datacenterLocationSelect, region.by());
        return this;
    }

    public ComputeEngineConfigurator selectCommitedUsage(CommitedUsage commitedUsage) {
        selectOption(commitedUsageSelect, commitedUsage.by());
        return this;
    }

    public ComputeEngineConfigurator addToEstimate() {
        clickElement(addToEstimateButton);
        return this;
    }

    @Override
    public By getLocator() {
        return LOCATOR;
    }
}
