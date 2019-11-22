package com.bgriffiniv.challenges.appointments.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Appointment {

	@Id
	@GeneratedValue
	private Integer id;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "contact_id")
	private Contact contact;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name = "appointment_service",
			joinColumns = @JoinColumn(name = "appointment_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "service_id", referencedColumnName = "id")
	)
	private List<Service> serviceList = new ArrayList<>();

	private String availability1;
	private String availability2;

	private String notes;
	private float price;

	public Appointment() {
	}

	public Appointment(Integer id, Contact contact, Vehicle vehicle, List<Service> serviceList, String availability1, String availability2, String notes, float price) {
		this.id = id;
		this.contact = contact;
		this.vehicle = vehicle;
		this.serviceList = serviceList;
		this.availability1 = availability1;
		this.availability2 = availability2;
		this.notes = notes;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

    public List<Service> getServiceList() {
		return new ArrayList<>(serviceList);
    }

    public void setServiceList(List<Service> serviceList) {
		this.serviceList.addAll(serviceList);
	}

	public String getAvailability1() {
		return availability1;
	}

	public void setAvailability1(String availability1) {
		this.availability1 = availability1;
	}

	public String getAvailability2() {
		return availability2;
	}

	public void setAvailability2(String availability2) {
		this.availability2 = availability2;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Appointment)) return false;
		Appointment that = (Appointment) o;
		return Float.compare(that.getPrice(), getPrice()) == 0 &&
				getId().equals(that.getId()) &&
				getContact().equals(that.getContact()) &&
				getVehicle().equals(that.getVehicle()) &&
				getServiceList().equals(that.getServiceList()) &&
				getAvailability1().equals(that.getAvailability1()) &&
				Objects.equals(getAvailability2(), that.getAvailability2()) &&
				Objects.equals(getNotes(), that.getNotes());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getContact(), getVehicle(), getServiceList(), getAvailability1(), getAvailability2(), getNotes(), getPrice());
	}
}
