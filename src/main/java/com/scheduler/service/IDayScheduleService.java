package com.scheduler.service;

import java.sql.SQLException;

import com.scheduler.model.DaySchedule;

public interface IDayScheduleService {
	public void saveUser(DaySchedule dayschedule)throws SQLException;

}
