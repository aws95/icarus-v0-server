package com.icarus.v0.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.icarus.v0.entities.City;
import com.icarus.v0.entities.DataPoint;

@Repository
public interface CityRepo extends JpaRepository<City, Long>{
	@Query("FROM DataPoint dp WHERE dp.city.id = ?1")
	List<DataPoint> findDataPointsByCity(long id);

}
