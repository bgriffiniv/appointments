package com.bgriffiniv.challenges.nielsensports.appointments.service;

import com.bgriffiniv.challenges.nielsensports.appointments.data.IAppointmentRepository;
import com.bgriffiniv.challenges.nielsensports.appointments.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private IAppointmentRepository appointmentRepository;

    public List list() {
        List<Appointment> appointmentList = new ArrayList<Appointment>();
        appointmentRepository.findAll().forEach((appointment) -> appointmentList.add(appointment));
        return appointmentList;
    }

}
