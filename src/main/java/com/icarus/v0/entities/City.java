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
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","dataPoint"})
public class City {
	@Id
	@NotBlank(message = "City ID is mandatory")
	@Column(name = "cityId")
	private long cityId;

	@NotBlank(message = "City Name is mandatory")
	@Column(name = "cityName")
	private String cityName;

	@NotBlank(message = "City latitude Name is mandatory")
	@Column(name = "lat")
	private String lat;

	@NotBlank(message = "City longitude Name is mandatory")
	@Column(name = "lon")
	private String lon;

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
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

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + ", lat=" + lat + ", lon=" + lon + "]";
	}

	public City() {

	}

	public City(@NotBlank(message = "City ID is mandatory") long cityId,
			@NotBlank(message = "City Name is mandatory") String cityName,
			@NotBlank(message = "City latitude Name is mandatory") String lat,
			@NotBlank(message = "City longitude Name is mandatory") String lon) {
		this.cityId = cityId;
		this.cityName = cityName;
		this.lat = lat;
		this.lon = lon;
	}
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "city")
	private List<DataPoint> dataPoint;

	public List<DataPoint> getDataPoint() {
		return dataPoint;
	}

	public void setDataPoint(List<DataPoint> dataPoint) {
		this.dataPoint = dataPoint;
	}


}
