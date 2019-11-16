package com.bgriffiniv.challenges.nielsensports.appointments.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Service {

	@Id
	@GeneratedValue
	private String id;
    private String type;
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "appointment_service",
            joinColumns = @JoinColumn(name = "appointment_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "service_id", referencedColumnName = "id")
    )
    private List<Appointment> appointmentList;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Service)) return false;
		Service that = (Service) o;
        return getDescription().equals(that.getDescription());
	}

	@Override
	public int hashCode() {
        return Objects.hash(getDescription());
	}

	enum ServiceType {
		TIRE_ROTATION,
		TIRE_REPAIR,
		TIRE_CHANGE,
		ENGINE_DIAGNOSTICS,
		ENGINE_REPAIR,
		BRAKE_CHANGE,
		TUNE_UP,
		TRANSMISSION_FLUID,
		WIPER_BLADES,
		WIPER_FLUID
	}
}
