package com.bgriffiniv.challenges.nielsensports.appointments.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Contact {

	@Id
	@GeneratedValue
	private Integer id;
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

	public Contact() {
	}

	public Contact(Integer id, String firstName, String lastName, String phone, String email, String address1, String address2, String city, String state, String zip, String contactBy) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.contactBy = contactBy;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
		if (!(o instanceof Contact)) return false;
		Contact contact = (Contact) o;
		return Objects.equals(getId(), contact.getId()) &&
				getFirstName().equals(contact.getFirstName()) &&
				getLastName().equals(contact.getLastName()) &&
				getPhone().equals(contact.getPhone()) &&
				getEmail().equals(contact.getEmail()) &&
				getAddress1().equals(contact.getAddress1()) &&
				Objects.equals(getAddress2(), contact.getAddress2()) &&
				getCity().equals(contact.getCity()) &&
				getState().equals(contact.getState()) &&
				getZip().equals(contact.getZip()) &&
				getContactBy().equals(contact.getContactBy());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getFirstName(), getLastName(), getPhone(), getEmail(), getAddress1(), getAddress2(), getCity(), getState(), getZip(), getContactBy());
	}

	enum ContactBy {
		PHONE,
		EMAIL,
		POST
	}
}
