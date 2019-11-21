package com.bgriffiniv.challenges.nielsensports.appointments.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Service {

	@Id
	@GeneratedValue
	private Integer id;
    private String type;
    private String description;

	public Service() {
	}

	public Service(Integer id, String type, String description) {
		this.id = id;
		this.type = type;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

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
		Service service = (Service) o;
		return Objects.equals(getId(), service.getId()) &&
				getType().equals(service.getType()) &&
				Objects.equals(getDescription(), service.getDescription());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getType(), getDescription());
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
