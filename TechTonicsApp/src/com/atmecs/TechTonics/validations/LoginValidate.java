package com.atmecs.TechTonics.validations;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.atmecs.TechTonics.dbconnect.DatabaseConnection;


public class LoginValidate {
	public static boolean isEmailRegistered(String email) throws SQLException{
		Connection connection = DatabaseConnection.getConnection();
		ResultSet resultSet = connection.createStatement().executeQuery("select emp_email from user where emp_email='"+email+"'");
		if(resultSet.next())
			return true;
		else
			return false;
	}
	
	public static boolean isValidated(String email, String password) throws SQLException{
		Connection connection = DatabaseConnection.getConnection();
		ResultSet resultSet = connection.createStatement().executeQuery("select * from user where emp_email='"+email+"'");
		resultSet.next();
		String dbPassword = resultSet.getString("emp_password");
		if(dbPassword.equals(password))
			return true;
		else
			return false;
	}
}
