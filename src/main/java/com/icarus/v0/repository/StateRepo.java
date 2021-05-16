package com.icarus.v0.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.icarus.v0.entities.DataPoint;
import com.icarus.v0.entities.State;

@Repository
public interface StateRepo extends JpaRepository<State, Long>{
	
	@Query("FROM DataPoint dp WHERE dp.state.id = ?1")
	List<DataPoint> findDataPointsByState(long id);
}
