package com.bgriffiniv.challenges.nielsensports.appointments.model;

import com.sun.javafx.binding.StringFormatter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppointmentScheduler implements IAppointmentScheduler {

	private Map<Integer, Appointment> appointmentRepo = new HashMap<>();

	@Override
	public void addAppointment(Appointment appointment) {
		// persist
		appointmentRepo.put(appointment.getAppointmentId(), appointment);
	}

	@Override
	public Appointment findAppointment(int appointmentId) {
		// get from db
		if (!appointmentRepo.containsKey(appointmentId)) {
			return null;
		}

		return appointmentRepo.get(appointmentId);
	}

	@Override
	public List<Appointment> listAppointments() {
		// get from db
		return null;
	}

	@Override
	public void editAppointment(int appointmentId, Appointment appointment) throws Exception {
		if (findAppointment(appointmentId) == null) {
			throw new Exception(StringFormatter.format("Appointment ID not found %d", appointmentId).getValue());
		}
		// persist
		appointmentRepo.put(appointmentId, appointment);
	}

	@Override
	public void removeAppointment(int appointmentId) {
		// persist
	}


	public static void main(String[] args) {
		AppointmentScheduler appointmentScheduler = new AppointmentScheduler();
		List<Appointment> appointmentList = appointmentScheduler.listAppointments();

		System.out.println(appointmentList.size());

	}
}
