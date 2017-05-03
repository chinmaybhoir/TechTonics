package com.atmecs.TechTonics.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static Connection connection= null;
	 public static Connection getConnection()
	 {
		  try {
			  System.out.println("Connection established before:"+connection);
			  if(connection==null){
			 Class.forName("com.mysql.jdbc.Driver");  
			 connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/techtonics", "root", "lbcs");
			  }
			  
			 System.out.println("Connection established:"+connection);
		} catch (Exception e) {
			System.out.println("exception:"+ e);
		}
		 return connection;
	 }
	 public static void close(){
		 try {
			connection.close();
			System.out.println("connection closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	

}
