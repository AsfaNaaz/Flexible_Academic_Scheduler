package com.scheduler.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.scheduler.model.TeacherUser;
import com.scheduler.service.ITeacherService;
import com.scheduler.service.TeacherUserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getAllTeacher")
public class getAllTeacher extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.sendRedirect("TeacherList.jsp");		
		
		
		
		
//		ITeacherService iTeacherService = TeacherUserServiceImpl.getTeacherUserService();
//		try {
//			List<TeacherUser> allTeacher = iTeacherService.getAllTeacher();
//			for (TeacherUser teacherUser : allTeacher) {
//				System.out.println(teacherUser);
//				
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	
	}

}
