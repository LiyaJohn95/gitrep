package com.amazonaws.lambda.demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;


public class FamilyDetails implements RequestHandler<Object, String> {
	public static final String HostName="parkingapp.cz8yo6kwaby4.us-east-2.rds.amazonaws.com";
	public static final String DbName="innodb";
	public static final String Port="3306";
	public static final String UserName="genioparking";
	public static final String Password="genio#1234";
	public static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	CallableStatement cstmt = null;
	 ResultSet rs = null;
	
	
    @Override
    public String handleRequest(Object input, Context context) {
        //context.getLogger().log("Input: " + input);

        // TODO: implement your handler
    	context.getLogger().log("jdbc:mysql://"+HostName+":"+Port+"/"+DbName+"?user="+UserName+"&password="+Password);
    	
    	try {
			
    		//Class.forName("com.mysql.jdbc.Driver");
    		//Connection con = DriverManager.getConnection("jdbc:mysql://parkingapp.cz8yo6kwaby4.us-east-2.rds.amazonaws.com/familydetails","genioparking","genio#1234");
    		//String jdbcUrl = "jdbc:mysql://"+HostName+":"+Port+"/"+DbName+"?user="+UserName+"&password="+Password;
    		Connection con = DriverManager.getConnection( "jdbc:mysql://"+HostName+":"+Port+"/"+DbName+"?user="+UserName+"&password="+Password);
    		
    		context.getLogger().log("Test Started");
    		//String getDetails = "{call getDetails(?)}";
    		//Connection connection = DriverManager.getConnection(jdbcUrl);
    		
   
    		 } catch (Exception e) {
    		 // e.printStackTrace();
    		  //context.getLogger().log("Caught exception: " + e.getMessage());
    		  System.out.println(e.getMessage());
    	  
    	  }
    	
    	   return toString();
    }
    	
        
}
