package com.bgriffiniv.challenges.nielsensports.appointments.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {

    @RequestMapping("/")
    public String index() {
        return "Welcome to the Nielsen Sports Car Service Center!";
    }

}

