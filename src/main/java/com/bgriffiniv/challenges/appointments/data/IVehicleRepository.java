package com.bgriffiniv.challenges.appointments.data;

import com.bgriffiniv.challenges.appointments.model.Vehicle;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehicleRepository extends PagingAndSortingRepository<Vehicle, Integer> {

}
