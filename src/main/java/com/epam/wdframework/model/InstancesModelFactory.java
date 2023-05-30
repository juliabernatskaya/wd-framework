package com.epam.wdframework.model;

import com.epam.wdframework.page.google.cloud.calculator.select.option.*;

public class InstancesModelFactory {

    private InstancesModelFactory() {
    }

    public static InstancesModel buildDefaultInstancesModel() {
        var instancesModel = new InstancesModel();
        instancesModel.setNumberOfInstances(4);
        instancesModel.setOperatingSystem(OperatingSystem.FREE);
        instancesModel.setProvisioningModel(ProvisioningModel.REGULAR);
        instancesModel.setSeries(Series.N1);
        instancesModel.setMachineType(MachineType.N1_STANDARD_8);
        instancesModel.setGraphicsType(GraphicsType.NVIDIA_TESLA_V100);
        instancesModel.setGraphicsCount(GraphicsCount.COUNT_1);
        instancesModel.setLocalSSD(LocalSSD.GB_2_X_375);
        instancesModel.setRegion(Region.FRANKFURT);
        instancesModel.setCommitedUsage(CommitedUsage.ONE_YEAR);
        return instancesModel;
    }
}
