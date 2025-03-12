package com.scheduler.dao;

import java.sql.SQLException;

import com.scheduler.model.DaySchedule;
import com.scheduler.model.DayTimeTable;

public interface IDayScheduleDao {
	public void save(DaySchedule dayschedule)throws SQLException;
	public DayTimeTable RetrieveSchedule(int day) throws SQLException ;

}
