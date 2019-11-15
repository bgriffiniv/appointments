package com.bgriffiniv.challenges.nielsensports.appointments.data;

import com.bgriffiniv.challenges.nielsensports.appointments.model.Contact;
import org.springframework.data.repository.CrudRepository;

public interface IContactRepository extends CrudRepository<Contact, String> {
}
