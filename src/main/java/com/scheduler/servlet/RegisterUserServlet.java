package com.scheduler.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.scheduler.model.RegisterUser;
import com.scheduler.service.IRegisterService;
import com.scheduler.service.RegisterUserServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register_user")
public class RegisterUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		
		String username  = req.getParameter("username");
		String pass = req.getParameter("password");
		
		
		
		
		
		RegisterUser registerUser = new RegisterUser();
		  registerUser.setUsername(username);
		  registerUser.setPassword(pass);
		  
		// RegisterUserServiceImpl registerUserServiceImpl = new RegisterUserServiceImpl();
		  
		  IRegisterService registerService = RegisterUserServiceImpl.getRegisterUserService();
		 try {
			registerService.saveUser(registerUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			writer.println(" User ID Not Valid ");
		}
		 resp.sendRedirect("disp.jsp");
		  
		  
		 
	}

}
