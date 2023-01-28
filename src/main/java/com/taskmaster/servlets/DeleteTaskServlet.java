package com.taskmaster.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taskmaster.dao.TaskDao;


/*
 * This servlet is used to delete a specific task from the database. It will get the taskID and then call the dao and the appropriate method to delete the task. Once completed, it will redirect 
 * back to the homepage, if not there will be an error message.
 *  *  
 *  
 */

public class DeleteTaskServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private TaskDao dao = new TaskDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int status = 0;
		
		try { 
			
			int taskID = Integer.parseInt(request.getParameter("taskID"));
			status = dao.deleteTask(taskID);
			
		} catch (SQLException e) { 
			
			e.printStackTrace();
		}
		
		if (status > 0) {
			response.sendRedirect("http://localhost:8081/TaskMaster_CapstoneProject_Group7/welcome.jsp");
		} else {
			PrintWriter writer = response.getWriter();
			writer.write("Unable to delete!");

		}
		
	}

}
