package com.scheduler.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import com.scheduler.model.TeacherUser;
import com.scheduler.service.ITeacherService;
import com.scheduler.service.TeacherUserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/teacher_login")
public class TeacherUserServlet extends HttpServlet{
       
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter Writer=resp.getWriter();
		String teachername=req.getParameter("tname");
		String teacherid=req.getParameter("tid");
		String teacherdept=req.getParameter("tdept");
		
		TeacherUser teacherUser = new TeacherUser();
		teacherUser.setTname(teachername);
		teacherUser.setTid(teacherid);
		teacherUser.setTdept(teacherdept);
		
		ITeacherService teacherService=TeacherUserServiceImpl.getTeacherUserService();
		try {
			teacherService.saveUser(teacherUser);
		}
		catch(Exception e){
			e.printStackTrace();
			Writer.print("user Id Not Valid");
		}
		
		
		
		 resp.sendRedirect("disp.jsp");
		
		 
	}
	

}
