package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection conn;
	public void getDbconnection(String url, String username, String password) throws SQLException {
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		 conn=DriverManager.getConnection(url, username, password);
		}catch(Exception e) {
		
	}
    
		}
	
	public void getDbconnection() throws SQLException {
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		}catch(Exception e) {
		
	}
    
		}
	public void closeDbconnection() throws SQLException {
		try {
		conn.close();
		}catch(Exception e) {
	}
	}
	public ResultSet executeSelectQuery(String query) {
		ResultSet result=null;
		try {
			Statement state=conn.createStatement();
			result= state.executeQuery(query);
			
		}catch(Exception e) {
		}
		return result;
		
	}
	public int executeNonSelectQuery(String query) {
		int result=0;
		try {
			Statement state=conn.createStatement();
			result= state.executeUpdate(query);
		}catch(Exception e) {
	}
		return result;
	
}
}