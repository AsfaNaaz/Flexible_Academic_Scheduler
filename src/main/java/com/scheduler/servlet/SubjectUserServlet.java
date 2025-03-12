package com.scheduler.servlet;

import java.io.IOException;

import com.scheduler.model.SubjectUser;
import com.scheduler.service.ISubjectService;
import com.scheduler.service.SubjectUserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/subject_user")
public class SubjectUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String subjectcode=req.getParameter("scode");
		String subjdept=req.getParameter("sdept");
		String subsemester=req.getParameter("ssem");
		String subsection=req.getParameter("ssec");
		String teacherId= req.getParameter("teacherId");
		
		System.out.println(subjectcode);
		System.out.println(subjdept);
		System.out.println(subsemester);
		System.out.println(subsection);
		System.out.println(teacherId);
		
		
		  SubjectUser subjectUser = new SubjectUser();
		  subjectUser.setScode(subjectcode); subjectUser.setSdept(subjdept);
		  subjectUser.setSsem(subsemester); subjectUser.setSsec(subsection);
		  
		  ISubjectService
		  subjectService=SubjectUserServiceImpl.getSubjectUserService(); try {
		  subjectService.saveUser(subjectUser,teacherId); } 
		  catch (Exception e) {
		  e.printStackTrace();
		  
		  }
		  
		  
		  resp.sendRedirect("disp.jsp");  
		 
	}

}
