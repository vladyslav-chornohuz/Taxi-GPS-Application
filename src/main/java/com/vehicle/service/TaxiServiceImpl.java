package com.vehicle.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.exceptions.TaxiInformException;
import com.vehicle.model.TaxiInformation;
import com.vehicle.repository.TaxiDao;

@Service
public class TaxiServiceImpl implements TaxiService{
	
	@Autowired
	private TaxiDao taxiDao;

	@Override
	public TaxiInformation addTaxiDetails(TaxiInformation taxiInformation) {
		TaxiInformation taxiInform= taxiInformation;
//		taxiInform.setDateTime(LocalDateTime.now());
		return taxiDao.save(taxiInform);
	}

	@Override
	public List<TaxiInformation> getAllVehDetails() throws TaxiInformException {
		List<TaxiInformation> lt=taxiDao.findAll();
		
		if(lt.size()>0)
			return lt;
		else
			throw new  TaxiInformException("No Taxi-Record found");
	}

	@Override
	public List<TaxiInformation> getSingleVehicleDetails(String vehNo) throws TaxiInformException {
		List<TaxiInformation> singLt=taxiDao.findByVehicleNo(vehNo);
		
		if(singLt.size()>0)
			return singLt;
		else
			throw new  TaxiInformException("Invalid Vehicle Nummber :"+vehNo); 
	}

}
