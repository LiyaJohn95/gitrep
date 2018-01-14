package com.amazonaws.lambda.parking.model;

public class TrackParkingDetails {
	
	int ParkingID;
	int UserID;
	String FromTime;
	String ToTime;
	float Duration;
	float Fare;
	String Status;
	int VehicleType;
	
	String TypeName;
	
	String name;
	String address;
	String mobile;
	String email;
	String qrcode;
	
	
	public int getParkingID() {
		return ParkingID;
	}
	public void setParkingID(int parkingID) {
		ParkingID = parkingID;
	}
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	public String getFromTime() {
		return FromTime;
	}
	public void setFromTime(String fromTime) {
		FromTime = fromTime;
	}
	public String getToTime() {
		return ToTime;
	}
	public void setToTime(String toTime) {
		ToTime = toTime;
	}
	public float getDuration() {
		return Duration;
	}
	public void setDuration(float duration) {
		Duration = duration;
	}
	public float getFare() {
		return Fare;
	}
	public void setFare(float fare) {
		Fare = fare;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public int getVehicleType() {
		return VehicleType;
	}
	public void setVehicleType(int vehicleType) {
		VehicleType = vehicleType;
	}
	public String getTypeName() {
		return TypeName;
	}
	public void setTypeName(String typeName) {
		TypeName = typeName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQrcode() {
		return qrcode;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	
	

}
