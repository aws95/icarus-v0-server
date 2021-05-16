package com.icarus.v0.entities;

import java.util.List;

public class OpenWeatherResponse {
	private List<ResponseListItems> list;
	private Coord coord;


	public List<ResponseListItems> getList() {
		return list;
	}

	public void setList(List<ResponseListItems> list) {
		this.list = list;
	}

	public Coord getCoord() {
		return coord;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	public OpenWeatherResponse(List<ResponseListItems> list, Coord coord) {
		this.list = list;
		this.coord = coord;
	}

	public OpenWeatherResponse() {
	}

}
