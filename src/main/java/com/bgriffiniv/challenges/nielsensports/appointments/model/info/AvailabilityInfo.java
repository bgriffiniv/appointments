package com.bgriffiniv.challenges.nielsensports.appointments.model.info;

import java.util.Objects;

public class AvailabilityInfo {
	private String availability1;
	private String availability2;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof AvailabilityInfo)) return false;
		AvailabilityInfo that = (AvailabilityInfo) o;
		return getAvailability1().equals(that.getAvailability1()) &&
				getAvailability2().equals(that.getAvailability2());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getAvailability1(), getAvailability2());
	}
}
