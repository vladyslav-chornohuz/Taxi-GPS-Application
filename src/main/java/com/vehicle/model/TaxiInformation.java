package com.vehicle.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TaxiInformation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vehicleId;
	private String vehicleNo;
	private String vehStatus;
	private Integer vehSpeed_kmph;
	private String vehGpsLocation;
	private Integer vehLoad_Kg;
	private String  vehDateTime;
	public Integer getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getVehStatus() {
		return vehStatus;
	}
	public void setVehStatus(String vehStatus) {
		this.vehStatus = vehStatus;
	}
	public Integer getVehSpeed_kmph() {
		return vehSpeed_kmph;
	}
	public void setVehSpeed_kmph(Integer vehSpeed_kmph) {
		this.vehSpeed_kmph = vehSpeed_kmph;
	}
	public String getVehGpsLocation() {
		return vehGpsLocation;
	}
	public void setVehGpsLocation(String vehGpsLocation) {
		this.vehGpsLocation = vehGpsLocation;
	}
	public Integer getVehLoad_Kg() {
		return vehLoad_Kg;
	}
	public void setVehLoad_Kg(Integer vehLoad_Kg) {
		this.vehLoad_Kg = vehLoad_Kg;
	}
	public String getVehDateTime() {
		return vehDateTime;
	}
	public void setVehDateTime(String vehDateTime) {
		this.vehDateTime = vehDateTime;
	}
	

}
