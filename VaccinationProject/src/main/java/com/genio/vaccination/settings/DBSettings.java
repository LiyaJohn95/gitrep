package com.genio.vaccination.settings;

public class DBSettings {
	
public static  String RDS_HOSTNAME = "parkingapp.cz8yo6kwaby4.us-east-2.rds.amazonaws.com";
	
	public static  String RDS_PORT = "3306";
	
	public static String RDS_DB_NAME = "ima";
	
	public static String RDS_USERNAME = "genioparking";
	
	public static String RDS_PASSWORD = "genio#1234";
	
	public static String RDS_DRIVERCLASSNAME = "com.mysql.jdbc.Driver";
	
	public static String RDS_URL="jdbc:mysql://";
	
	public static String RDS_jdbcUrl = DBSettings.RDS_URL + DBSettings.RDS_HOSTNAME + ":" +
		    DBSettings.RDS_PORT + "/" + DBSettings.RDS_DB_NAME;
	
	public static String call_add_UserDetails = "{call add_UserDetails(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )}";


}
