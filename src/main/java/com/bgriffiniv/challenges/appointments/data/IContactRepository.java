package com.bgriffiniv.challenges.appointments.data;

import com.bgriffiniv.challenges.appointments.model.Contact;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactRepository extends PagingAndSortingRepository<Contact, Integer> {
}
