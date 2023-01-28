package com.taskmaster.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taskmaster.dao.TaskDao;
import com.taskmaster.beans.Task;
import com.taskmaster.services.TaskServices;

/*
 * This is the task servlet. It is called when the user selects to add a new task, the user will be prompted to the addtask.jsp, and a form will take in the task information. 
 * The servlet will be called once the user submits the form, it will retrieve the parameters for the task, create a new task and then call the dao to insert the task into the
 * database. 
  * 
 */

public class TaskServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Task task;
	private TaskDao dao = new TaskDao();


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		
		String name = request.getParameter("taskName"); 
		String targetDate = request.getParameter("targetDate");
		
		
		task = new Task(name, targetDate);
		
		int rows = 0;
		
		try { 
			
			rows = dao.insertTask(task);
			
		} catch (SQLException e) { 
			
			e.printStackTrace();
		}
		
		if (rows == 0) { 
			request.setAttribute("error", "Please try again.");
			  request.getRequestDispatcher("/addtask.jsp").include(request, response);
		} else { 
			response.sendRedirect("http://localhost:8081/TaskMaster/welcome.jsp");
		}
		

		
	}

}
