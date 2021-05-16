package com.icarus.v0.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.icarus.v0.entities.City;
import com.icarus.v0.entities.DataPoint;
import com.icarus.v0.exception.ResourceNotFoundException;
import com.icarus.v0.repository.CityRepo;

@Service
public class CityServiceImpl implements CityService{
	private final CityRepo cityRepo;

	@Autowired
	public CityServiceImpl(CityRepo cityRepo) {
		this.cityRepo = cityRepo;
	}

	@Override
	public List<City> listCities() {
		return (List<City>) cityRepo.findAll();
	}

	@Override
	public City listCity(Long id) {
		return cityRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("City ID " + id + " not found"));
	}

	@Override
	public List<DataPoint> listCityDataPoints(Long id) {
		return cityRepo.findDataPointsByCity(id);
	}

	@Override
	public City createCity(City city) {
		return cityRepo.save(city);
	}

	@Override
	public City updateCity(Long id, City city) {
		return cityRepo.findById(id).map(c -> {
			c.setCityId(city.getCityId());
			c.setCityName(city.getCityName());
			c.setLat(city.getLat());
			c.setLon(city.getLon());
			return cityRepo.save(city);
		}).orElseThrow(() -> new ResourceNotFoundException("City ID " + id + " not found"));
	}

	@Override
	public ResponseEntity<?> deleteCity(Long id) {
		return cityRepo.findById(id).map(city -> {
			cityRepo.delete(city);
			return ResponseEntity.ok().body("City with ID "+ id + " was deleted");
		}).orElseThrow(() -> new ResourceNotFoundException("City ID " + id + " not found"));
	}
}
