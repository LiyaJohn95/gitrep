package com.amazonaws.lambda.parking.settings;

import java.sql.DriverManager;
import java.sql.SQLException;


import com.mysql.jdbc.Connection;

public class DBConnection {
	
	public static Connection getMySqlDBConnection()
	{
		String jdbcUrl = DBSettings.RDS_URL + DBSettings.RDS_HOSTNAME + ":" +
			    DBSettings.RDS_PORT + "/" + DBSettings.RDS_DB_NAME + "?user=" + DBSettings.RDS_USERNAME + "&password=" + DBSettings.RDS_PASSWORD;
			  
			  // Load the JDBC driver
			  try {
			    System.out.println("Loading driver...");
			    Class.forName(DBSettings.RDS_DRIVERCLASSNAME);
			    System.out.println("Driver loaded!");
			  } catch (ClassNotFoundException e) {
			    throw new RuntimeException("Cannot find the driver in the classpath!", e);
			  }

			  Connection conn = null;

			  try {
			    // Create connection to RDS DB instance
			    conn = (Connection)DriverManager.getConnection(jdbcUrl);
			  }catch(SQLException ex)
			  {
				  throw new RuntimeException("Connection falied with parameter", ex);
			  }
			  
			  return conn;
	}


}
