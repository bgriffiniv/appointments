package com.bgriffiniv.challenges.nielsensports.appointments.model;

import com.bgriffiniv.challenges.nielsensports.appointments.model.info.ContactInfo;
import com.bgriffiniv.challenges.nielsensports.appointments.model.info.ServiceInfo;
import com.bgriffiniv.challenges.nielsensports.appointments.model.info.VehicleInfo;

import java.util.List;
import java.util.Objects;

public class Appointment {

	private int appointmentId;
	private ContactInfo contactInfo;
	private VehicleInfo vehicleInfo;
	private ServiceInfo serviceInfo;
	private String notes;

}
