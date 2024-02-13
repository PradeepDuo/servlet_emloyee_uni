package com.task;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Register.Helper;
import com.dto.Task;

@WebServlet(value = "/update")
public class TaskUpdate extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		PrintWriter printWriter=resp.getWriter();
		HttpSession session=req.getSession();
		System.out.println(req.getParameter("Update"));
		List<Task>list=(List<Task>)session.getAttribute("tasks");
		for (Task task : list) {
			if(id==task.getId()) {
				task.setStatus("closed");
				task.setCompleteTime(LocalDateTime.now());
				Helper.entityTransaction.begin();
				Helper.entityManager.merge(task);
				Helper.entityTransaction.commit();
				RequestDispatcher dispatcher=req.getRequestDispatcher("Employee_Dashboard.jsp");
				dispatcher.forward(req, resp);
			}else {
				printWriter.print("<html><body>");
				printWriter.print("<h2>Operation cannot be done</h2>");
				printWriter.print("</body></html>");
			}
		}
	}
}
