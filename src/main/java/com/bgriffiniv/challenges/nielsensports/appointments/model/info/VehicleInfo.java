package com.bgriffiniv.challenges.nielsensports.appointments.model.info;

import java.util.Objects;

public class VehicleInfo {

	private String year;
	private String make;
	private String model;
	private String mileage;

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
		if (!(o instanceof VehicleInfo)) return false;
		VehicleInfo that = (VehicleInfo) o;
		return getYear().equals(that.getYear()) &&
				getMake().equals(that.getMake()) &&
				getModel().equals(that.getModel()) &&
				getMileage().equals(that.getMileage());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getYear(), getMake(), getModel(), getMileage());
	}
}
