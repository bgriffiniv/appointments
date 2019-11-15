package com.bgriffiniv.challenges.nielsensports.appointments.model;

import java.util.*;

public class AppointmentScheduler implements IAppointmentScheduler {

	private final static Map<String, Appointment> appointmentRepo = new HashMap<>();

	@Override
	public void addAppointment(Appointment appointment) {
		// persist
		if (!isValidAppointment(appointment)) {
			//throw new Exception(String.format("Failed to add invalid Appointment"));
			return;
		}
		String newAppointmentId = "" + appointmentRepo.entrySet().size();
		appointment.setAppointmentId(newAppointmentId);
		appointmentRepo.put(newAppointmentId, appointment);
	}

	private boolean isValidAppointment(Appointment appointment) {
		if (appointment == null) {
			return false;
		}
		return true;
	}

	@Override
	public Appointment findAppointment(String appointmentId) {
		// get from db
		if (!appointmentRepo.containsKey(appointmentId)) {
			return null;
		}

		return appointmentRepo.get(appointmentId);
	}

	@Override
	public List<Appointment> listAppointments() {
		// get from db
		return new ArrayList<>(appointmentRepo.values());
	}

	@Override
	public int countAppointments() {
		// get from db
		return listAppointments().size();
	}

	@Override
	public void editAppointment(String appointmentId, Appointment appointment) {
		if (findAppointment(appointmentId) == null) {
			// throw new Exception(String.format("Appointment ID not found: %s", appointmentId));
			return;
		}
		if (!isValidAppointment(appointment)) {
			//throw new Exception(String.format("Failed to add invalid Appointment"));
			return;
		}
		// persist
		appointment.setAppointmentId(appointmentId);
		appointmentRepo.put(appointmentId, appointment);
	}

	@Override
	public void removeAppointment(String appointmentId) {
		// persist
		if (findAppointment(appointmentId) == null) {
			return;
		}

		appointmentRepo.remove(appointmentId);
	}

	public static void main(String[] args) {
		AppointmentScheduler appointmentScheduler = new AppointmentScheduler();
		List<Appointment> appointmentList = appointmentScheduler.listAppointments();

		System.out.println(appointmentList.size());
	}
}
