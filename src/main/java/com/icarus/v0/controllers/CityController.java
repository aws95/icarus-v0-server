package com.icarus.v0.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icarus.v0.entities.City;
import com.icarus.v0.entities.DataPoint;
import com.icarus.v0.exception.ResourceNotFoundException;
import com.icarus.v0.repository.CityRepo;
import com.icarus.v0.services.CityServiceImpl;

@RestController
@RequestMapping("api/v1/city/")
public class CityController {

	@Autowired
	   CityServiceImpl cityService;

	@GetMapping("list")
	public List<City> listCities() {
		return cityService.listCities();
	}

	@GetMapping("{cityId}")
	public City listCity(@PathVariable Long cityId) {
		return cityService.listCity(cityId);
	}
	
	@GetMapping("dataPoints/{countryId}")
	public List<DataPoint> listCityDataPoints(@PathVariable Long countryId) {
		return cityService.listCityDataPoints(countryId);
	}
;

	@PostMapping("add")
	public City createCity(@Valid @RequestBody City city) {
		return cityService.createCity(city);
	}

	@PutMapping("{cityId}")
	public City updateCity(@PathVariable Long cityId, @Valid @RequestBody City cityRequest) {
		return cityService.updateCity(cityId, cityRequest);
	}

	@DeleteMapping("{cityId}")
	public ResponseEntity<?> deleteCity(@PathVariable Long cityId) {
		return cityService.deleteCity(cityId);
	}

}
