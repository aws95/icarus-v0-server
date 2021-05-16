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
public class Country {

	@Id
	@NotBlank(message = "Country ID is mandatory")
	@Column(name = "countryId")
	private long countryId;

	@NotBlank(message = "Country ISO is mandatory")
	@Column(name = "iso")
	private String iso;

	@NotBlank(message = "Country Name is mandatory")
	@Column(name = "name")
	private String name;

	@NotBlank(message = "Country's Nice Name is mandatory")
	@Column(name = "nicename")
	private String nicename;

	@NotBlank(message = "Country iso3 is mandatory")
	@Column(name = "iso3")
	private String iso3;

	@NotBlank(message = "Country Num Code is mandatory")
	@Column(name = "numcode")
	private long numcode;

	@NotBlank(message = "Country Phone Code is mandatory")
	@Column(name = "phonecode")
	private long phonecode;

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", iso=" + iso + ", name=" + name + ", nicename=" + nicename
				+ ", iso3=" + iso3 + ", numcode=" + numcode + ", phonecode=" + phonecode + "]";
	}

	public Country() {
	}

	public Country(@NotBlank(message = "Country ID is mandatory") long countryId,
			@NotBlank(message = "Country ISO is mandatory") String iso,
			@NotBlank(message = "Country Name is mandatory") String name,
			@NotBlank(message = "Country's Nice Name is mandatory") String nicename,
			@NotBlank(message = "Country iso3 is mandatory") String iso3,
			@NotBlank(message = "Country Num Code is mandatory") long numcode,
			@NotBlank(message = "Country Phone Code is mandatory") long phonecode) {
		this.countryId = countryId;
		this.iso = iso;
		this.name = name;
		this.nicename = nicename;
		this.iso3 = iso3;
		this.numcode = numcode;
		this.phonecode = phonecode;
	}

	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNicename() {
		return nicename;
	}

	public void setNicename(String nicename) {
		this.nicename = nicename;
	}

	public String getIso3() {
		return iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	public long getNumcode() {
		return numcode;
	}

	public void setNumcode(long numcode) {
		this.numcode = numcode;
	}

	public long getPhonecode() {
		return phonecode;
	}

	public void setPhonecode(long phonecode) {
		this.phonecode = phonecode;
	}
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "country")
	private List<DataPoint> dataPoint;

	public List<DataPoint> getDataPoint() {
		return dataPoint;
	}

	public void setDataPoint(List<DataPoint> dataPoint) {
		this.dataPoint = dataPoint;
	}

}
