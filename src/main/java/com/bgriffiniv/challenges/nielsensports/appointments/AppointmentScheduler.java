package com.bgriffiniv.challenges.nielsensports.appointments;

import com.bgriffiniv.challenges.nielsensports.appointments.model.Appointment;
import com.bgriffiniv.challenges.nielsensports.appointments.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppointmentScheduler implements IAppointmentScheduler {

	private final static Map<String, Appointment> appointmentRepo = new HashMap<>();
	@Autowired
	private AppointmentService appointmentService;

	@Override
	public void addAppointment(Appointment appointment) {
		// persist
		if (!isValidAppointment(appointment)) {
			//throw new Exception(String.format("Failed to add invalid Appointment"));
			return;
		}
		String newAppointmentId = "" + appointmentRepo.entrySet().size();
		appointment.setId(newAppointmentId);
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
		return appointmentService.list();
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
		appointment.setId(appointmentId);
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
