package com.vehicle.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TaxiResult {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vehId;
	private String vehNumber;
	private String vehDate;
	private Integer vehMomentIn_minutes;
	private Integer vehIdleIn_minutes;
	private Integer kmDriven;
	
	public Integer getVehId() {
		return vehId;
	}
	public void setVehId(Integer vehId) {
		this.vehId = vehId;
	}
	public String getVehNumber() {
		return vehNumber;
	}
	public void setVehNumber(String vehNumber) {
		this.vehNumber = vehNumber;
	}
	public String getVehDate() {
		return vehDate;
	}
	public void setVehDate(String vehDate) {
		this.vehDate = vehDate;
	}
	public Integer getVehMomentIn_minutes() {
		return vehMomentIn_minutes;
	}
	public void setVehMomentIn_minutes(Integer vehMomentIn_minutes) {
		this.vehMomentIn_minutes = vehMomentIn_minutes;
	}
	public Integer getVehIdleIn_minutes() {
		return vehIdleIn_minutes;
	}
	public void setVehIdleIn_minutes(Integer vehIdleIn_minutes) {
		this.vehIdleIn_minutes = vehIdleIn_minutes;
	}
	public Integer getKmDriven() {
		return kmDriven;
	}
	public void setKmDriven(Integer kmDriven) {
		this.kmDriven = kmDriven;
	}
	
	
	
	
	

}
