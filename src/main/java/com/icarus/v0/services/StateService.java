package com.icarus.v0.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.icarus.v0.entities.DataPoint;
import com.icarus.v0.entities.State;


public interface StateService {
	
	public abstract Object createState(State state);
	public abstract State updateState(Long id, State state);
	public abstract ResponseEntity<?> deleteState(Long id);
	public abstract State listState(Long id);
	public abstract List<DataPoint> listStateDataPoints(Long id);
	public abstract List<State> listStates();
}
