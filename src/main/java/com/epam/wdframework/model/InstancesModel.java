package com.epam.wdframework.model;

import com.epam.wdframework.page.google.cloud.calculator.select.option.*;

import java.util.Objects;

public class InstancesModel {

    private int numberOfInstances;
    private OperatingSystem operatingSystem;
    private ProvisioningModel provisioningModel;
    private Series series;
    private MachineType machineType;
    private GraphicsType graphicsType;
    private GraphicsCount graphicsCount;
    private LocalSSD localSSD;
    private Region region;
    private CommitedUsage commitedUsage;

    public int getNumberOfInstances() {
        return numberOfInstances;
    }

    public void setNumberOfInstances(int numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public OperatingSystem getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public ProvisioningModel getProvisioningModel() {
        return provisioningModel;
    }

    public void setProvisioningModel(
            ProvisioningModel provisioningModel) {
        this.provisioningModel = provisioningModel;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public MachineType getMachineType() {
        return machineType;
    }

    public void setMachineType(MachineType machineType) {
        this.machineType = machineType;
    }

    public GraphicsType getGraphicsType() {
        return graphicsType;
    }

    public void setGraphicsType(GraphicsType graphicsType) {
        this.graphicsType = graphicsType;
    }

    public GraphicsCount getGraphicsCount() {
        return graphicsCount;
    }

    public void setGraphicsCount(GraphicsCount graphicsCount) {
        this.graphicsCount = graphicsCount;
    }

    public LocalSSD getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(LocalSSD localSSD) {
        this.localSSD = localSSD;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public CommitedUsage getCommitedUsage() {
        return commitedUsage;
    }

    public void setCommitedUsage(CommitedUsage commitedUsage) {
        this.commitedUsage = commitedUsage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InstancesModel that = (InstancesModel) o;
        return numberOfInstances == that.numberOfInstances && operatingSystem == that.operatingSystem
                && provisioningModel == that.provisioningModel && series == that.series && machineType == that.machineType
                && graphicsType == that.graphicsType && graphicsCount == that.graphicsCount && localSSD == that.localSSD
                && region == that.region && commitedUsage == that.commitedUsage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfInstances, operatingSystem, provisioningModel, series, machineType, graphicsType,
                graphicsCount, localSSD, region, commitedUsage);
    }
}
