package com.icarus.v0.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icarus.v0.entities.City;
import com.icarus.v0.entities.Country;
import com.icarus.v0.entities.State;
import com.icarus.v0.entities.DataPoint;
import com.icarus.v0.repository.CityRepo;
import com.icarus.v0.repository.CountryRepo;
import com.icarus.v0.repository.DataPointRepo;
import com.icarus.v0.repository.StateRepo;
import com.icarus.v0.services.DataPointServiceImpl;
import com.icarus.v0.exception.ResourceNotFoundException;
@CrossOrigin
@RestController
@RequestMapping({ "api/v1/dataPoints/" })
public class DataPointController {

	 @Autowired
	   DataPointServiceImpl dataPointService;


	@GetMapping("list")
	public List<DataPoint> getAllDataPoints() {
		return dataPointService.getAllDataPoints();
	}

	@GetMapping("{dataPointId}")
	public Optional<DataPoint> getDataPoint(@PathVariable(value = "dataPointId") Long dataPointId) {
		return dataPointService.getDataPoint(dataPointId);
	}

	@PostMapping("{countryId}/{stateId}/{cityId}")
	DataPoint createDataPoint(@PathVariable(value = "countryId") Long countryId,
			@PathVariable(value = "stateId") Long stateId, @PathVariable(value = "cityId") Long cityId,
			@Valid @RequestBody DataPoint dataPoint) {
		return dataPointService.createDataPoint(countryId, stateId, cityId, dataPoint);
	}

	@PutMapping("{countryId}/{stateId}/{cityId}/{dataPointId}")
	public DataPoint updateDataPoint(@PathVariable(value = "dataPointId") Long dataPointId,
			@PathVariable(value = "countryId") Long countryId, @PathVariable(value = "stateId") Long stateId,
			@PathVariable(value = "cityId") Long cityId, @Valid @RequestBody DataPoint dataPointRequest) {
		return dataPointService.updateDataPoint(dataPointId, countryId, stateId, cityId, dataPointRequest);
	}

	@DeleteMapping("{dataPointId}")
	public ResponseEntity<?> deleteDataPoint(@PathVariable(value = "dataPointId") Long dataPointId) {
		return dataPointService.deleteDataPoint(dataPointId);
	}
}
