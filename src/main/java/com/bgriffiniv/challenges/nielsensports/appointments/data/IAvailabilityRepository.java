package com.bgriffiniv.challenges.nielsensports.appointments.data;

import com.bgriffiniv.challenges.nielsensports.appointments.model.Availability;
import org.springframework.data.repository.CrudRepository;

public interface IAvailabilityRepository extends CrudRepository<Availability, String> {

}
