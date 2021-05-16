package com.icarus.v0.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icarus.v0.entities.DataPoint;

@Repository
public interface DataPointRepo extends JpaRepository<DataPoint, Long>{

}
