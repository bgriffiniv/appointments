package com.bgriffiniv.challenges.nielsensports.appointments.model.info;

import java.util.List;
import java.util.Objects;

public class ServiceInfo {
	List<String> serviceList;

	public List<String> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<String> serviceList) {
		this.serviceList = serviceList;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ServiceInfo)) return false;
		ServiceInfo that = (ServiceInfo) o;
		return getServiceList().equals(that.getServiceList());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getServiceList());
	}

	enum Service {
		TIRE_ROTATION,
		TIRE_REPAIR,
		TIRE_CHANGE,
		ENGINE_DIAGNOSTICS,
		ENGINE_REPAIR,
		BRAKE_CHANGE,
		TUNE_UP,
		TRANSMISSION_FLUID,
		WIPER_BLADES,
		WIPER_FLUID
	}
}
