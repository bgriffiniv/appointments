package com.bgriffiniv.challenges.nielsensports.appointments.controller;

import com.bgriffiniv.challenges.nielsensports.appointments.model.Appointment;
import com.bgriffiniv.challenges.nielsensports.appointments.service.IAppointmentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping
public class AppointmentControllerV1 {

	@Autowired
	private IAppointmentService appointmentService;

	@RequestMapping(path = "/", method = GET)
	public String welcome() {
        return "Welcome to the Nielsen Sports Car Service Center!";
    }

	@RequestMapping(path = "/appointments", method = GET)
	@ResponseBody
	public List<Appointment> listSppointments() {
		System.out.println("hey");
		return appointmentService.listAppointments();
	}

	@RequestMapping(path = "/appointments/{id}", method = GET)
	@ResponseBody
	public Appointment findAppointment(@PathVariable int id) throws NotFoundException {
		System.out.println("hey");
		return appointmentService.findAppointment(id);
	}

	@RequestMapping(path = "/appointments", method = POST)
	@ResponseBody
	public void addAppointment(@RequestBody String foo) throws IllegalArgumentException {
		System.out.println("hey");
		return;// appointmentService.addAppointment((Appointment) appointment);


	}

	@RequestMapping(path = "/appointments/{id}", method = PUT)
	@ResponseBody
	public int editAppointment(@PathVariable int id, @RequestBody Appointment appointment) throws IllegalArgumentException, NotFoundException {
		System.out.println("hey");
		return appointmentService.editAppointment(id, appointment);

	}

	@RequestMapping(path = "/appointments/{id}", method = DELETE)
	@ResponseBody
	public int deleteAppointment(@PathVariable int id) throws NotFoundException {
		System.out.println("hey");
		return appointmentService.removeAppointment(id);

	}
}

