package com.atmecs.TechTonics.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.atmecs.TechTonics.dbconnect.DatabaseConnection;
import com.atmecs.TechTonics.pojos.Employee;

public class NewAttendee {
	public static void persistNewAttendee(String talkTitle, Employee employee) throws SQLException{
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into talkattendence values('"+talkTitle+"','"+employee.getEmployeeEmail()+"')");
		preparedStatement.executeUpdate();
	}
}
