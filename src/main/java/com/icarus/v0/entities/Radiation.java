package com.icarus.v0.entities;

public class Radiation {
	private Double ghi;
	private Double dni;
	private Double dhi;
	private Double ghi_cs;
	private Double dni_cs;
	private Double dhi_cs;
	public Double getGhi() {
		return ghi;
	}
	public void setGhi(Double ghi) {
		this.ghi = ghi;
	}
	public Double getDni() {
		return dni;
	}
	public void setDni(Double dni) {
		this.dni = dni;
	}
	public Double getDhi() {
		return dhi;
	}
	public void setDhi(Double dhi) {
		this.dhi = dhi;
	}
	public Double getGhi_cs() {
		return ghi_cs;
	}
	public void setGhi_cs(Double ghi_cs) {
		this.ghi_cs = ghi_cs;
	}
	public Double getDni_cs() {
		return dni_cs;
	}
	public void setDni_cs(Double dni_cs) {
		this.dni_cs = dni_cs;
	}
	public Double getDhi_cs() {
		return dhi_cs;
	}
	public void setDhi_cs(Double dhi_cs) {
		this.dhi_cs = dhi_cs;
	}
	public Radiation(Double ghi, Double dni, Double dhi, Double ghi_cs, Double dni_cs, Double dhi_cs) {
		this.ghi = ghi;
		this.dni = dni;
		this.dhi = dhi;
		this.ghi_cs = ghi_cs;
		this.dni_cs = dni_cs;
		this.dhi_cs = dhi_cs;
	}
	public Radiation() {
	}
}
