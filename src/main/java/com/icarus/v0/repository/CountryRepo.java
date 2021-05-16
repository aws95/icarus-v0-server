package com.icarus.v0.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.icarus.v0.entities.Country;
import com.icarus.v0.entities.DataPoint;

@Repository
public interface CountryRepo extends JpaRepository<Country, Long>{
	@Query("FROM DataPoint dp WHERE dp.country.id = ?1")
	List<DataPoint> findDataPointsByCountry(long id);
}
