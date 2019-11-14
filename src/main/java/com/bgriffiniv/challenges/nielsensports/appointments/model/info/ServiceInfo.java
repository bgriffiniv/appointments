package com.bgriffiniv.challenges.nielsensports.appointments.model.info;

import java.util.List;

public class ServiceInfo {
	List<ServiceType> serviceTypeList;

	enum ServiceType {
		TIRE_ROTATION,
		TIRE_REPAIR
	}
}
