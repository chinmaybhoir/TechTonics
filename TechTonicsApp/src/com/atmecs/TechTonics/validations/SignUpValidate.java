package com.atmecs.TechTonics.validations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.atmecs.TechTonics.dbconnect.DatabaseConnection;

public class SignUpValidate {
	public static boolean isEmailRegistered(String email) throws SQLException{
		Connection connection = DatabaseConnection.getConnection();
		ResultSet resultSet = connection.createStatement().executeQuery("select emp_email from user where emp_email='"+email+"'");
		if(resultSet.next())
			return true;
		else
			return false;
	}
	
	
}
