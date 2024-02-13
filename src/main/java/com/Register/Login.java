package com.Register;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dto.Register_Employee;
import com.dto.Task;

import jakarta.persistence.Query;

@WebServlet(value = "/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter printWriter=resp.getWriter();
		String username=req.getParameter("user");
			String password=req.getParameter("password");
			Query query=Helper.entityManager.createQuery("SELECT details FROM Register_Employee details WHERE details.name= '"+username+"'");
			Register_Employee register=(Register_Employee)query.getResultList().get(0);
			if (register!=null) {
				if(register.getName().equals(username) && register.getPassword().equals(password)) {
					if(register.getRole().equals("Manager")) {
						
					RequestDispatcher dispatcher=req.getRequestDispatcher("Manager_dashboard.html");
					dispatcher.forward(req, resp);
					}
					else {
						
						HttpSession session= req.getSession();
						session.setAttribute("tasks", register.getTasks());
						session.setAttribute("login", register);
						RequestDispatcher dispatcher=req.getRequestDispatcher("Employee_Dashboard.jsp");
						dispatcher.forward(req, resp);
						
					}
				}else {
					printWriter.print("<html><body>");
					printWriter.print("<h5>Invalid Credentials! Try Again!!</h5><br>");
					RequestDispatcher dispatcher=req.getRequestDispatcher("Login.html");
					dispatcher.include(req, resp);
					
				}
			} else {
				printWriter.print("<html><body>");
				printWriter.print("<h5>No User Found! Register Now!!</h5><br>");
				RequestDispatcher dispatcher=req.getRequestDispatcher("Register.html");
				dispatcher.forward(req, resp);
				

			}
		
	}
}
