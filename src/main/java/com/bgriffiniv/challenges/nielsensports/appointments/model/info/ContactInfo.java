package com.bgriffiniv.challenges.nielsensports.appointments.model.info;

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
	private ContactBy contactBy;

	enum ContactBy {
		PHONE,
		EMAIL,
		POST
	}

}
