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

import com.icarus.v0.entities.Country;
import com.icarus.v0.entities.DataPoint;
import com.icarus.v0.exception.ResourceNotFoundException;
import com.icarus.v0.repository.CountryRepo;
import com.icarus.v0.services.CountryServiceImpl;


@RestController
@RequestMapping({"api/v1/countries/"})
public class CountryController {
	@Autowired
	   CountryServiceImpl countryService;


	@GetMapping("list")
	public List<Country> listCountries() {
		return countryService.listCountries();
	}

	@GetMapping("{countryId}")
	public Country listCountry(@PathVariable Long countryId) {
		return countryService.listCountry(countryId);
	}
	
	@GetMapping("dataPoints/{countryId}")
	public List<DataPoint> listCountryDataPoints(@PathVariable Long countryId) {
		return countryService.listCountryDataPoints(countryId);
	}

	@PostMapping("add")
	public Country createCountry(@Valid @RequestBody Country country) {
		return countryService.createCountry(country);
	}

	@PutMapping("{countryId}")
	public Country updateCountry(@PathVariable Long countryId, @Valid @RequestBody Country countryRequest) {
		return countryService.updateCountry(countryId, countryRequest);
	}

	@DeleteMapping("{countryId}")
	public ResponseEntity<?> deleteCountry(@PathVariable Long countryId) {
		return countryService.deleteCountry(countryId);
	}
}
