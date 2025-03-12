package com.scheduler.service;

import java.sql.SQLException;

import com.scheduler.dao.DayScheduleDaoImpl;
import com.scheduler.dao.IDayScheduleDao;
import com.scheduler.model.DaySchedule;

public class DayScheduleServiceImpl implements IDayScheduleService {
	private static IDayScheduleService dayscheduleservice;
	private DayScheduleServiceImpl() {
		
	}
	public static IDayScheduleService getDayScheduleService() {
		if(dayscheduleservice==null)
			dayscheduleservice=new DayScheduleServiceImpl();
		return dayscheduleservice;
	}
	public void saveUser(DaySchedule dayschedule) throws SQLException{
		IDayScheduleDao dayscheduledao=DayScheduleDaoImpl.getDayScheduleDao();
		System.out.println("hi");
		dayscheduledao.save(dayschedule);
	}

}
