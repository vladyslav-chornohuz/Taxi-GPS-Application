package com.vehicle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehicle.model.TaxiInformation;

@Repository
public interface TaxiDao extends JpaRepository<TaxiInformation, Integer>{
	
	public List<TaxiInformation> findByVehicleNo(String vehicleNo);
}
