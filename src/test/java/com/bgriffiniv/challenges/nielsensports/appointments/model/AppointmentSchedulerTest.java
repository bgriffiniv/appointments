package com.bgriffiniv.challenges.nielsensports.appointments.model;

import com.bgriffiniv.challenges.nielsensports.appointments.model.info.AvailabilityInfo;
import com.bgriffiniv.challenges.nielsensports.appointments.model.info.ContactInfo;
import com.bgriffiniv.challenges.nielsensports.appointments.model.info.ServiceInfo;
import com.bgriffiniv.challenges.nielsensports.appointments.model.info.VehicleInfo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.annotation.security.RunAs;
import javax.xml.validation.ValidatorHandler;
import java.lang.invoke.SerializedLambda;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentSchedulerTest {

	private AppointmentScheduler instance;

	private ServiceInfo basicServiceInfo;
	private AvailabilityInfo basicAvailabilityInfo;
	private ContactInfo basicContactInfo;
	private VehicleInfo basicVehicleInfo;

	@BeforeEach
	void setUp() {
		List<String> serviceList = new ArrayList<>();
		serviceList.add("TIRE_CHANGE");

		basicServiceInfo = new ServiceInfo();
		basicServiceInfo.setServiceList(serviceList);

		basicAvailabilityInfo = new AvailabilityInfo();
		basicAvailabilityInfo.setAvailability1("foo");
		basicAvailabilityInfo.setAvailability2("bar");

		basicContactInfo = new ContactInfo();
		basicContactInfo.setAddress1("blah");
		basicContactInfo.setCity("city");
		basicContactInfo.setState("ST");
		basicContactInfo.setZip("12345");
		basicContactInfo.setEmail("email@example.com");
		basicContactInfo.setContactBy("PHONE");
		basicContactInfo.setFirstName("First");
		basicContactInfo.setLastName("Last");

		basicVehicleInfo = new VehicleInfo();
		basicVehicleInfo.setMake("Make");
		basicVehicleInfo.setMileage("1000");
		basicVehicleInfo.setModel("Model");
		basicVehicleInfo.setYear("2010");

		Appointment appointment = new Appointment();
		appointment.setServiceInfo(basicServiceInfo);
		appointment.setContactInfo(basicContactInfo);
		appointment.setAvailabilityInfo(basicAvailabilityInfo);
		appointment.setVehicleInfo(basicVehicleInfo);

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
			instance.removeAppointment(appointment.getAppointmentId());
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
		ServiceInfo serviceInfo = new ServiceInfo();
		serviceInfo.setServiceList(serviceList);

		Appointment expected = new Appointment();
		expected.setServiceInfo(serviceInfo);
		expected.setContactInfo(basicContactInfo);
		expected.setAvailabilityInfo(basicAvailabilityInfo);
		expected.setVehicleInfo(basicVehicleInfo);

		instance.addAppointment(expected);
		String expectedAppointmentId = "1";
		expected.setAppointmentId(expectedAppointmentId);

		Appointment actual = instance.findAppointment(expectedAppointmentId);

		assertEquals(2, instance.countAppointments());
		assertEquals(expected, actual);
	}

	@Test
	void findAppointment_happyPath_appointmentShouldHaveTireChangeService() {
		List<String> serviceList = new ArrayList<>();
		serviceList.add("TIRE_CHANGE");
		ServiceInfo serviceInfo = new ServiceInfo();
		serviceInfo.setServiceList(serviceList);

		Appointment expected = new Appointment();
		expected.setServiceInfo(serviceInfo);
		expected.setContactInfo(basicContactInfo);
		expected.setAvailabilityInfo(basicAvailabilityInfo);
		expected.setVehicleInfo(basicVehicleInfo);

		String expectedAppointmentId = "0";
		expected.setAppointmentId(expectedAppointmentId);

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

		assertEquals(1, appointmentList.size());
	}

	@Test
	void editAppointment_notFound_doNothing() {
		instance.editAppointment("1", null);

		Appointment expected = new Appointment();
		expected.setServiceInfo(basicServiceInfo);
		expected.setContactInfo(basicContactInfo);
		expected.setAvailabilityInfo(basicAvailabilityInfo);
		expected.setVehicleInfo(basicVehicleInfo);

		String expectedAppointmentId = "0";
		expected.setAppointmentId(expectedAppointmentId);

		Appointment actual = instance.findAppointment(expectedAppointmentId);

		assertEquals(1, instance.countAppointments());
		assertEquals(expected, actual);
	}
	@Test
	void editAppointment_notValid_doNothing() {
		instance.editAppointment("0", null);

		Appointment expected = new Appointment();
		expected.setServiceInfo(basicServiceInfo);
		expected.setContactInfo(basicContactInfo);
		expected.setAvailabilityInfo(basicAvailabilityInfo);
		expected.setVehicleInfo(basicVehicleInfo);

		String expectedAppointmentId = "0";
		expected.setAppointmentId(expectedAppointmentId);

		Appointment actual = instance.findAppointment(expectedAppointmentId);
		assertEquals(1, instance.countAppointments());
		assertEquals(expected, actual);
	}
	@Test
	void editAppointment_happyPath_appointmentShouldHaveWiperFluidService() {
		List<String> serviceList = basicServiceInfo.getServiceList();
		serviceList.add("WIPER_FLUID");

		ServiceInfo newServiceInfo = new ServiceInfo();
		newServiceInfo.setServiceList(serviceList);

		Appointment expected = new Appointment();
		expected.setServiceInfo(newServiceInfo);
		expected.setContactInfo(basicContactInfo);
		expected.setAvailabilityInfo(basicAvailabilityInfo);
		expected.setVehicleInfo(basicVehicleInfo);

		String expectedAppointmentId = "0";
		instance.editAppointment(expectedAppointmentId, expected);
		expected.setAppointmentId(expectedAppointmentId);

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