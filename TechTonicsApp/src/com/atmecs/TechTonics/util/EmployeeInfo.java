package com.atmecs.TechTonics.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.atmecs.TechTonics.dbconnect.DatabaseConnection;
import com.atmecs.TechTonics.pojos.Employee;

public class EmployeeInfo {
	public static Employee getEmployeeInfo(String email) throws SQLException{
		Connection connection = DatabaseConnection.getConnection();
		ResultSet resultSet = connection.createStatement().executeQuery("select * from user where emp_email='"+email+"'");
		resultSet.next();
		String employeeName = resultSet.getString("emp_name");
		String employeeEmail = resultSet.getString("emp_email");
		String employeePassword = resultSet.getString("emp_password");
		Employee employee = new Employee(employeeEmail, employeeName, employeePassword);
		return employee;
	}
}
