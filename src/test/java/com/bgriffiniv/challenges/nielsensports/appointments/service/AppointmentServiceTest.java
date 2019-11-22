package com.bgriffiniv.challenges.nielsensports.appointments.service;

import com.bgriffiniv.challenges.nielsensports.appointments.data.IAppointmentRepository;
import com.bgriffiniv.challenges.nielsensports.appointments.model.Appointment;
import com.bgriffiniv.challenges.nielsensports.appointments.model.Contact;
import com.bgriffiniv.challenges.nielsensports.appointments.model.Service;
import com.bgriffiniv.challenges.nielsensports.appointments.model.Vehicle;
import javassist.NotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class AppointmentServiceTest {

	String basicAvailability1;
	String basicAvailability2;

    private List<Service> basicServiceList;
	String basicNotes;
	@Mock
	private IAppointmentRepository appointmentRepository;
	@InjectMocks
	@Autowired
	private AppointmentService instance;
	private Contact basicContact;
	private Vehicle basicVehicle;
	private int appointmentId;

	@BeforeEach
	void setUp() throws Exception {
        Service service = new Service();
		service.setDescription("Simple tire change (one or more)");
		service.setType("TIRE_CHANGE");

        basicServiceList = new ArrayList<>();
        basicServiceList.add(service);

		basicAvailability1 = "2019/11/19@12:05:50";
		basicAvailability1 = "2019/11/25@14:15:30";
		basicNotes = "Some notes...";

		basicContact = new Contact();
		basicContact.setAddress1("blah");
		basicContact.setCity("city");
		basicContact.setState("ST");
		basicContact.setZip("12345");
		basicContact.setPhone("55555555555");
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
        appointment.setServiceList(basicServiceList);
		appointment.setContact(basicContact);
		appointment.setAvailability1(basicAvailability1);
		appointment.setAvailability2(basicAvailability2);
		appointment.setVehicle(basicVehicle);
		appointment.setNotes(basicNotes);

		instance.addAppointment(appointment);
		appointmentId = appointment.getId();
	}

	@AfterEach
	void tearDown() throws Exception {
		for (Appointment appointment: instance.listAppointments()) {
			instance.removeAppointment(appointment.getId());
		}
	}

	@Test
	void addAppointment_null_sizeShouldBeOne() {
		assertThrows(IllegalArgumentException.class, () -> {
			int id = instance.addAppointment(null);
		});
		assertEquals(1, instance.countAppointments());
	}

	@Test
	void addAppointment_happyPath_sizeShouldBeTwo() throws Exception {
		Service service = new Service();
		service.setType("TIRE_ROTATION");
		service.setDescription("Simple tire rotation (2 or more)");
        List<Service> serviceList = new ArrayList<>();
        serviceList.add(service);

		Appointment expected = new Appointment();
        expected.setServiceList(serviceList);
		expected.setContact(basicContact);
		expected.setAvailability1(basicAvailability1);
		expected.setAvailability2(basicAvailability2);
		expected.setVehicle(basicVehicle);
		expected.setNotes(basicNotes);

		int id = instance.addAppointment(expected);

		Appointment actual = instance.findAppointment(id);
		assertEquals(2, instance.countAppointments());
		assertEquals(expected, actual);
	}

	@Test
	void findAppointment_happyPath_appointmentShouldBeExpected() throws Exception {
		Appointment expected = new Appointment();
        expected.setServiceList(basicServiceList);
		expected.setContact(basicContact);
		expected.setAvailability1(basicAvailability1);
		expected.setAvailability2(basicAvailability2);
		expected.setVehicle(basicVehicle);
		expected.setNotes(basicNotes);

		expected.setId(appointmentId);

		Appointment actual = instance.findAppointment(appointmentId);
		assertEquals(expected, actual);
	}

	@Test
	void findAppointment_notFound_appointmentShouldBeNull() throws Exception {
		Integer expectedAppointmentId = 1;
		assertThrows(NotFoundException.class, () -> {
			Appointment appointment = instance.findAppointment(expectedAppointmentId);
		});
	}

	@Test
	void listAppointments_happyPath_sizeShouldBeOne() throws Exception {
		List<Appointment> appointmentList = instance.listAppointments();

		Appointment expected = new Appointment();
        expected.setServiceList(basicServiceList);
		expected.setContact(basicContact);
		expected.setAvailability1(basicAvailability1);
		expected.setAvailability2(basicAvailability2);
		expected.setVehicle(basicVehicle);
		expected.setNotes(basicNotes);

		expected.setId(appointmentId);

		assertEquals(1, appointmentList.size());
		assertTrue(appointmentList.contains(expected));
	}

	@Test
	void countAppointments_happyPath_countShouldEqualSize() throws Exception {
		List<Appointment> appointmentList = instance.listAppointments();

		assertEquals(appointmentList.size(), instance.countAppointments());
	}

	@Test
	void editAppointment_notFound_doNothing() throws Exception {
		assertThrows(NotFoundException.class, () -> {
			instance.editAppointment(1, null);
		});
		assertThrows(NotFoundException.class, () -> {
			Appointment actual = instance.findAppointment(1);
		});
		assertEquals(1, instance.countAppointments());
	}
	@Test
	void editAppointment_notValid_doNothing() throws Exception {
		assertThrows(IllegalArgumentException.class, () -> {
			instance.editAppointment(appointmentId, null);
		});
		Appointment expected = new Appointment();
        expected.setServiceList(basicServiceList);
		expected.setContact(basicContact);
		expected.setAvailability1(basicAvailability1);
		expected.setAvailability2(basicAvailability2);
		expected.setVehicle(basicVehicle);
		expected.setNotes(basicNotes);

		expected.setId(appointmentId);

		Appointment actual = instance.findAppointment(appointmentId);
		assertEquals(1, instance.countAppointments());
		assertEquals(expected, actual);
	}
	@Test
	void editAppointment_happyPath_appointmentShouldHaveWiperFluidService() throws Exception {
        Service service = new Service();
		service.setType("WIPER_FLUID");
		service.setDescription("Wiper fluid refill");
        List<Service> newServiceList = new ArrayList<>();
        newServiceList.addAll(basicServiceList);
        newServiceList.add(service);

		Appointment expected = new Appointment();
        expected.setServiceList(newServiceList);
		expected.setContact(basicContact);
		expected.setAvailability1(basicAvailability1);
		expected.setAvailability2(basicAvailability2);
		expected.setVehicle(basicVehicle);
		expected.setNotes(basicNotes);

		instance.editAppointment(appointmentId, expected);
		expected.setId(appointmentId);

		Appointment actual = instance.findAppointment(appointmentId);
		expected.getServiceList().get(1).setId(actual.getServiceList().get(1).getId());
		expected.getVehicle().setId(actual.getVehicle().getId());
		expected.getContact().setId(actual.getContact().getId());

		assertEquals(1, instance.countAppointments());
		assertEquals(expected, actual);
	}
	@Test
	void removeAppointment_happyPath_sizeShouldBeZero() throws Exception {
		instance.removeAppointment(instance.listAppointments().get(0).getId());
		assertEquals(0, instance.countAppointments());
	}
	@Test
	void removeAppointment_notFund_sizeShouldBeOne() {
		assertThrows(NotFoundException.class, () -> {
			instance.removeAppointment(1); // no instance with that ID
		});
		assertEquals(1, instance.countAppointments());
	}


}