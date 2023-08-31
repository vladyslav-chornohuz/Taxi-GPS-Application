package com.vehicle.service;

import com.vehicle.exceptions.TaxiInformException;
import com.vehicle.model.TaxiResult;

public interface TaxiResultService {
	
	public TaxiResult calTaxiResult(String vehNo,String vehDate) throws TaxiInformException;

}
