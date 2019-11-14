package com.bgriffiniv.challenges.nielsensports.appointments.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.annotation.security.RunAs;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentSchedulerTest {

	private AppointmentScheduler instance;

	@BeforeEach
	void setUp() {
		List<Service> serviceList = new ArrayList<>();
		serviceList.add(new Service(Service.ServiceType.CHANGE_BRAKES));
		Appointment appointment = new Appointment(1, serviceList);

		instance = new AppointmentScheduler();
		instance.addAppointment(appointment);
	}

	@Test
	void addAppointment() {
	}

	@Test
	void findAppointment() {
	}

	@Test
	void listAppointments() {
	}

	@Test
	void editAppointment_notFound_throwsException() {
		assertThrows(Exception.class, () -> {
			instance.editAppointment(2, null);
		});
	}

	@Test
	void removeAppointment() {
	}
}