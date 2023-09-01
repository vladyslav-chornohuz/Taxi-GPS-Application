package com.vehicle.service;

import java.util.List;

import com.vehicle.exceptions.TaxiInformException;
import com.vehicle.model.TaxiResult;

public interface TaxiResultService {
	
	public TaxiResult calTaxiResult(String vehNo,String vehDate) throws TaxiInformException;
	
	public List<TaxiResult> getAllVehResult() throws TaxiInformException;

}
