package com.icarus.v0.entities;

public class ResponseListItems {
	private Double dt;
	private Radiation radiation;

	public Double getDt() {
		return dt;
	}

	public Radiation getRadiation() {
		return radiation;
	}

	public void setRadiation(Radiation radiation) {
		this.radiation = radiation;
	}

	public void setDt(Double dt) {
		this.dt = dt;
	}

	public ResponseListItems(Double dt, Radiation radiation) {
		this.dt = dt;
		this.radiation = radiation;
	}

	public ResponseListItems() {
	}
	
 
}
