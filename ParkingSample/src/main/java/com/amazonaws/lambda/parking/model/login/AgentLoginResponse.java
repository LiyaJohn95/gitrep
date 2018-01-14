package com.amazonaws.lambda.parking.model.login;

import com.amazonaws.lambda.parking.model.general.GeneralResponseStatus;

public class AgentLoginResponse extends GeneralResponseStatus{

	
int AgentID;
	
	String Mobile;

	String Name;
	
	String Address;
	
	int TotalSlot;
	
	int AvailableSlot;
	
	String LAT;
	
	String LNG;
	
	int Count;

	public int getAgentID() {
		return AgentID;
	}

	public void setAgentID(int agentID) {
		AgentID = agentID;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getTotalSlot() {
		return TotalSlot;
	}

	public void setTotalSlot(int totalSlot) {
		TotalSlot = totalSlot;
	}

	public int getAvailableSlot() {
		return AvailableSlot;
	}

	public void setAvailableSlot(int availableSlot) {
		AvailableSlot = availableSlot;
	}

	public String getLAT() {
		return LAT;
	}

	public void setLAT(String lAT) {
		LAT = lAT;
	}

	public String getLNG() {
		return LNG;
	}

	public void setLNG(String lNG) {
		LNG = lNG;
	}

	public int getCount() {
		return Count;
	}

	public void setCount(int count) {
		Count = count;
	}
	
}
