package com.bgriffiniv.challenges.nielsensports.appointments.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue
	private String id;
	private String year;
	private String make;
	private String model;
	private String mileage;

	public Vehicle() {
	}

	public Vehicle(String id, String year, String make, String model, String mileage) {
		this.id = id;
		this.year = year;
		this.make = make;
		this.model = model;
		this.mileage = mileage;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMileage() {
		return mileage;
	}

	public void setMileage(String mileage) {
		this.mileage = mileage;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Vehicle)) return false;
		Vehicle vehicle = (Vehicle) o;
		return getId().equals(vehicle.getId()) &&
				getYear().equals(vehicle.getYear()) &&
				getMake().equals(vehicle.getMake()) &&
				getModel().equals(vehicle.getModel()) &&
				getMileage().equals(vehicle.getMileage());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getYear(), getMake(), getModel(), getMileage());
	}
}
