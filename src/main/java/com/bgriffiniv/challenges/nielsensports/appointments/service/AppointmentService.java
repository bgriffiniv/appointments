package com.bgriffiniv.challenges.nielsensports.appointments.service;

import com.bgriffiniv.challenges.nielsensports.appointments.data.IAppointmentRepository;
import com.bgriffiniv.challenges.nielsensports.appointments.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AppointmentService implements IAppointmentService {

	@Autowired
	private IAppointmentRepository appointmentRepository;

	@Override
	public void addAppointment(Appointment appointment) {
		// persist
		if (!isValidAppointment(appointment)) {
			//throw new Exception(String.format("Failed to add invalid Appointment"));
			return;
		}
		appointmentRepository.save(appointment);
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
		if (!appointmentRepository.existsById(appointmentId)) {
			return null;
		}

		return appointmentRepository.findById(appointmentId).get();
	}

	@Override
	public List<Appointment> listAppointments() {
		// get from db
		return StreamSupport
				.stream(appointmentRepository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}

	@Override
	public long countAppointments() {
		// get from db
		return appointmentRepository.count();
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
		appointmentRepository.save(appointment);
	}

	@Override
	public void removeAppointment(String appointmentId) {
		// persist
		if (findAppointment(appointmentId) == null) {
			return;
		}

		appointmentRepository.deleteById(appointmentId);
	}
}
