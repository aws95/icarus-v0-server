package com.icarus.v0.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.icarus.v0.entities.City;
import com.icarus.v0.entities.DataPoint;

public interface CityService {
	

	public abstract List<City> listCities() ;
	public abstract City listCity(Long id);
	public abstract List<DataPoint> listCityDataPoints(Long id);
	public abstract City createCity(City city);
	public abstract City updateCity(Long id,City city) ;
	public abstract ResponseEntity<?> deleteCity(Long id);

}
