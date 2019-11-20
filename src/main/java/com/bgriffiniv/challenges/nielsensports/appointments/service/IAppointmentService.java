package com.bgriffiniv.challenges.nielsensports.appointments.service;

import com.bgriffiniv.challenges.nielsensports.appointments.model.Appointment;

import java.util.List;

public interface IAppointmentService {

	public void addAppointment(Appointment appointment);

	public Appointment findAppointment(Integer appointmentId);
	public List<Appointment> listAppointments();

	public long countAppointments();

	public void editAppointment(Integer appointmentId, Appointment appointment);

	public void removeAppointment(Integer appointmentId);
}
