package com.bgriffiniv.challenges.nielsensports.appointments.data;

import com.bgriffiniv.challenges.nielsensports.appointments.model.Service;
import org.springframework.data.repository.CrudRepository;

public interface IServiceRepository extends CrudRepository<Service, String> {
}
