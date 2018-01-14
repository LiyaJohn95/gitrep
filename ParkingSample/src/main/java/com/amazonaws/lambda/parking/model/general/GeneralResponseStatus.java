package com.amazonaws.lambda.parking.model.general;

public class GeneralResponseStatus {
	
int statusID;
	
	String message;
	
	int currentAgentID;

	public int getStatusID() {
		return statusID;
	}

	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCurrentAgentID() {
		return currentAgentID;
	}

	public void setCurrentAgentID(int currentAgentID) {
		this.currentAgentID = currentAgentID;
	}
	
	

}
