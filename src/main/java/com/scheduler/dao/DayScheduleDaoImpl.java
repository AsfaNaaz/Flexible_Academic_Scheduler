package com.scheduler.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.scheduler.factory.DatabaseUtil;
import com.scheduler.model.DaySchedule;
import com.scheduler.model.DayTimeTable;
import com.scheduler.model.SubjectSchedule;

public class DayScheduleDaoImpl implements IDayScheduleDao {
	private static final String Day_Schedule_Query = "insert into timing (stime,etime,subjectcode,TeacherId,weekday,stype)values(?,?,?,?,?,?)";
	private static final String Day_Schedule_Select = "SELECT stime,etime,subjectcode,TeacherId,weekday,stype FROM flexi_acedmic_schedular.timing where weekday=? order by stime";
	private static IDayScheduleDao dayScheduleDao;

	private DayScheduleDaoImpl() {

	}

	public static IDayScheduleDao getDayScheduleDao() {
		if (dayScheduleDao == null) {
			dayScheduleDao = new DayScheduleDaoImpl();
		}
		return dayScheduleDao;
	}

	@Override
	public void save(DaySchedule dayschedule) throws SQLException {

		Connection connection = DatabaseUtil.getConnection();
		PreparedStatement prepareStatement = null;
		if (connection != null) {
			prepareStatement = connection.prepareStatement(Day_Schedule_Query);
			if (prepareStatement != null) {
				prepareStatement.setTimestamp(1, dayschedule.getStime());
				prepareStatement.setTimestamp(2, dayschedule.getEtime());
				prepareStatement.setString(3, dayschedule.getSubcode());
				prepareStatement.setString(4, dayschedule.getTeacher());
				prepareStatement.setInt(5, Integer.parseInt(dayschedule.getDay()));
				prepareStatement.setString(6, dayschedule.getSubtype());
				prepareStatement.executeUpdate();

			}
		}
		DatabaseUtil.CloseResources(connection, prepareStatement, null);
	}

	public DayTimeTable RetrieveSchedule(int day) throws SQLException {
		Connection connection = DatabaseUtil.getConnection();
		PreparedStatement preparedStatement = null;
		List<SubjectSchedule> sub = null;
		if (connection != null) {
			preparedStatement = connection.prepareStatement(Day_Schedule_Select);
			if (preparedStatement != null) {

				preparedStatement.setInt(1, day);
				ResultSet executeQuery = preparedStatement.executeQuery();
				sub = new ArrayList<>();
				while (executeQuery.next()) {
				String etime=executeQuery.getTimestamp("etime").toString();
				String stime=executeQuery.getTimestamp("stime").toString();
					SubjectSchedule subjectSchedule = new SubjectSchedule();
					subjectSchedule.setEtime(etime.substring(etime.length()-10,etime.length()-10+5));
					subjectSchedule.setStime(stime.substring(stime.length()-10,stime.length()-10+5));
					subjectSchedule.setSubcode(executeQuery.getString("subjectcode"));
					subjectSchedule.setSubtype(executeQuery.getString("stype"));
					subjectSchedule.setTeacherid(executeQuery.getString("TeacherId"));
					sub.add(subjectSchedule);
				}

			}

		}
		System.out.println(sub);
		DayTimeTable dayTimeTable = new DayTimeTable();
		dayTimeTable.setWeekday(day);
		dayTimeTable.setSubjects(sub);
		return dayTimeTable;

	}
}
