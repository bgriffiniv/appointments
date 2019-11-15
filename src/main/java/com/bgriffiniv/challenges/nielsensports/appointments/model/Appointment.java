package com.bgriffiniv.challenges.nielsensports.appointments.model;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Appointment {

	@Id
	@GeneratedValue
	private String id;
	@ManyToOne
	@JoinColumn(name = "contact_id")
	@RestResource(path = "contact", rel = "contact")
	private Contact contact;
	@ManyToOne
	@JoinColumn(name = "vehicle_id")
	@RestResource(path = "vehicle", rel = "vehicle")
	private Vehicle vehicle;
	@OneToOne
	@JoinColumn(name = "service_id")
	@RestResource(path = "service", rel = "service")
	private Service service;
	@OneToOne // one set of availabilities per appointment
	@JoinColumn(name = "availability_id")
	@RestResource(path = "availability", rel = "availability")
	private Availability availability;
	private String notes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Availability getAvailability() {
		return availability;
	}

	public void setAvailability(Availability availability) {
		this.availability = availability;
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
		return getId().equals(that.getId()) &&
				getContact().equals(that.getContact()) &&
				getVehicle().equals(that.getVehicle()) &&
				getService().equals(that.getService()) &&
				getAvailability().equals(that.getAvailability()) &&
				Objects.equals(getNotes(), that.getNotes());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getContact(), getVehicle(), getService(), getAvailability(), getNotes());
	}
}
