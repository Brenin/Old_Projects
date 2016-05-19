package com.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB implements AutoCloseable {

	private Connection con;
	private String serverName = "";
	private String databaseName = "";
	
	public ConnectToDB (String user, String password) throws SQLException {
		
		try{
			con = DriverManager.getConnection
				("jdbc:mysql://" + serverName + "/" + databaseName, user, password);
		} catch(SQLException sqlex){
			sqlex.printStackTrace();
		}
	}
	
	public void close() throws SQLException {
		con.close();
	}
	
	public Connection getConnection(){
		return con;
	}
}
