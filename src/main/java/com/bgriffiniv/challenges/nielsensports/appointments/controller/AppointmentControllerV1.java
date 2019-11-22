package com.bgriffiniv.challenges.nielsensports.appointments.controller;

import com.bgriffiniv.challenges.nielsensports.appointments.model.Appointment;
import com.bgriffiniv.challenges.nielsensports.appointments.service.IAppointmentService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
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
	public List<Appointment> listAppointments() {
		return appointmentService.listAppointments();
	}

	@RequestMapping(path = "/appointments", params = {"start", "end"}, method = GET)
	@ResponseBody
	public List<Appointment> listAppointmentInRangeSortedByPrice(@RequestParam String start, @RequestParam String end) {
		List<Appointment> appointmentList = appointmentService.listAppointments(start, end);
		appointmentList.sort(new Comparator<Appointment>() {
			@Override
			public int compare(Appointment o1, Appointment o2) {
				return Float.compare(o1.getPrice(), o2.getPrice());
			}
		});

		return appointmentList;

	}

	@RequestMapping(path = "/appointments/{id}", method = GET)
	@ResponseBody
	public Appointment findAppointment(@PathVariable int id) throws NotFoundException {
		return appointmentService.findAppointment(id);
	}

	@RequestMapping(path = "/appointments", method = POST)
	@ResponseBody
	public int addAppointment(@RequestBody Appointment appointment) throws IllegalArgumentException {
		return appointmentService.addAppointment(appointment);


	}

	@RequestMapping(path = "/appointments/{id}", method = PUT)
	@ResponseBody
	public int editAppointment(@PathVariable int id, @RequestBody Appointment appointment) throws IllegalArgumentException, NotFoundException {
		return appointmentService.editAppointment(id, appointment);

	}

	@RequestMapping(path = "/appointments/{id}", method = DELETE)
	@ResponseBody
	public int deleteAppointment(@PathVariable int id) throws NotFoundException {
		return appointmentService.removeAppointment(id);

	}
}

