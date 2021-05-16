package com.icarus.v0.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "dataPoint" })
public class State {
	@Id
	@NotBlank(message = "State ID is mandatory")
	@Column(name = "stateId")
	private long stateId;
	
	@NotBlank(message = "State Name is mandatory")
	@Column(name = "stateName")
	private String stateName;

	@NotBlank(message = "City latitude Name is mandatory")
	@Column(name = "lat")
	private String lat;

	@NotBlank(message = "City longitude Name is mandatory")
	@Column(name = "lon")
	private String lon;

	public State() {
	}

	public State(@NotBlank(message = "State ID is mandatory") long stateId,
			@NotBlank(message = "State Name is mandatory") String stateName,
			@NotBlank(message = "City latitude Name is mandatory") String lat,
			@NotBlank(message = "City longitude Name is mandatory") String lon) {
		this.stateId = stateId;
		this.stateName = stateName;
		this.lat = lat;
		this.lon = lon;
	}

	@Override
	public String toString() {
		return "State [stateId=" + stateId + ", stateName=" + stateName + ", lat=" + lat + ", lon=" + lon + "]";
	}

	public long getStateId() {
		return stateId;
	}

	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "state")
	private List<DataPoint> dataPoint;

	public List<DataPoint> getDataPoint() {
		return dataPoint;
	}

	public void setDataPoint(List<DataPoint> dataPoint) {
		this.dataPoint = dataPoint;
	}

}
