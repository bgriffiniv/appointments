package com.bgriffiniv.challenges.appointments.data;

import com.bgriffiniv.challenges.appointments.model.Service;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends PagingAndSortingRepository<Service, Integer> {
}
