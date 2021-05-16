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

import com.icarus.v0.entities.DataPoint;
import com.icarus.v0.entities.State;
import com.icarus.v0.exception.ResourceNotFoundException;
import com.icarus.v0.repository.StateRepo;
import com.icarus.v0.services.StateService;
import com.icarus.v0.services.StateServiceImpl;

@RestController
@RequestMapping({"api/v1/states/"})
public class StateController {
	
	
	@Autowired
	   StateServiceImpl stateService;

	@GetMapping("list")
	public List<State> listStates() {
		return (List<State>) stateService.listStates();
	}

	@GetMapping("{stateId}")
	public State listState(@PathVariable Long stateId) {
		return stateService.listState(stateId);
		
	}
	
	@GetMapping("dataPoints/{stateId}")
	public List<DataPoint> listStateDataPoints(@PathVariable Long stateId) {
		return stateService.listStateDataPoints(stateId);
	}

	@PostMapping("add")
	public State createState(@Valid @RequestBody State state) {
		System.out.println(state);
		return stateService.createState(state);
	}

	@PutMapping("{stateId}")
	public State updateState(@PathVariable Long stateId, @Valid @RequestBody State stateRequest) {
		return stateService.updateState(stateId, stateRequest);
	}

	@DeleteMapping("{stateId}")
	public ResponseEntity<?> deleteState(@PathVariable Long stateId) {
		return stateService.deleteState(stateId);
	}
}
