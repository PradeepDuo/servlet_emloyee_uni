package com.task;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Register.Helper;
import com.dto.Register_Employee;
import com.dto.Task;

import jakarta.persistence.Query;

@WebServlet(value = "/addTask")
public class AddTask extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String user=req.getParameter("employee");
		Query query=Helper.entityManager.createQuery("SELECT details FROM Register_Employee details WHERE details.name= '"+user+"'");

		try {
			Register_Employee employee=(Register_Employee)query.getResultList().get(0);
			if(employee!=null) {
				Helper.task.setDescription(req.getParameter("description"));
				Helper.task.setStatus(req.getParameter("status"));
				List<Task>tasks=employee.getTasks();
				if(tasks==null) {
					List<Task>tasks1=new ArrayList<Task>();
					tasks1.add(Helper.task);
					employee.setTasks(tasks1);
					Helper.entityTransaction.begin();
					Helper.entityManager.persist(Helper.task);
					Helper.entityManager.merge(employee);
					Helper.entityTransaction.commit();
					PrintWriter printWriter=resp.getWriter();
					printWriter.print("<html><body>");
					printWriter.print("<h2>Task added to the employee  </h2>");
					printWriter.print("</body></html>");
					RequestDispatcher dispatcher=req.getRequestDispatcher("Manager_dashboard.html");
					dispatcher.include(req, resp);
				}
				else {
					tasks.add(Helper.task);
					employee.setTasks(tasks);
					Helper.entityTransaction.begin();
					Helper.entityManager.persist(Helper.task);
					Helper.entityManager.merge(employee);
					Helper.entityTransaction.commit();
					PrintWriter printWriter=resp.getWriter();
					printWriter.print("<html><body>");
					printWriter.print("<h2>Task added to the employee  </h2>");
					printWriter.print("</body></html>");
					RequestDispatcher dispatcher=req.getRequestDispatcher("Manager_dashboard.html");
					dispatcher.include(req, resp);
				}
				
				
				
			}
		} catch (IndexOutOfBoundsException e) {
			PrintWriter printWriter=resp.getWriter();
			printWriter.print("<html><body>");
			printWriter.print("<h2>No employee found </h2>");
			printWriter.print("</body></html>");
			RequestDispatcher dispatcher=req.getRequestDispatcher("Manager_dashboard.html");
			dispatcher.include(req, resp);
		} 
	}
}
