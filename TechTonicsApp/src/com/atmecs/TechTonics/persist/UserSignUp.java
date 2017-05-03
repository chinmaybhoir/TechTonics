package com.atmecs.TechTonics.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.atmecs.TechTonics.dbconnect.DatabaseConnection;

public class UserSignUp {
	public static void persistUser(String employeeEmail, String employeeName, String employeePassword) throws SQLException{
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into user values('"+employeeEmail+"','"+employeeName+"','"+employeePassword+"')");
		preparedStatement.executeUpdate();
	}
}
