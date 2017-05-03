package com.atmecs.TechTonics.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.atmecs.TechTonics.dbconnect.DatabaseConnection;
import com.atmecs.TechTonics.pojos.Employee;
import com.atmecs.TechTonics.pojos.TechTalk;

public class TechTalksList {
	public static ArrayList<TechTalk> getTechTalkList() throws SQLException{
		Connection connection = DatabaseConnection.getConnection();
		ResultSet resultSet = connection.createStatement().executeQuery("select * from techtalks");
		ArrayList<TechTalk> techTalks = new ArrayList<>();
		while(resultSet.next()){
			String talkTitle = resultSet.getString("talk_title");
			String talkDescription = resultSet.getString("talk_desc");
			String employeeEmail = resultSet.getString("talk_presenter");
			java.sql.Date talkDate = resultSet.getDate("talk_date");
			Employee employee = EmployeeInfo.getEmployeeInfo(employeeEmail);
			techTalks.add(new TechTalk(talkDate, talkTitle, talkDescription, employee));
		}
		return techTalks;
	}
}
