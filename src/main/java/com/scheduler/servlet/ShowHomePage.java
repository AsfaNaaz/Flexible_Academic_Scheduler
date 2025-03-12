package com.scheduler.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@ WebServlet("/")
public class ShowHomePage extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.sendRedirect("home.jsp");
		//RequestDispatcher requestDispatcher = req.getRequestDispatcher("home.jsp");
		//requestDispatcher.forward(req, resp);
		
		
		
	}
    

}
