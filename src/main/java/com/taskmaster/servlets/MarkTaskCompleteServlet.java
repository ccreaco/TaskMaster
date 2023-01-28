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
 * The mark task complete servlet is used to mark tasks complete. It will get the taskID based on the specific task that is selected, then call the dao and the update status method. Once that runs, 
 * it will update the status of the task from pending to complete. 
 *  *  
 */

public class MarkTaskCompleteServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;
	private TaskDao dao = new TaskDao();
	private int taskID;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get task id
		taskID = Integer.parseInt(request.getParameter("taskID"));

		int status = 0;

		try {
			// calling the dao
			status = dao.updateStatus(taskID);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		if (status > 0) {

			System.out.print("ERROR");

		} else {

			response.sendRedirect("welcome.jsp");
			PrintWriter write = response.getWriter();
			write.write("Task is complete!");
		}
	}

}
