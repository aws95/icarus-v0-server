package com.icarus.v0.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "dataPoint")
public class DataPoint {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "countryId", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@NotBlank(message = "Country is mandatory")
	private Country country;

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "stateId", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@NotBlank(message = "State is mandatory")
	private State state;

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "cityId", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@NotBlank(message = "City is mandatory")
	private City city;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@NotBlank(message = "Your bill amount is mandatory")
	@Column(name = "billAmount")
	private Double billAmount;

	@NotBlank(message = "Your billing period is mandatory")
	@Column(name = "period")
	private String period;
	
	@NotBlank(message = "Roof Top area is mandatory")
	@Column(name = "area")
	private Double area;

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	@Column(name = "energy")
	private Double energy;
	
	public Double getEnergy() {
		return energy;
	}

	public void setEnergy(Double energy) {
		this.energy = energy;
	}

	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;

	@Column(name = "ghi")
	private String ghi;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "dhi")
	private String dhi;
	
	@Column(name = "ghi_cs")
	private String ghi_cs;
	
	@Column(name = "dni_cs")
	private String dni_cs;
	
	@Column(name = "dhi_cs")
	private String dhi_cs;
	
	@Column(name = "dt")
	private String dt;

	public DataPoint() {
	}

	public DataPoint(long id, @NotBlank(message = "Country is mandatory") Country country,
			@NotBlank(message = "State is mandatory") State state, @NotBlank(message = "City is mandatory") City city,
			@NotBlank(message = "Your bill amount is mandatory") Double billAmount,
			@NotBlank(message = "Your billing period is mandatory") String period,
			@NotBlank(message = "Roof Top area is mandatory") Double area, Double energy, String phone, String email,
			String ghi, String dni, String dhi, String ghi_cs, String dni_cs, String dhi_cs, String dt) {
		this.id = id;
		this.country = country;
		this.state = state;
		this.city = city;
		this.billAmount = billAmount;
		this.period = period;
		this.area = area;
		this.energy = energy;
		this.phone = phone;
		this.email = email;
		this.ghi = ghi;
		this.dni = dni;
		this.dhi = dhi;
		this.ghi_cs = ghi_cs;
		this.dni_cs = dni_cs;
		this.dhi_cs = dhi_cs;
		this.dt = dt;
	}

	public String getGhi() {
		return ghi;
	}

	public void setGhi(String ghi) {
		this.ghi = ghi;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDhi() {
		return dhi;
	}

	public void setDhi(String dhi) {
		this.dhi = dhi;
	}

	public String getGhi_cs() {
		return ghi_cs;
	}

	public void setGhi_cs(String ghi_cs) {
		this.ghi_cs = ghi_cs;
	}

	public String getDni_cs() {
		return dni_cs;
	}

	public void setDni_cs(String dni_cs) {
		this.dni_cs = dni_cs;
	}

	public String getDhi_cs() {
		return dhi_cs;
	}

	public void setDhi_cs(String dhi_cs) {
		this.dhi_cs = dhi_cs;
	}

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "DataPoint [id=" + id + ", country=" + country + ", state=" + state + ", city=" + city + ", billAmount="
				+ billAmount + ", period=" + period + ", area=" + area + ", energy=" + energy + ", phone=" + phone
				+ ", email=" + email + ", ghi=" + ghi + ", dni=" + dni + ", dhi=" + dhi + ", ghi_cs=" + ghi_cs
				+ ", dni_cs=" + dni_cs + ", dhi_cs=" + dhi_cs + ", dt=" + dt + "]";
	}
	



}
