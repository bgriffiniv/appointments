package com.bgriffiniv.challenges.nielsensports.appointments.model.info;

import java.util.Objects;

public class ContactInfo {

	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private String contactBy;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getContactBy() {
		return contactBy;
	}

	public void setContactBy(String contactBy) {
		this.contactBy = contactBy;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ContactInfo)) return false;
		ContactInfo that = (ContactInfo) o;
		return getFirstName().equals(that.getFirstName()) &&
				getLastName().equals(that.getLastName()) &&
				getPhone().equals(that.getPhone()) &&
				getEmail().equals(that.getEmail()) &&
				getAddress1().equals(that.getAddress1()) &&
				Objects.equals(getAddress2(), that.getAddress2()) &&
				getCity().equals(that.getCity()) &&
				getState().equals(that.getState()) &&
				getZip().equals(that.getZip()) &&
				getContactBy().equals(that.getContactBy());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getFirstName(), getLastName(), getPhone(), getEmail(), getAddress1(), getAddress2(), getCity(), getState(), getZip(), getContactBy());
	}

	enum ContactBy {
		PHONE,
		EMAIL,
		POST
	}
}
