package com.scheduler.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.scheduler.model.SubjectUser;
import com.scheduler.service.ISubjectService;
import com.scheduler.service.SubjectUserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getAllSubject")
public class getAllSubject extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("SubjectList.jsp");
//		 ISubjectService iSubjectService = SubjectUserServiceImpl.getSubjectUserService();
//		 try {
//			 List<SubjectUser> allSubject=iSubjectService.getAllSubject();
//			 for(SubjectUser subjectUser:allSubject) {
//				 System.out.println(subjectUser);
//			 }
//		 } catch(SQLException e)
//		 {
//			 e.printStackTrace();
//		 }
	}
	

}
