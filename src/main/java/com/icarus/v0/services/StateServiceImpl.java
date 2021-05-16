package com.icarus.v0.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.icarus.v0.entities.DataPoint;
import com.icarus.v0.entities.State;
import com.icarus.v0.exception.ResourceNotFoundException;
import com.icarus.v0.repository.StateRepo;


@Service
public class StateServiceImpl implements StateService {

	private final StateRepo stateRepo;

	@Autowired
	public StateServiceImpl(StateRepo stateRepo) {
		this.stateRepo = stateRepo;
	}

	@Override
	public State createState(State state) {
		return stateRepo.save(state);
	}

	@Override
	public State updateState(Long id, State state) {
		return stateRepo.findById(id).map(st -> {
			st.setStateId(state.getStateId());
			st.setStateName(state.getStateName());
			st.setLat(state.getLat());
			st.setLon(state.getLon());
			return stateRepo.save(state);
		}).orElseThrow(() -> new ResourceNotFoundException("State ID " + id + " not found"));
	}

	@Override
	public ResponseEntity<?> deleteState(Long id) {
		return stateRepo.findById(id).map(state -> {
			stateRepo.delete(state);
			return ResponseEntity.ok().body("State with ID " + id + "was deleted");
		}).orElseThrow(() -> new ResourceNotFoundException("State ID " + id + " not found"));
	}

	@Override
	public State listState(Long id) {
		return stateRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("State ID " + id + " not found"));
	}

	@Override
	public List<DataPoint> listStateDataPoints(Long id) {
		return stateRepo.findDataPointsByState(id);
	}

	@Override
	public List<State> listStates() {
		return (List<State>) stateRepo.findAll();
	}

}
