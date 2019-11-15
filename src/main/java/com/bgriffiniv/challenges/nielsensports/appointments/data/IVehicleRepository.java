package com.bgriffiniv.challenges.nielsensports.appointments.data;

import com.bgriffiniv.challenges.nielsensports.appointments.model.Vehicle;
import org.springframework.data.repository.CrudRepository;

public interface IVehicleRepository extends CrudRepository<Vehicle, String> {

}
