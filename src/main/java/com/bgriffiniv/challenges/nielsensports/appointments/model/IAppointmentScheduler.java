package com.bgriffiniv.challenges.nielsensports.appointments.model;

import java.util.List;

public interface IAppointmentScheduler {

	public void addAppointment(Appointment appointment);
	public Appointment findAppointment(int appointmentId);
	public List<Appointment> listAppointments();
	public void editAppointment(int appointmentId, Appointment appointment) throws Exception;
	public void removeAppointment(int appointmentId);
}
