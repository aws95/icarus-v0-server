package com.icarus.v0.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import com.icarus.v0.entities.DataPoint;

public interface DataPointService {

	public abstract List<DataPoint> getAllDataPoints();

	public abstract Optional<DataPoint> getDataPoint(Long id);

	public abstract DataPoint createDataPoint(Long countryId, Long stateId, Long cityId, DataPoint dataPoint);

	public abstract DataPoint updateDataPoint(Long id, Long countryId, Long stateId, Long cityId,
			DataPoint dataPoint);

	public abstract ResponseEntity<?> deleteDataPoint(Long id);

}
