package com.scheduler.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.Timestamp;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.scheduler.model.DaySchedule;
import com.scheduler.service.DayScheduleServiceImpl;
import com.scheduler.service.IDayScheduleService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/timing_user")
public class TimingUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DaySchedule days=new DaySchedule();
		String starttime = req.getParameter("stime");
		System.out.println(starttime);
		DateFormat dateFormat = new SimpleDateFormat("HH:mm");

		String scode = req.getParameter("subjectCode");
		System.out.println(scode);
		days.setSubcode(scode);
		

		String subtype = req.getParameter("stype");
		System.out.println(subtype);
		days.setSubtype(subtype);

		String teaid = req.getParameter("teacherId");
		System.out.println(teaid);
		days.setTeacher(teaid);

		String subdate = req.getParameter("sdate");
		System.out.println(subdate);
		days.setDay(subdate);
		
		String deptName = req.getParameter("deptName");
		System.out.println(deptName);
		days.setDept(deptName);
		String batchName = req.getParameter("batchName");
		System.out.println(batchName);
		days.setBatch(batchName);
		java.sql.Timestamp st = null, et = null;
		
		try {

			java.util.Date date = dateFormat.parse(starttime);

			long time = date.getTime();

			st = new java.sql.Timestamp(time);
			System.out.println("starttime"+ time);
			
			if (subtype.equals("Theory") || subtype.equals("Reccess")) {
				
				date.setTime(System.currentTimeMillis()+time + 3600000);
				time=time + 3600000;
			} else if (subtype.equals("lab")) {
				date.setTime(System.currentTimeMillis()+time + 3600000 * 2);
			}

			et = new java.sql.Timestamp(time);
			System.out.println("endtime"+ time);
			System.out.println(et);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		days.setStime(st);
		days.setEtime(et);
		System.out.println(days);
       IDayScheduleService dayScheduleServiceImpl = DayScheduleServiceImpl.getDayScheduleService();
       try {
		dayScheduleServiceImpl.saveUser(days);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       resp.sendRedirect("timing.jsp");
	}

}
