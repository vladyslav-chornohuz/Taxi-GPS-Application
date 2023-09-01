package com.vehicle.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.exceptions.TaxiInformException;
import com.vehicle.model.TaxiInformation;
import com.vehicle.model.TaxiResult;
import com.vehicle.service.TaxiResultService;
import com.vehicle.service.TaxiService;

@RestController
public class TaxiInformController {
	
	@Autowired
	private TaxiService taxiService;
	
	@Autowired
	private TaxiResultService resultService;
	
	@PostMapping("/taxiInformation")
	public ResponseEntity<TaxiInformation> addVehicleDetails(@RequestBody TaxiInformation taxiInfo){
		
		TaxiInformation taxiInformation= taxiService.addTaxiDetails(taxiInfo);
		
		return new ResponseEntity<>(taxiInformation,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/taxiInformation")
	public ResponseEntity<List<TaxiInformation>> getAllVehicleDetails() throws TaxiInformException{
		List<TaxiInformation> allTaxiInfor=taxiService.getAllVehDetails();
		return new ResponseEntity<List<TaxiInformation>>(allTaxiInfor,HttpStatus.OK);
		
	}
	
	@GetMapping("/SingleVehicleDetailsByVehicleNumber/{vehNo}")
	public ResponseEntity<List<TaxiInformation>> singleVehicleDetailsByVehicleNumbe(@PathVariable("vehNo") String vehNum) throws TaxiInformException{
		List<TaxiInformation> singVeh=taxiService.getSingleVehicleDetails(vehNum);
		return new ResponseEntity<List<TaxiInformation>>(singVeh,HttpStatus.OK);
		
	}
	
	@GetMapping("/vehicleResult/{vehNo}/{vehDate}")
	public ResponseEntity<TaxiResult> vehicleResult(@PathVariable("vehNo") String vehNum,@PathVariable("vehDate") String vehDate) throws TaxiInformException{
		TaxiResult vehRes=resultService.calTaxiResult(vehNum, vehDate);
		return new ResponseEntity<TaxiResult>(vehRes,HttpStatus.OK);
		
	}
	
	
	@GetMapping("/taxiResult")
	public ResponseEntity<List<TaxiResult>> getAllVehicleResult() throws TaxiInformException{
		List<TaxiResult> allTaxiInfor=resultService.getAllVehResult();
		return new ResponseEntity<List<TaxiResult>>(allTaxiInfor,HttpStatus.OK);
		
	}
	
	

}
