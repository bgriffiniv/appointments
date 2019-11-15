package com.bgriffiniv.challenges.nielsensports.appointments.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.Objects;

@Entity
public class Service {

	@Id
	@GeneratedValue
	private String id;
	//@ManyToMany
	private List<String> serviceList;

	public List<String> getServiceList() {
		return serviceList;
	}

	public void setServiceList(List<String> serviceList) {
		this.serviceList = serviceList;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Service)) return false;
		Service that = (Service) o;
		return getServiceList().equals(that.getServiceList());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getServiceList());
	}

	enum ServiceType {
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
