package com.bgriffiniv.challenges.appointments.service;

import com.bgriffiniv.challenges.appointments.data.IAppointmentRepository;
import com.bgriffiniv.challenges.appointments.data.IContactRepository;
import com.bgriffiniv.challenges.appointments.data.IServiceRepository;
import com.bgriffiniv.challenges.appointments.data.IVehicleRepository;
import com.bgriffiniv.challenges.appointments.model.Appointment;
import javassist.NotFoundException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
	public List<Appointment> listAppointments(String start, String end) throws IllegalStateException, IllegalArgumentException {
		Date startDate = new Date();
		startDate.setTime(Long.parseLong(start));
		Date endDate = new Date();
		endDate.setTime(Long.parseLong(end));
		if (Strings.isBlank(start) || Strings.isBlank(end)) {
			throw new IllegalArgumentException(String.format("Range start date and end date are required"));
		}
		if (startDate.after(endDate)) {
			throw new IllegalStateException(String.format("Range start date must be before end date"));
		}
		List<Appointment> appointmentList = new ArrayList<>();
		appointmentRepository.findAllByAvailability1Between(start, end).forEach(appointmentList::add);
		appointmentRepository.findAllByAvailability2Between(start, end).forEach((appointment) -> {
			if (!appointmentList.contains(appointment)) {
				appointmentList.add(appointment);
			}
		});
		return appointmentList;
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
