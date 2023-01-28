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
 * This servlet is used to delete all tasks in the SQL database table.
 *  *  
 *  
 */

public class DeleteAllTasksServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TaskDao dao = new TaskDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int delete = 0;
		
		try { 
			
			delete = dao.deleteAllTasks();
			
		} catch (SQLException e) { 
			
			e.printStackTrace();
		}
		
		if (delete > 0) {
			response.sendRedirect("http://localhost:8081/TaskMaster_CapstoneProject_Group7/welcome.jsp");
		} else {
			PrintWriter writer = response.getWriter();
			writer.write("Unable to delete!");

		}
		
	}

}
