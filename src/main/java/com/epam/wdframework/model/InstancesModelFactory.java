package com.epam.wdframework.model;

import com.epam.wdframework.google.cloud.calculator.select.option.CommitedUsage;
import com.epam.wdframework.google.cloud.calculator.select.option.GraphicsCount;
import com.epam.wdframework.google.cloud.calculator.select.option.GraphicsType;
import com.epam.wdframework.google.cloud.calculator.select.option.LocalSSD;
import com.epam.wdframework.google.cloud.calculator.select.option.MachineType;
import com.epam.wdframework.google.cloud.calculator.select.option.OperatingSystem;
import com.epam.wdframework.google.cloud.calculator.select.option.ProvisioningModel;
import com.epam.wdframework.google.cloud.calculator.select.option.Region;
import com.epam.wdframework.google.cloud.calculator.select.option.Series;

public class InstancesModelFactory {

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
