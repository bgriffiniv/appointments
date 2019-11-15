package com.bgriffiniv.challenges.nielsensports.appointments;

import com.bgriffiniv.challenges.nielsensports.appointments.model.Appointment;

import java.util.List;

public interface IAppointmentScheduler {

	public void addAppointment(Appointment appointment);
	public Appointment findAppointment(String appointmentId);
	public List<Appointment> listAppointments();
	public int countAppointments();
	public void editAppointment(String appointmentId, Appointment appointment);
	public void removeAppointment(String appointmentId);
}
