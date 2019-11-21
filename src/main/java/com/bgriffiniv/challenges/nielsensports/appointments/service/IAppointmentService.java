package com.bgriffiniv.challenges.nielsensports.appointments.service;

import com.bgriffiniv.challenges.nielsensports.appointments.model.Appointment;
import javassist.NotFoundException;

import java.util.List;

public interface IAppointmentService {

	public int addAppointment(Appointment appointment) throws IllegalArgumentException;

	public Appointment findAppointment(Integer appointmentId) throws NotFoundException;
	public List<Appointment> listAppointments();

	public long countAppointments();

	public int editAppointment(Integer appointmentId, Appointment appointment) throws NotFoundException, IllegalArgumentException;

	public int removeAppointment(Integer appointmentId) throws NotFoundException;
}
