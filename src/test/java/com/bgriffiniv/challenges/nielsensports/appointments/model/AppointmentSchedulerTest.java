package com.bgriffiniv.challenges.nielsensports.appointments.model;

import com.bgriffiniv.challenges.nielsensports.appointments.AppointmentScheduler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AppointmentSchedulerTest {

	private AppointmentScheduler instance;

	private Service basicService;
	private Availability basicAvailability;
	private Contact basicContact;
	private Vehicle basicVehicle;

	@BeforeEach
	void setUp() {
		List<String> serviceList = new ArrayList<>();
		serviceList.add("TIRE_CHANGE");

		basicService = new Service();
		basicService.setServiceList(serviceList);

		basicAvailability = new Availability();
		basicAvailability.setAvailability1("foo");
		basicAvailability.setAvailability2("bar");

		basicContact = new Contact();
		basicContact.setAddress1("blah");
		basicContact.setCity("city");
		basicContact.setState("ST");
		basicContact.setZip("12345");
		basicContact.setEmail("email@example.com");
		basicContact.setContactBy("PHONE");
		basicContact.setFirstName("First");
		basicContact.setLastName("Last");

		basicVehicle = new Vehicle();
		basicVehicle.setMake("Make");
		basicVehicle.setMileage("1000");
		basicVehicle.setModel("Model");
		basicVehicle.setYear("2010");

		Appointment appointment = new Appointment();
		appointment.setService(basicService);
		appointment.setContact(basicContact);
		appointment.setAvailability(basicAvailability);
		appointment.setVehicle(basicVehicle);

		instance = new AppointmentScheduler();
		try {
			instance.addAppointment(appointment);
		} catch (Exception e) {
			// do nothing
		}
	}

	@AfterEach
	void tearDown() {
		for (Appointment appointment: instance.listAppointments()) {
			instance.removeAppointment(appointment.getId());
		}
	}

	@Test
	void addAppointment_null_sizeShouldBeOne() {
		instance.addAppointment(null);
		assertEquals(1, instance.countAppointments());
	}

	@Test
	void addAppointment_happyPath_sizeShouldBeTwo() {
		List<String> serviceList = new ArrayList<>();
		serviceList.add("TIRE_ROTATION");
		Service service = new Service();
		service.setServiceList(serviceList);

		Appointment expected = new Appointment();
		expected.setService(service);
		expected.setContact(basicContact);
		expected.setAvailability(basicAvailability);
		expected.setVehicle(basicVehicle);

		instance.addAppointment(expected);
		String expectedAppointmentId = "1";
		expected.setId(expectedAppointmentId);

		Appointment actual = instance.findAppointment(expectedAppointmentId);
		assertEquals(2, instance.countAppointments());
		assertEquals(expected, actual);
	}

	@Test
	void findAppointment_happyPath_appointmentShouldBeExpected() {
		Appointment expected = new Appointment();
		expected.setService(basicService);
		expected.setContact(basicContact);
		expected.setAvailability(basicAvailability);
		expected.setVehicle(basicVehicle);

		String expectedAppointmentId = "0";
		expected.setId(expectedAppointmentId);

		Appointment actual = instance.findAppointment(expectedAppointmentId);
		assertEquals(expected, actual);
	}

	@Test
	void findAppointment_notFound_appointmentShouldBeNull() {
		String expectedAppointmentId = "1";
		Appointment appointment = instance.findAppointment(expectedAppointmentId);

		assertEquals(null, appointment);
	}

	@Test
	void listAppointments_happyPath_sizeShouldBeOne() {
		List<Appointment> appointmentList = instance.listAppointments();

		Appointment expected = new Appointment();
		expected.setService(basicService);
		expected.setContact(basicContact);
		expected.setAvailability(basicAvailability);
		expected.setVehicle(basicVehicle);

		String expectedAppointmentId = "0";
		expected.setId(expectedAppointmentId);

		assertEquals(1, appointmentList.size());
		assertTrue(appointmentList.contains(expected));
	}

	@Test
	void countAppointments_happyPath_countShouldEqualSize() {
		List<Appointment> appointmentList = instance.listAppointments();

		assertEquals(appointmentList.size(), instance.countAppointments());
	}

	@Test
	void editAppointment_notFound_doNothing() {
		instance.editAppointment("1", null);

		Appointment expected = new Appointment();
		expected.setService(basicService);
		expected.setContact(basicContact);
		expected.setAvailability(basicAvailability);
		expected.setVehicle(basicVehicle);

		String expectedAppointmentId = "0";
		expected.setId(expectedAppointmentId);

		Appointment actual = instance.findAppointment(expectedAppointmentId);
		assertEquals(1, instance.countAppointments());
		assertEquals(expected, actual);
	}
	@Test
	void editAppointment_notValid_doNothing() {
		instance.editAppointment("0", null);

		Appointment expected = new Appointment();
		expected.setService(basicService);
		expected.setContact(basicContact);
		expected.setAvailability(basicAvailability);
		expected.setVehicle(basicVehicle);

		String expectedAppointmentId = "0";
		expected.setId(expectedAppointmentId);

		Appointment actual = instance.findAppointment(expectedAppointmentId);
		assertEquals(1, instance.countAppointments());
		assertEquals(expected, actual);
	}
	@Test
	void editAppointment_happyPath_appointmentShouldHaveWiperFluidService() {
		List<String> serviceList = basicService.getServiceList();
		serviceList.add("WIPER_FLUID");

		Service newService = new Service();
		newService.setServiceList(serviceList);

		Appointment expected = new Appointment();
		expected.setService(newService);
		expected.setContact(basicContact);
		expected.setAvailability(basicAvailability);
		expected.setVehicle(basicVehicle);

		String expectedAppointmentId = "0";
		instance.editAppointment(expectedAppointmentId, expected);
		expected.setId(expectedAppointmentId);

		Appointment actual = instance.findAppointment(expectedAppointmentId);
		assertEquals(1, instance.countAppointments());
		assertEquals(expected, actual);
	}
	@Test
	void removeAppointment_happyPath_sizeShouldBeZero() {
		instance.removeAppointment("0");
		assertEquals(0, instance.countAppointments());
	}
	@Test
	void removeAppointment_notFund_sizeShouldBeOne() {
		instance.removeAppointment("1"); // no instance with that ID
		assertEquals(1, instance.countAppointments());
	}
}