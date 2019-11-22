package com.bgriffiniv.challenges.nielsensports.appointments.data;

import com.bgriffiniv.challenges.nielsensports.appointments.model.Appointment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(collectionResourceRel = "appointments", path = "appointments")
public interface IAppointmentRepository extends PagingAndSortingRepository<Appointment, Integer> {

	List<Appointment> findAllByAvailability1Between(String availability1Start, String availability1End);

	List<Appointment> findAllByAvailability2Between(String availability2Start, String availability2End);

}
