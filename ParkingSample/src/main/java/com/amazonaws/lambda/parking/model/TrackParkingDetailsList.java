package com.amazonaws.lambda.parking.model;

import java.util.ArrayList;

import com.amazonaws.lambda.parking.model.general.GeneralResponseStatus;



public class TrackParkingDetailsList extends GeneralResponseStatus{

	ArrayList<TrackParkingDetails> parkingdetails;

	public ArrayList<TrackParkingDetails> getParkingdetails() {
		return parkingdetails;
	}

	public void setParkingdetails(ArrayList<TrackParkingDetails> parkingdetails) {
		this.parkingdetails = parkingdetails;
	}
	
	
}
