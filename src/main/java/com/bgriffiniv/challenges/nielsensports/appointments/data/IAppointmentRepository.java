package com.bgriffiniv.challenges.nielsensports.appointments.data;

import com.bgriffiniv.challenges.nielsensports.appointments.model.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface IAppointmentRepository extends CrudRepository<Appointment, String> {

}
