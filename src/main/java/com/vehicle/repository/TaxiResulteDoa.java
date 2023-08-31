package com.vehicle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicle.model.TaxiResult;

@Repository
public interface TaxiResulteDoa extends JpaRepository<TaxiResult, Integer>{
	

}
