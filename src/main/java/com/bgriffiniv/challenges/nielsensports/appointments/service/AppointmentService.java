package com.bgriffiniv.challenges.nielsensports.appointments.service;

import com.bgriffiniv.challenges.nielsensports.appointments.data.IAppointmentRepository;
import com.bgriffiniv.challenges.nielsensports.appointments.data.IContactRepository;
import com.bgriffiniv.challenges.nielsensports.appointments.data.IServiceRepository;
import com.bgriffiniv.challenges.nielsensports.appointments.data.IVehicleRepository;
import com.bgriffiniv.challenges.nielsensports.appointments.model.Appointment;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AppointmentService implements IAppointmentService {

	@Autowired
	private IAppointmentRepository appointmentRepository;
	@Autowired
	private IContactRepository contactRepository;
	@Autowired
	private IServiceRepository serviceRepository;
	@Autowired
	private IVehicleRepository vehicleRepository;

	@Override
	public int addAppointment(Appointment appointment) throws IllegalArgumentException {
		// persist
		if (!isValidAppointment(appointment)) {
			throw new IllegalArgumentException(String.format("Failed to add invalid Appointment"));
		}
		contactRepository.save(appointment.getContact());
		serviceRepository.saveAll(appointment.getServiceList());
		vehicleRepository.save(appointment.getVehicle());
		appointmentRepository.save(appointment);

		return appointment.getId();
	}

	private boolean isValidAppointment(Appointment appointment) {
		if (appointment == null) {
			return false;
		}
		return true;
	}

	@Override
	public Appointment findAppointment(Integer appointmentId) throws NotFoundException {
		// get from db
		if (!appointmentRepository.existsById(appointmentId)) {
			throw new NotFoundException(String.format("Failed to find Appointment with ID : %s", appointmentId));
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
	public int editAppointment(Integer appointmentId, Appointment appointment) throws NotFoundException, IllegalArgumentException {
		if (!appointmentRepository.existsById(appointmentId)) {
			throw new NotFoundException(String.format("Failed to edit Appointment with ID : %s", appointmentId));
		}
		if (!isValidAppointment(appointment)) {
			throw new IllegalArgumentException(String.format("Failed to edit Appointment with ID : %s", appointmentId));
		}
		// persist
		Appointment old = appointmentRepository.findById(appointmentId).get();
		appointment.setId(old.getId());
		appointmentRepository.save(appointment);
		return old.getId();
	}

	@Override
	public int removeAppointment(Integer appointmentId) throws NotFoundException {
		// persist
		if (!appointmentRepository.existsById(appointmentId)) {
			throw new NotFoundException(String.format("Failed to remove Appointment with ID : %s", appointmentId));
		}

		appointmentRepository.deleteById(appointmentId);
		return appointmentId;
	}
}
