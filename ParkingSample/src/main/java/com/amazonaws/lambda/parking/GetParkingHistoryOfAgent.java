package com.amazonaws.lambda.parking;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.amazonaws.lambda.parking.model.TrackParkingDetails;
import com.amazonaws.lambda.parking.model.TrackParkingDetailsList;
import com.amazonaws.lambda.parking.model.login.AgentLoginResponse;
import com.amazonaws.lambda.parking.settings.DBConnection;
import com.amazonaws.lambda.parking.settings.DBSettings;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class GetParkingHistoryOfAgent implements RequestHandler<AgentLoginResponse, TrackParkingDetailsList> {

    @Override
    public TrackParkingDetailsList handleRequest(AgentLoginResponse input, Context context) {
    	context.getLogger().log("Input: " + input.getAgentID());
        // TODO: implement your handler
    	return getParkingHistoryOfAgents(input, context);
    }

    
public TrackParkingDetailsList getParkingHistoryOfAgents(AgentLoginResponse agentLogin, Context context) {
		
		CallableStatement callableStatement;
		ResultSet rs;
		
		Connection sqlConn = DBConnection.getMySqlDBConnection();
		TrackParkingDetailsList tracklist = new TrackParkingDetailsList();
		ArrayList<TrackParkingDetails> list = new ArrayList<TrackParkingDetails>();
		
		try {
			
			callableStatement = sqlConn.prepareCall(DBSettings.call_get_ParkingHistoryOfAgents);
			callableStatement.setInt(1, agentLogin.getAgentID());
			rs = callableStatement.executeQuery();
			while(rs.next())
			{
			TrackParkingDetails details = new TrackParkingDetails();
			details.setParkingID(rs.getInt(1));
			details.setUserID(rs.getInt(2));
			details.setFromTime(rs.getString(3));
			details.setToTime(rs.getString(4));
			details.setDuration(rs.getFloat(5));
			details.setFare(rs.getFloat(6));
			details.setStatus(rs.getString(7));
			details.setVehicleType(rs.getInt(8));
			details.setName(rs.getString(9));
			details.setAddress(rs.getString(10));
			details.setMobile(rs.getString(11));
			details.setEmail(rs.getString(12));
			details.setQrcode(rs.getString(13));
			details.setTypeName(rs.getString(14));
			
			list.add(details);
			
			
			}
			tracklist.setParkingdetails(list);
			tracklist.setStatusID(1);
			tracklist.setMessage("Successfuly Return");
			if(rs != null)rs.close();
			if(callableStatement != null)callableStatement.close();
			if(sqlConn != null) sqlConn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tracklist.setStatusID(-1);
			tracklist.setMessage("Error Occured");
		}
		return tracklist;
		
	}


}
