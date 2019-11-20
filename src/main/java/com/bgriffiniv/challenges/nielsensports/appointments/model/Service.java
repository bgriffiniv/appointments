package com.bgriffiniv.challenges.nielsensports.appointments.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.Objects;

@Entity
public class Service {

	@Id
	@GeneratedValue
	private String id;
    private String type;
    private String description;

	@ManyToMany(mappedBy = "serviceList")
    private List<Appointment> appointmentList;

	public Service() {
	}

	public Service(String id, String type, String description, List<Appointment> appointmentList) {
		this.id = id;
		this.type = type;
		this.description = description;
		this.appointmentList = appointmentList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Appointment> getAppointmentList() {
		return appointmentList;
	}

	public void setAppointmentList(List<Appointment> appointmentList) {
		this.appointmentList = appointmentList;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Service)) return false;
		Service service = (Service) o;
		return getId().equals(service.getId()) &&
				getType().equals(service.getType()) &&
				Objects.equals(getDescription(), service.getDescription()) &&
				Objects.equals(getAppointmentList(), service.getAppointmentList());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getType(), getDescription(), getAppointmentList());
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
