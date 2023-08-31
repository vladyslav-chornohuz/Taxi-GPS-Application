package com.vehicle.service;

import java.util.List;

import com.vehicle.exceptions.TaxiInformException;
import com.vehicle.model.TaxiInformation;

public interface TaxiService {

	
	public TaxiInformation addTaxiDetails(TaxiInformation taxiInformation);
	public List<TaxiInformation> getAllVehDetails()throws TaxiInformException;
	public List<TaxiInformation> getSingleVehicleDetails(String vehNo)throws TaxiInformException;

}
