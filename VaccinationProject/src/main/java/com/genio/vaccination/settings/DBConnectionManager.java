package com.genio.vaccination.settings;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class DBConnectionManager {
	
private static Connection con;
	
	public static BasicDataSource datasource;
	
	
	public static Connection getConnection()
	{
		try
		{
			BasicDataSource datasource = DBConnectionManager.gerDataSource();
			con = (Connection)datasource.getConnection();
			
		}catch(SQLException exce)
		{
			exce.printStackTrace();
		}
		
		return con;
	}
	
	public static BasicDataSource gerDataSource()
	{
		if(datasource == null)
		{
			BasicDataSource ds = new BasicDataSource();
			ds.setUrl(DBSettings.RDS_jdbcUrl);
			ds.setDriverClassName(DBSettings.RDS_DRIVERCLASSNAME);
			ds.setUsername(DBSettings.RDS_USERNAME);
			ds.setPassword(DBSettings.RDS_PASSWORD);
			ds.setMinIdle(5);
			ds.setMaxIdle(10);
			ds.setMaxOpenPreparedStatements(100);
			ds.setAccessToUnderlyingConnectionAllowed(true);
			
			datasource = ds;
		}
		
		return datasource;
	}
	
	public static Connection closeConnection(Connection con)
	{
		try{
			if(con != null){
				con.close();
			}
			
		}catch(SQLException exce)
		{
			exce.printStackTrace();
		}
		
		return null;
	}
	
	public static void main(String[] args) throws SQLException
	
    {

 

        try (BasicDataSource dataSource = DBConnectionManager.gerDataSource();

                Connection connection = (Connection) dataSource.getConnection();

                )

        {

System.out.println("The Connection Object is of Class: "+connection.getClass());

            

        }

    }

}
