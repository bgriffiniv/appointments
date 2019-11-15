package com.bgriffiniv.challenges.nielsensports.appointments.model;

import com.bgriffiniv.challenges.nielsensports.appointments.model.info.AvailabilityInfo;
import com.bgriffiniv.challenges.nielsensports.appointments.model.info.ContactInfo;
import com.bgriffiniv.challenges.nielsensports.appointments.model.info.ServiceInfo;
import com.bgriffiniv.challenges.nielsensports.appointments.model.info.VehicleInfo;

import java.util.List;
import java.util.Objects;

public class Appointment {

	private String appointmentId;
	private ContactInfo contactInfo;
	private VehicleInfo vehicleInfo;
	private ServiceInfo serviceInfo;
	private AvailabilityInfo availabilityInfo;
	private String notes;

	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public VehicleInfo getVehicleInfo() {
		return vehicleInfo;
	}

	public void setVehicleInfo(VehicleInfo vehicleInfo) {
		this.vehicleInfo = vehicleInfo;
	}

	public ServiceInfo getServiceInfo() {
		return serviceInfo;
	}

	public void setServiceInfo(ServiceInfo serviceInfo) {
		this.serviceInfo = serviceInfo;
	}

	public AvailabilityInfo getAvailabilityInfo() {
		return availabilityInfo;
	}

	public void setAvailabilityInfo(AvailabilityInfo availabilityInfo) {
		this.availabilityInfo = availabilityInfo;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Appointment)) return false;
		Appointment that = (Appointment) o;
		return getAppointmentId().equals(that.getAppointmentId()) &&
				getContactInfo().equals(that.getContactInfo()) &&
				getVehicleInfo().equals(that.getVehicleInfo()) &&
				getServiceInfo().equals(that.getServiceInfo()) &&
				getAvailabilityInfo().equals(that.getAvailabilityInfo()) &&
				Objects.equals(getNotes(), that.getNotes());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getAppointmentId(), getContactInfo(), getVehicleInfo(), getServiceInfo(), getAvailabilityInfo(), getNotes());
	}
}
