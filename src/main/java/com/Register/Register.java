package com.Register;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.*;

@WebServlet(value = "/register")
public class Register extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
			Helper.employee.setName(req.getParameter("user"));
			Helper.employee.setEmail(req.getParameter("email"));
			Helper.employee.setPassword(req.getParameter("password"));
			Helper.employee.setSalary(req.getParameter("salary"));
			Helper.employee.setRole(req.getParameter("role"));
			Helper.employee.setDesignation(req.getParameter("designation"));
			
			Helper.entityTransaction.begin();
			Helper.entityManager.persist(Helper.employee);
			Helper.entityTransaction.commit();
			RequestDispatcher dispatcher=req.getRequestDispatcher("Login.html");
			dispatcher.forward(req, resp);
			
		
			
			
		

		
	}
}
