package com.bgriffiniv.challenges.nielsensports.appointments.controller;

import com.bgriffiniv.challenges.nielsensports.appointments.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AppointmentControllerV1 {

	@Autowired
	private IAppointmentService appointmentService;

    @RequestMapping("/")
    public String index() {
        return "Welcome to the Nielsen Sports Car Service Center!";
    }

}

