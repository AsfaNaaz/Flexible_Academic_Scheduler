package com.scheduler.servlet;

import java.io.IOException;

import com.scheduler.model.ClassroomUser;
import com.scheduler.service.ClassroomUserServiceImpl;
import com.scheduler.service.IClassroomService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/classroom_user")
public class ClassroomUserServlet extends HttpServlet {
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String classroomno=req.getParameter("cno");
		String classroomblock=req.getParameter("cblock");
	String subjectCode = req.getParameter("subjectCode");
	String studentdept=req.getParameter("sdept");
	String studentsection=req.getParameter("ssec");
		 
		ClassroomUser classroomUser = new ClassroomUser();
		classroomUser.setCno(classroomno);
		classroomUser.setCblock(classroomblock);
		
		
		IClassroomService  classroomService=ClassroomUserServiceImpl.getClassroomUserService();
		try {
		classroomService.saveUser(classroomUser,subjectCode,studentdept,studentsection);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		resp.sendRedirect("disp.jsp");
	}
 
}
